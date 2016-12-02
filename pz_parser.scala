package pzjson

class PzParser() {

  private def EOI: Char = '\uFFFF'
  private var currentCursor: Int = _;
  private var rawInput: String = _;
  private var inputLength:Int = _;
  private var currentChar: Char = _;
  private def nextChar: Char = {
    currentCursor += 1
    if (currentCursor < inputLength) {
      currentChar = rawInput.charAt(currentCursor)
    }
    else
      currentChar = EOI

    currentChar
  }
  private def next = { currentChar = nextChar; true}
  private def isCh(c: Char): Boolean =  if (currentChar == c) next else false

  def parse(json: String): (PzValue, PzParseResult) = {
    rawInput = json
    inputLength = rawInput.length
    currentCursor = -1;
    currentChar = nextChar
    currentCursor = 0

    /** JSON-text = ws value ws**/
    parseWhitespace
    parseValueAndWhitespace
  }

  private def parseWhitespace: Char = currentChar match {
    case ' ' | '\t' | '\n' | '\r' => { nextChar; parseWhitespace}
    case _ => currentChar
  }
  private def parseValueAndWhitespace: (PzValue,PzParseResult) = {
    val result = currentChar match {
      case '\uFFFF' => (Null, PZ_PARSE_EXPECT_VALUE)
      case 't' | 'f' | 'n' => parseLiteral
      case '"' => parseString
      case '\0' => (Null, PZ_PARSE_EXPECT_VALUE)
      case _ => {
        parseNumber
      }
    }
    result match {
      case (v, PZ_PARSE_OK) => parseWhitespace match {
        case '\uFFFF' => (v, PZ_PARSE_OK)
        case _ => (Null, PZ_PARSE_ROOT_NOT_SINGULAR)
      }
      case (_, p) => (Null, p)
    }
  }
  private def parseLiteral: (PzValue,PzParseResult) = {
    if(isCh('n')&& isCh('u') && isCh('l') && isCh('l')) return (Null, PZ_PARSE_OK)
    if(isCh('t')&& isCh('r') && isCh('u') && isCh('e')) return (B(true), PZ_PARSE_OK)
    if(isCh('f')&& isCh('a') && isCh('l') && isCh('s')&& isCh('e')) return (B(false), PZ_PARSE_OK)
    (Null, PZ_PARSE_INVALID_VALUE)
  }

  private def parseNumber: (PzValue, PzParseResult) = {
    def isDigit1To9(c: Char) = (c >= '1' && c <= '9')
    def isDigit(c: Char) = (c >= '0' && c <= '9')
    def toDouble(s: String): Option[Double] = {
      try {
        Some(s.toDouble)
      } catch {
        case e: NumberFormatException => None
      }
    }
    isCh('-')
    if (!isCh('0')) {
      if (!isDigit1To9(currentChar)) return (Null, PZ_PARSE_INVALID_VALUE)
      while (isDigit(currentChar)) next
    }
    if (isCh('.')) {
      if (!isDigit(currentChar)) return (Null, PZ_PARSE_INVALID_VALUE)
      while (isDigit(currentChar)) next
    }
    if (isCh('e') || isCh('E')) {
      isCh('+') || isCh('-')
      if (!isDigit(currentChar)) return (Null, PZ_PARSE_INVALID_VALUE)
      while (isDigit(currentChar)) next
    }
    toDouble(rawInput.substring(0, currentCursor)) match {
      case None => (Null, PZ_PARSE_ROOT_NOT_SINGULAR)
      case Some(n) => n match {
        case Double.NegativeInfinity => (Null, PZ_PARSE_NUMBER_TOO_BIG)
        case Double.PositiveInfinity => (Null, PZ_PARSE_NUMBER_TOO_BIG)
        case _ => (N(n), PZ_PARSE_OK)
      }
    }
  }
  private def parseString: (PzValue, PzParseResult) ={
    def isEscape = List('b', 'f', 'n', 'r', 't', 'u', '\\', '\"', '/') contains currentChar
    def makeEscape(s: Char) = s match {
      case 'b' => '\b'
      case 'f' => '\f'
      case 'n' => '\n'
      case 'r' => '\r'
      case 't' => '\t'
      case any => any
    }
    def parseHex4(s: Char, count: Int, u: Int): Option[Int] = {
      if(count >= 4) return Some(u)
      val t = u << 4;
      val ch = s
      if(ch >= '0' && ch <= '9' ) parseHex4(nextChar, count+1, (t | (ch-'0')))
      else if(ch >= 'A' && ch <= 'F' ) parseHex4(nextChar, count+1, (t | (ch- ('A' - 10))))
      else if(ch >= 'a' && ch <= 'f' ) parseHex4(nextChar, count+1, (t | (ch- ('a' - 10))))
      else  None
    }
    def encodeUTF8(u: Int): String = {
      if(u <= 0x7F) u.toChar.toString
      else if( u <= 0x7FF) {
        val s = (0xC0 | ((u >>> 6) & 0xFF)).toChar
        val ss = (0x80 | ( u       & 0x3F)).toChar
        return (s.toString + ss.toString)
      }
      else if (u <= 0xFFFF) {
        val s = (0xE0 | ((u >>> 12) & 0xFF)).toChar.toString
        val ss = (0x80 | ((u >>>  6) & 0x3F)).toChar.toString
        val sss = (0x80 | ( u        & 0x3F)).toChar.toString
        s+ss+sss
      } else {
        assert(u <= 0x10FFFF)
        val s = (0xF0 | ((u >>> 18) & 0xFF)).toChar.toString
        val ss = (0x80 | ((u >>> 12) & 0x3F)).toChar.toString
        val sss = (0x80 | ((u >>>  6) & 0x3F)).toChar.toString
        val ssss = (0x80 | ( u        & 0x3F)).toChar.toString
        s+ss+sss+ssss
      }
    }
    def ps(ch: Char, str: PzValue): (PzValue, PzParseResult) = {
      ch match {
        case '"' => next; (str, PZ_PARSE_OK)
        case '\0' => (str, PZ_PARSE_MISS_QUOTATION_MARK)
        case '\\' => {
          if(next && isEscape){
            currentChar match {
              case 'u' => {
                var res: Int = 0
                parseHex4(nextChar, 0, 0) match {
                  case None => return (Null, PZ_PARSE_INVALID_UNICODE_HEX)
                  case Some(u) => {
                    res = u
                    if (u >= 0xD800 && u <= 0xDBFF) {
                      if (!isCh('\\')) return (str, PZ_PARSE_INVALID_UNICODE_SURROGATE)
                      if (!isCh('u')) return (str, PZ_PARSE_INVALID_UNICODE_SURROGATE)
                      parseHex4(currentChar, 0, 0) match {
                        case None => return (Null, PZ_PARSE_INVALID_UNICODE_HEX)
                        case Some(u2) => {
                          if (u2 < 0xDC00 || u2 > 0xDFFF)
                            return (str, PZ_PARSE_INVALID_UNICODE_SURROGATE)
                          res = (((u - 0xD800) << 10) | (u2 - 0xDC00)) + 0x10000
                        }
                      }
                    }
                  }
                }
                str match {
                  case S(s) => {
                    val encoded = encodeUTF8(res)
                    ps(currentChar, S(s + encoded))
                  }
                }
              }
              case _ => str match{
                case S(s) => val ch = currentChar; ps(nextChar, S(s + makeEscape(ch)))
              }
            }
          } else {
            (str, PZ_PARSE_INVALID_STRING_ESCAPE)
          }
        }
        case '\uFFFF' => (str, PZ_PARSE_OK)
        case _ => str match{
          case S(s) => val ch = currentChar; ps(nextChar, S(s + ch))
          case _ => (str , PZ_PARSE_INVALID_VALUE)
        }
      }
    }

    ps(nextChar, S(""))
  }
}

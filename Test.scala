import org.scalatest._
import pzjson._


class Test extends FlatSpec with Matchers {
  def p = new PzParser
  def parse(arg: String) = p.parse(arg)

  def TEST_STRING(s1: String, s2: String) = {
    parse(s2) should be (S(s1), PZ_PARSE_OK)
  }
  def TEST_NUMBER(n1: Double, s2: String) = {
    parse(s2) should be (N(n1), PZ_PARSE_OK)
  }

  def TEST_ERROR(p1: PzParseResult, s2: String) = {
    parse(s2) should be (Null, p1)
  }


  "The parser" should "be able to parse a null value" in {
    parse("null") should be (Null, PZ_PARSE_OK)
  }

  "The parser" should "be able to parse a true value" in {
    parse("true") should be (B(true), PZ_PARSE_OK)
  }

  "The parser" should "be able to parse a false value" in {
    parse("false") should be (B(false), PZ_PARSE_OK)
  }

  "The parser" should "parse empty json as EXPECT_VALUE" in {
    parse("") should be (Null, PZ_PARSE_EXPECT_VALUE)
    parse(" ") should be (Null, PZ_PARSE_EXPECT_VALUE)
  }

  "The parser" should "parse to invalid value" in {
    TEST_ERROR(PZ_PARSE_INVALID_VALUE, "nul");
    TEST_ERROR(PZ_PARSE_INVALID_VALUE, "?");
    TEST_ERROR(PZ_PARSE_INVALID_VALUE, "+0");
    TEST_ERROR(PZ_PARSE_INVALID_VALUE, "+1");
    TEST_ERROR(PZ_PARSE_INVALID_VALUE, ".123");
    TEST_ERROR(PZ_PARSE_INVALID_VALUE, "1.");
    TEST_ERROR(PZ_PARSE_INVALID_VALUE, "INF");
    TEST_ERROR(PZ_PARSE_INVALID_VALUE, "inf");
    TEST_ERROR(PZ_PARSE_INVALID_VALUE, "NAN");
    TEST_ERROR(PZ_PARSE_INVALID_VALUE, "nan");
  }

  "The parser" should "parse root to not singular" in {
    TEST_ERROR(PZ_PARSE_ROOT_NOT_SINGULAR, "null x");

    /* invalid number */
    TEST_ERROR(PZ_PARSE_ROOT_NOT_SINGULAR, "0123"); /* after zero should be '.' or nothing */
    TEST_ERROR(PZ_PARSE_ROOT_NOT_SINGULAR, "0x0");
    TEST_ERROR(PZ_PARSE_ROOT_NOT_SINGULAR, "0x123");
  }
  "The parser" should "parse as big number" in {
    parse("1e309") should be (Null, PZ_PARSE_NUMBER_TOO_BIG)
    parse("-1e309") should be (Null, PZ_PARSE_NUMBER_TOO_BIG)
  }
  "The parser" should "parse invalid string escape" in {
    TEST_ERROR(PZ_PARSE_INVALID_STRING_ESCAPE, "\"\\v\"");
    TEST_ERROR(PZ_PARSE_INVALID_STRING_ESCAPE, "\"\\'\"");
    TEST_ERROR(PZ_PARSE_INVALID_STRING_ESCAPE, "\"\\0\"");
    TEST_ERROR(PZ_PARSE_INVALID_STRING_ESCAPE, "\"\\x12\"");

  }


  "The parser" should "parse number correctly" in {
    TEST_NUMBER(0.0, "0");
    TEST_NUMBER(0.0, "-0");
    TEST_NUMBER(0.0, "-0.0");
    TEST_NUMBER(1.0, "1");
    TEST_NUMBER(-1.0, "-1");
    TEST_NUMBER(1.5, "1.5");
    TEST_NUMBER(-1.5, "-1.5");
    TEST_NUMBER(3.1416, "3.1416");
    TEST_NUMBER(1E10, "1E10");
    TEST_NUMBER(1e10, "1e10");
    TEST_NUMBER(1E+10, "1E+10");
    TEST_NUMBER(1E-10, "1E-10");
    TEST_NUMBER(-1E10, "-1E10");
    TEST_NUMBER(-1e10, "-1e10");
    TEST_NUMBER(-1E+10, "-1E+10");
    TEST_NUMBER(-1E-10, "-1E-10");
    TEST_NUMBER(1.234E+10, "1.234E+10");
    TEST_NUMBER(1.234E-10, "1.234E-10");
    TEST_NUMBER(0.0, "1e-10000");




    TEST_NUMBER(1.0000000000000002, "1.0000000000000002"); /* the smallest number > 1 */
    TEST_NUMBER( 4.9406564584124654e-324, "4.9406564584124654e-324"); /* minimum denormal */
    TEST_NUMBER(-4.9406564584124654e-324, "-4.9406564584124654e-324");
    TEST_NUMBER( 2.2250738585072009e-308, "2.2250738585072009e-308");  /* Max subnormal double */
    TEST_NUMBER(-2.2250738585072009e-308, "-2.2250738585072009e-308");
    TEST_NUMBER( 2.2250738585072014e-308, "2.2250738585072014e-308");  /* Min normal positive double */
    TEST_NUMBER(-2.2250738585072014e-308, "-2.2250738585072014e-308");
    TEST_NUMBER( 1.7976931348623157e+308, "1.7976931348623157e+308");  /* Max double */
    TEST_NUMBER(-1.7976931348623157e+308, "-1.7976931348623157e+308");




  }
  "The parser" should "parse string correctly" in{
    TEST_STRING("", "\"\"");
    TEST_STRING("Hello", "\"Hello\"");
    TEST_STRING("Hello\nWorld", "\"Hello\\nWorld\"");
    TEST_STRING("\" \\ / \b \f \n \r \t", "\"\\\" \\\\ \\/ \\b \\f \\n \\r \\t\"");
    TEST_STRING("\u0024", "\"\\u0024\"");         /* Dollar sign U+0024 */
    TEST_STRING("Hello\0World", "\"Hello\\u0000World\"");
    TEST_STRING("\u00C2\u00A2", "\"\\u00A2\"");     /* Cents sign U+00A2 */
    TEST_STRING("\u00E2\u0082\u00AC", "\"\\u20AC\""); /* Euro sign U+20AC */
    TEST_STRING("\u00EF\u00BF\u00BF", "\"\\uFFFF\"");  /* G clef sign U+1D11E */
    TEST_STRING("\u00F0\u009D\u0084\u009E", "\"\\uD834\\uDD1E\"");  /* G clef sign U+1D11E */
    TEST_STRING("\u00F0\u009D\u0084\u009E", "\"\\ud834\\udd1e\"");  /* G clef sign U+1D11E */

  }

  "The parser" should "parse invalid unicode hex" in {
    TEST_ERROR(PZ_PARSE_INVALID_UNICODE_HEX, "\"\\u\"");
    TEST_ERROR(PZ_PARSE_INVALID_UNICODE_HEX, "\"\\u0\"");
    TEST_ERROR(PZ_PARSE_INVALID_UNICODE_HEX, "\"\\u01\"");
    TEST_ERROR(PZ_PARSE_INVALID_UNICODE_HEX, "\"\\u012\"");
    TEST_ERROR(PZ_PARSE_INVALID_UNICODE_HEX, "\"\\u/000\"");
    TEST_ERROR(PZ_PARSE_INVALID_UNICODE_HEX, "\"\\uG000\"");
    TEST_ERROR(PZ_PARSE_INVALID_UNICODE_HEX, "\"\\u0/00\"");
    TEST_ERROR(PZ_PARSE_INVALID_UNICODE_HEX, "\"\\u0G00\"");
    TEST_ERROR(PZ_PARSE_INVALID_UNICODE_HEX, "\"\\u0/00\"");
    TEST_ERROR(PZ_PARSE_INVALID_UNICODE_HEX, "\"\\u00G0\"");
    TEST_ERROR(PZ_PARSE_INVALID_UNICODE_HEX, "\"\\u000/\"");
    TEST_ERROR(PZ_PARSE_INVALID_UNICODE_HEX, "\"\\u000G\"");
  }
  "The parser" should "parse invalid unicode surrogate" in {
    TEST_ERROR(PZ_PARSE_INVALID_UNICODE_SURROGATE, "\"\\uD800\"");
    TEST_ERROR(PZ_PARSE_INVALID_UNICODE_SURROGATE, "\"\\uDBFF\"");
    TEST_ERROR(PZ_PARSE_INVALID_UNICODE_SURROGATE, "\"\\uD800\\\\\"");
    TEST_ERROR(PZ_PARSE_INVALID_UNICODE_SURROGATE, "\"\\uD800\\uDBFF\"");
    TEST_ERROR(PZ_PARSE_INVALID_UNICODE_SURROGATE, "\"\\uD800\\uE000\"");
  }
}

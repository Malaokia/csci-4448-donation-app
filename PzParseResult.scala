package pzjson
/**
  * Created by Pezh on 11/10/16.
  */

sealed abstract class PzParseResult
case object PZ_PARSE_OK extends PzParseResult
case object PZ_PARSE_EXPECT_VALUE extends PzParseResult
case object PZ_PARSE_INVALID_VALUE extends PzParseResult
case object PZ_PARSE_NUMBER_TOO_BIG extends PzParseResult
case object PZ_PARSE_ROOT_NOT_SINGULAR extends PzParseResult
case object PZ_PARSE_MISS_QUOTATION_MARK extends PzParseResult
case object PZ_PARSE_INVALID_STRING_ESCAPE extends PzParseResult
case object PZ_PARSE_INVALID_UNICODE_HEX extends  PzParseResult
case object PZ_PARSE_INVALID_UNICODE_SURROGATE extends PzParseResult

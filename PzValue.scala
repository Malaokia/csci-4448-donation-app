package pzjson
/**
  * Created by Pezh on 11/10/16.
  */

sealed abstract class PzValue
case object Null extends PzValue
case class B(b: Boolean) extends PzValue
case class N(n: Double) extends PzValue
case class S(s: String) extends PzValue
case class A(a: Array[Object]) extends PzValue
case class O(field: Map[String, String]) extends PzValue

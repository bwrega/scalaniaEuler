package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}

class Euler16Spec extends FlatSpec with MustMatchers {

  "Euler16 solution" should "be ???" in {
    val res = (1 to 1000).foldLeft(BigInt(1))((acu, cur) => acu * 2).toString().toList.map(""+_).map(BigInt(_)).sum
    println("Euler15 result is: " + res)
  }

}

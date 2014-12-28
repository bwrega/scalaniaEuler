package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}

class Euler20Spec extends FlatSpec with MustMatchers {
  "Euler20 solution" should "be ???" in {
    val res: BigInt = Range.BigInt.inclusive(1, 100, 1).foldLeft(BigInt(1))(_ * _).toString().toList.map("" + _).map(BigInt(_)).sum
    println("Euler20 solution is: " + res)
  }

}

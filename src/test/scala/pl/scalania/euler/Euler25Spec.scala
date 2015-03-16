package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}

class Euler25Spec extends FlatSpec with MustMatchers {

  "firstWithNDigits(3)" should "be 12" in {
    assert(Euler25.firstWithNDigits(3) === BigInt(12))
  }
  "Answer - firstWithNDigits(1000)" should "be ???" in {
    val answer: Int = Euler25.firstWithNDigits(1000)
    println("first with 1000 digits is: "+answer)
  }
}

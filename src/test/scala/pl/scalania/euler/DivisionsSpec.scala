package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}

class DivisionsSpec extends FlatSpec with MustMatchers {

  "Divisions.exclusive(1)" should "be Seq(1)" in {
    assert(Divisions.exclusive(1) === Nil)
  }
  
  "Divisions.exclusive(10)" should "be Seq(1,2,5)" in {
    assert(Divisions.exclusive(10) === Seq(BigInt(1),2,5))
  }
}

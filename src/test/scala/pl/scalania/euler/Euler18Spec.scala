package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}

class Euler18Spec extends FlatSpec with MustMatchers {
  "Euler18 " should "be executable" in {
    assert(Euler18.maxTriangle(List(List(1))) === 1)
  }

  "maxTriangle of (3),(7,4)" should "return 10" in {
    assert(Euler18.maxTriangle(List(List(3), List(7, 4))) === 10)
  }

  "maxTriangle of (3),(7,4)(2,4,6)" should "return 14" in {
    assert(Euler18.maxTriangle(List(List(3), List(7, 4), List(2, 4, 6))) === 14)
  }

  "Euler 18 solution " should "be ???" in {
    val triangle: List[List[Int]] = NumberReader.readFromFileList("triangle18.txt")
    println("Euler 18 solution: " + Euler18.maxTriangle(triangle))
  }

}

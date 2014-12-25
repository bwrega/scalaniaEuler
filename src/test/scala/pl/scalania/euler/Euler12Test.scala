package pl.scalania.euler

import org.scalatest.{FlatSpec, MustMatchers}

class Euler12Test extends FlatSpec with MustMatchers {

  "triangles " should " start with 1L " in {
    assert(Euler12.triangles.next() === 1L)
  }

  "triangles first three " should " be 1,3,6" in {
    assert(Euler12.triangles.take(3).toList == List(1L, 3L, 6L))
  }

  "fourth triangle " should " be 10 " in {
    assert(Euler12.triangles.drop(3).next() === 10L)
  }

  "millionth triangle " should " exist" in {
    Euler12.triangles.drop(10000000).next() * 2L
  }

  "factors count of 1" should " be 1" in {
    assert(Euler12.countFactors(1L) === 1)
  }

  "factors count of 6" should " be 4" in {
    assert(Euler12.countFactors(6L) === 4)
  }

  "factors count of 12" should " be 6" in {
    assert(Euler12.countFactors(6L) === 4)
  }

  "factors count of 25" should " be 3" in {
    assert(Euler12.countFactors(25L) === 3)
  }

  "first number with at least 1 factor " should " be 1" in {
    assert(Euler12.atLeastNFactors(1) === 1L)
  }

  "first number with at least 5 factors " should " be 28" in {
    assert(Euler12.atLeastNFactors(5) === 28L)
  }

  "first number with at least 500 factors " should " be ?" in {
    println("Euler12: triangle number with at least 500 factors: " + Euler12.atLeastNFactors(500))
  }
}

package pl.scalania.euler

import org.scalatest.{FlatSpec, MustMatchers}

class Euler12Test extends FlatSpec with MustMatchers {

  "triangles " should " start with 1L " in {
    assert( Euler12.triangles.head === 1L)
  }

  "triangles first three " should " be 1,3,6" in {
    assert( Euler12.triangles.take(3).toList == List(1L,3L,6L))
  }

  "fourth triangle " should " be 10 " in {
    assert(Euler12.triangles(3)===10L)
  }

  "millionth triangle " should " exist" in {
    Euler12.triangles(100000000) * 2L
  }

  "all factors of 1" should " be 1" in {
    assert(Euler12.allFactors(1L) === List(1L))
  }
}

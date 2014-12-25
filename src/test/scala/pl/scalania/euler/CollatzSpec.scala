package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}

class CollatzSpec extends FlatSpec with MustMatchers {

  "Collatz of 1 " should " be (1) " in {
    assert(Collatz.collatz(1L).toList === List(1L))
  }

  "Collatz of 8 " should " be (8, 4, 2, 1) " in {
    assert(Collatz.collatz(8L).toList === List(8, 4, 2, 1))
  }

  "Collatz of 3 " should " be (3,10,5,16,8,4,2,1) " in {
    assert(Collatz.collatz(3L).toList === List(3, 10, 5, 16, 8, 4, 2, 1))
  }

}

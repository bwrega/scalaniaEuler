package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}

class Euler14Spec extends FlatSpec with MustMatchers {

  "Collatz of 1 " should " be (1) " in {
    assert(Euler14.collatz(1L).toList === List(1L))
  }

  "Collatz of 8 " should " be (8, 4, 2, 1) " in {
    assert(Euler14.collatz(8L).toList === List(8, 4, 2, 1))
  }

  "Collatz of 3 " should " be (3,10,5,16,8,4,2,1) " in {
    assert(Euler14.collatz(3L).toList === List(3, 10, 5, 16, 8, 4, 2, 1))
  }

  "longest Collats of (1..3) " should " be 3 " in {
    assert(Euler14.longestCollatzTo(3L) === 3L)
  }

  "Euler14 solution: longest Collatz of (1..1000000) " should " be ??? " in {
    val longest: Long = Euler14.longestCollatzTo(1000000)
    println("Euler14: number in range (1..1000000) with longest Collatz is " + longest)
    println("Euler14: Collatz sequence: " + Euler14.collatz(longest).toList)
  }
}

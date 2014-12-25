package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}

class Euler14Spec extends FlatSpec with MustMatchers {

  "longest Collatz of (1..3) " should " be 3 " in {
    assert(Euler14.longestCollatzTo(3L) === 3L)
  }

  "Euler14 solution: longest Collatz of (1..1000000) " should " be ??? " in {
    val longest: Long = Euler14.longestCollatzTo(1000000)
    println("Euler14: number in range (1..1000000) with longest Collatz is " + longest)
    println("Euler14: Collatz sequence: " + Euler14.collatz(longest).toList)
  }

  "main solution" should " come in less than 7s" in {
    val start: Long = System.currentTimeMillis
    Euler14.longestCollatzTo(1000000)
    assert(System.currentTimeMillis() - start < 7000)
  }
}

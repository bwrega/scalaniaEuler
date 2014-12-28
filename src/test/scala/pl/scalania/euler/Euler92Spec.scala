package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}

class Euler92Spec extends FlatSpec with MustMatchers {

  "chainLast(1)" should "return 1" in {
    assert(Euler92.chainLast(BigInt(1)) === 1)
  }

  "chainLast(2)" should "return 89" in {
    assert(Euler92.chainLast(2) === 89)
  }

  "chainLast(44)" should "return 1" in {
    assert(Euler92.chainLast(44) === 1)
  }

  "chainLast(85)" should "return 89" in {
    assert(Euler92.chainLast(85) === 89)
  }

  "Learning: standard Range " should "be exclusive" in {
    assert(Range(1, 1000).last === 999)
  }

  "count89s(2)" should "return 0" in {
    assert(Euler92.count89s(2) === 0)
  }

  "count89s(3)" should "return 1" in {
    assert(Euler92.count89s(3) === 1)
  }

  "Euler92 solution" should "return ???" in {
    println("Euler92 solution: " + Euler92.count89s(10000000))
  }
}

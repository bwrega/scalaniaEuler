package pl.scalania.euler

import org.scalatest.{FlatSpec, MustMatchers}
import pl.scalania.euler.Implicits.MyBigInt

class Euler65Spec extends FlatSpec with MustMatchers {

  val one: Frac = Frac(1, 1)
  val twoThirds = Frac(2, 3)
  "1/1 + 1/1" should "be 2/1" in {
    assert(one.plus(one) === Frac(2, 1))
  }
  val half: Frac = Frac(1, 2)

  "1/2 + 2/3" should "be 7/6" in {
    assert(half.plus(twoThirds) === Frac(7, 6))
  }

  "2/(1/2) " should "be (4/1)" in {
    assert(Frac.div(2, Frac(1, 2)) === Frac(4, 1))
  }

  "convergentE(1)" should "return (2,1)" in {
    assert(Euler65.convergentE(1) === Frac(2, 1))
  }

  "convergentE(2)" should "return (3,1)" in {
    assert(Euler65.convergentE(2) === Frac(3, 1))
  }

  "convergentE(3)" should "return (8,3)" in {
    assert(Euler65.convergentE(3) === Frac(8, 3))
  }

  "addend(3)" should "return 2" in {
    assert(Euler65.getAddend(3) === 2)
  }

  "addend(4)" should "return 1" in {
    assert(Euler65.getAddend(4) === 1)
  }

  "convergentE(4)" should "return (11,4)" in {
    assert(Euler65.convergentE(4) === Frac(11, 4))
  }

  "convergentE(10)" should "return (1457,536)" in {
    assert(Euler65.convergentE(10) === Frac(1457, 536))
  }

  "Euler65 solution" should "be ???" in {
    val n: BigInt = Euler65.convergentE(100).n
    println("Euler65 solution is: " + n.sumOfDigits)
  }
}

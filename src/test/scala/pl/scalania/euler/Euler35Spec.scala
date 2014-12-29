package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}
import pl.scalania.euler.Implicits.MyBigInt

class Euler35Spec extends FlatSpec with MustMatchers {
  "Euler35.rotations(719)" should "be Set(719,197,971)" in {
    assert(Euler35.rotations(BigInt(719)) === Set(719, 197, 971))
  }

  "Euler35.rotations(1234)" should "be Set(1234,2341,3412,4123)" in {
    assert(Euler35.rotations(1234) === Set(1234, 2341, 3412, 4123))
  }

  "allRotationsPrimes(719) " should "return true" in {
    assert(Euler35.allRotationsPrimes(BigInt(719)) === true)
  }

  "allRotationsPrimes(123) " should "return false" in {
    assert(Euler35.allRotationsPrimes(BigInt(123)) === false)
  }

  "containsEvenDigit(123)" should "return true" in {
    assert(BigInt(123).containsEvenDigit === true)
  }

  "containsEvenDigit(719)" should "return false" in {
    assert(BigInt(719).containsEvenDigit === false)
  }

  "countCircularPrimesBelow(3)" should "return 1" in {
    assert(Euler35.countCircularPrimesBelow(BigInt(3)) === 1)
  }

  "countCircularPrimesBelow(100)" should "return 13" in {
    assert(Euler35.countCircularPrimesBelow(BigInt(100)) === 13)
  }

  "Euler35 solution: countCircularPrimesBelow(1000000)" should "return 13" in {
    println("Euler35 solution is: " + Euler35.countCircularPrimesBelow(BigInt(1000000)))
  }

}

package pl.scalania.euler

import pl.scalania.euler.Implicits.{MyBigInt, MyBigIntList}
import pl.scalania.euler.Primes.isPrime

import scala.annotation.tailrec

object Euler35 {
  def countCircularPrimesBelow(ceil: BigInt): Int = {
    val fixForTwo = 1
    fixForTwo + (BigInt(3) until ceil).filterNot(_.containsEvenDigit)
      .filter(isPrime)
      .count(allRotationsPrimes)
  }

  def allRotationsPrimes(n: BigInt): Boolean = {
    rotations(n).forall(isPrime)
  }

  def rotations(n: BigInt): Set[BigInt] = {
    @tailrec
    def rotationsRec(n: BigInt, acu: List[BigInt]): List[BigInt] = {
      val digits: List[BigInt] = n.digits
      if (acu.size == digits.size)
        acu
      else {
        val newN = (digits.tail :+ digits.head).toBigInt
        rotationsRec(newN, newN :: acu)
      }

    }
    rotationsRec(n, Nil).toSet
  }

}

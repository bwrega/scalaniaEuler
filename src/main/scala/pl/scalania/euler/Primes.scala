package pl.scalania.euler

import scala.math.BigDecimal.double2bigDecimal

object Primes {
  private var cache = Map[BigInt, Boolean]()

  def isPrime(n: BigInt) = {
    def calculateIsPrime: Boolean = {
      val sqrt: BigInt = Math.sqrt(n.toDouble).toBigInt()
      if ((BigInt(2) to sqrt).exists(n % _ == BigInt(0)))
        false
      else
        true
    }
    cache.getOrElse(n, {
      val ret = calculateIsPrime
      cache += n -> ret
      ret
    })
  }

}

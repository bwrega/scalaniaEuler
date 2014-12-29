package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}

class PrimeSpec extends FlatSpec with MustMatchers {

  "Primes.isPrime(2)" should "be true" in {
    assert(Primes.isPrime(BigInt(2)) === true)
  }

  "Primes.isPrime(4)" should "be false" in {
    assert(Primes.isPrime(BigInt(4)) === false)
  }

  "Primes.isPrime(29)" should "be true" in {
    assert(Primes.isPrime(BigInt(29)) === true)
  }

  "Primes.isPrime(65536)" should "be true" in {
    assert(Primes.isPrime(BigInt(29)) === true)
  }

  val bigPrime: BigInt = BigInt("10000000000283")

  "value from cache " should "be at least 100 x faster" in {
    val firstStart: Long = System.currentTimeMillis()
    val p: Boolean = Primes.isPrime(bigPrime)
    val firstTime: Long = System.currentTimeMillis() - firstStart
    assert(p === true)
    val secondStart: Long = System.currentTimeMillis()
    Primes.isPrime(bigPrime)
    val secondTime = System.currentTimeMillis() - secondStart
    assert(secondTime < firstTime / 100L)
  }

}

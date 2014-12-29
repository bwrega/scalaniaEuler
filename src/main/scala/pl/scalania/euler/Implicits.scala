package pl.scalania.euler

object Implicits {

  implicit class MyBigInt(n: BigInt) {
    def sumOfDigits: BigInt = {
      digits.foldLeft(BigInt(0))(_ + _)
    }

    def digits: List[BigInt] = {
      n.toString().toList.map(_.toString).map(BigInt(_))
    }

    def containsEvenDigit: Boolean = {
      digits.exists(_ % 2 == 0)
    }

    def isPrime: Boolean = Primes.isPrime(n)
  }

  implicit class MyBigIntList(digits: List[BigInt]) {
    def toBigInt: BigInt =
      BigInt(digits.foldLeft("")(_ + _))
  }

}

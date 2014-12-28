package pl.scalania.euler

object Implicits {

  implicit class MyBigInt(n: BigInt) {
    def sumOfDigits: BigInt = {
      n.toString().toList.map(_.toString).map(BigInt(_)).foldLeft(BigInt(0))(_ + _)
    }
  }

}

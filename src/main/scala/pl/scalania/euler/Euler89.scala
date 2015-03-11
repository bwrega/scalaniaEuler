package pl.scalania.euler

import scala.annotation.tailrec

object Euler89 {
  def countMinimizedChars(input: List[String]): Int = {
    input.map(Euler89.minimize).map(_.size).sum
  }

  def minimize(rom: String): String = {
    case class DigitMini(n:Int, to: String) {
      val from = "I"*n
    }
    val digitsMini: List[DigitMini] = List(
      DigitMini(1000, "M"),
      DigitMini(900, "CM"),
      DigitMini(500, "D"),
      DigitMini(400, "CD"),
      DigitMini(100, "C"),
      DigitMini(90, "XC"),
      DigitMini(50, "L"),
      DigitMini(40, "XL"),
      DigitMini(10, "X"),
      DigitMini(9, "IX"),
      DigitMini(5, "V"),
      DigitMini(4, "IV")
    )
    def replaceReverseAll(in: String, digits: List[DigitMini]): String = digits match {
      case Nil => in
      case h :: t =>
        replaceReverseAll(in.replaceAll(h.from, h.to), t)
    }
    val demini = deminimize(rom)
    replaceReverseAll(demini, digitsMini)
  }


  val digits: List[RomanDigit] = List(
    RomanDigit(4, "IV"),
    RomanDigit(5, "V"),
    RomanDigit(9, "IX"),
    RomanDigit(40, "XL"),
    RomanDigit(90, "XC"),
    RomanDigit(400, "CD"),
    RomanDigit(900, "CM"),
    RomanDigit(10, "X"),
    RomanDigit(50, "L"),
    RomanDigit(100, "C"),
    RomanDigit(500, "D"),
    RomanDigit(1000, "M")
  )

  def deminimize(in: String): String = {
    @tailrec
    def replaceAll(in: String, digits: List[RomanDigit]): String = digits match {
      case Nil => in
      case h :: t =>
        val d = digits.head
        replaceAll(in.replaceAll(d.r, d.replaceString), t)
    }
    @tailrec
    def repeatUntilDoesNotChange(acu: String): String = {
      val newAcu = replaceAll(acu, digits)
      if (acu == newAcu)
        acu
      else
        repeatUntilDoesNotChange(newAcu)
    }
    replaceAll(in, digits)
  }

  case class RomanDigit(n: BigInt, r: String) {
    lazy val replaceString: String = "I" * n.intValue()
  }

}

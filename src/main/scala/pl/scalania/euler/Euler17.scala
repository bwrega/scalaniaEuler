package pl.scalania.euler

object Euler17 {
  def solution(): Int = Range.inclusive(1,1000,1).map(spell(_)).map(_.size).sum

  def count(i: Int) = spell(i).length

  val lowsDict = List(
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
    "ten",
    "eleven",
    "twelve",
    "thirteen",
    "fourteen",
    "fifteen",
    "sixteen",
    "seventeen",
    "eighteen",
    "nineteen"
  )

  val tensDict = List(
    "NONE",
    "NONE",
    "twenty",
    "thirty",
    "forty",
    "fifty",
    "sixty",
    "seventy",
    "eighty",
    "ninety"
  )

  def spell(i: Int): String = {
    val mod100: String = {
      val mod100 = i % 100
      if (mod100 < 20)
        lowsDict(mod100)
      else {
        val lastDigit = if ((mod100 % 10) == 0) "" else lowsDict(mod100 % 10)
        tensDict(mod100 / 10) + lastDigit
      }
    }
    val hundredsAnd: String = {
      val h = i / 100
      if (h == 0)
        ""
      else {
        val hundreds: String = lowsDict(h) + "hundred"
        if (i % 100 == 0)
          hundreds
        else
          hundreds + "and"
      }
    }
    if (i == 1000)
      "onethousand"
    else if (hundredsAnd != "" && i % 100 == 0)
      hundredsAnd
    else
      hundredsAnd + mod100
  }

}

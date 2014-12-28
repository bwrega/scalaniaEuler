package pl.scalania.euler


object Euler65 {


  def convergentE(stop: Int): Frac = {
    def getDenominator(i: Int): Frac = {
      val addend: BigInt = getAddend(i)
      if (i == stop)
        Frac(addend, 1)
      else
        Frac(addend, 1)
          .plus(Frac.div(1, getDenominator(i + 1)))
    }
    val first: Frac = Frac(2, 1)
    if (stop == 1)
      first
    else
      first.plus(Frac.div(1, getDenominator(2)))
  }

  def getAddend(i: Int): BigInt = if ((i - 2) % 3 == 1) {
    val n = 1 + (i - 1) / 3
    2 * n
  } else 1
}

case class Frac(n: BigInt, d: BigInt) {
  def plus(b: Frac): Frac = {
    Frac(n * b.d + b.n * d, d * b.d)
  }

  def inv = Frac(d, n)
}

object Frac {
  def div(n: BigInt, f: Frac): Frac = Frac(n * f.d, f.n)
}


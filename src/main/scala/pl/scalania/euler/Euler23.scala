package pl.scalania.euler

import scala.annotation.tailrec

object Euler23 {

  def isCreatable(i: BigInt) = {
    def isCreatableRec(currentAgainst:BigInt, abundantsLeft:Seq[BigInt]):Boolean = abundantsLeft match {
      case Nil => false
      case h +: tail => if (h+currentAgainst==i)
          true
        else
          isCreatableRec(currentAgainst, tail)
    }
    @tailrec
    def isCreatableWider(abundants:Seq[BigInt]):Boolean = abundants match {
      case Nil => false
      case head+:tail => {
        val current: Boolean = isCreatableRec(head, abundants)
        if (current)
          true
        else
          isCreatableWider(abundants.tail)
      }
    }
    if (i.toInt % 1000 == 0)
      println("processing " + i)
    isCreatableWider(abundants.takeWhile(i>=_))
  }

  def isAbundant(i: BigInt):Boolean = {
    val divisors = Divisions.exclusive(i)
    i < divisors.sum
  }

  private val abundatsCeil: BigInt = 28123
  lazy val abundants: Seq[BigInt] =
    Range.BigInt.inclusive(2, abundatsCeil, 1)
      .filter(isAbundant)

  lazy val allNotCreatableFromAbundants: Seq[BigInt] =
    Range.BigInt.inclusive(1, abundatsCeil, 1)
      .filterNot(isCreatable)

  lazy val allNotCreatable2 = {
    var abundantSums:Set[BigInt] = Set()
    var x:BigInt=0
    var y:BigInt=0
    for (x <- abundants) {
      for (y <- abundants) {
        abundantSums += (x+y)
      }
    }
    Range.BigInt.inclusive(1, abundatsCeil, 1)
      .filterNot(abundantSums.contains)
  }
}

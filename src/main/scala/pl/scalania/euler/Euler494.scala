package pl.scalania.euler

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory
import pl.scalania.euler.euler494.Change
import pl.scalania.euler.euler494.Change.{inverse, down, up}

case class Stats(forwards: Map[List[Change], List[List[Long]]], reverses: Set[List[Change]])

object Euler494 extends Collatz {
  def countPaths(powerOfTwo: Long, lengthO: Int): Int = {
    def countPathsOdd(n: Long, length: Int): Int = {
      def p(t:Any) = println("  "*(lengthO-length)+t)
      p("length: " + length + " n: " + n)
      length match {
        case 0L => {
          p("retStop length: " + length + " n: " + n)
          1
        }
        case _ =>
          val bigger: Int = countPathsOdd(2L * n, length - 1)
          p("retBigger length: " + length + " n: " + n + " bigger: " + bigger)
          val smaller: Int = {
            if (canGetSmaller(n) && length > 1)
              countPathsOdd((n - 1L) / 3L, length - 1)
            else
              0
          }
          p("retSmaller length: " + length + " n: " + n + " smaller: " + smaller)
          bigger + smaller
      }
    }
    def canGetSmaller(n: Long): Boolean = {
      (n - 1L) % 3L == 0L
    }
    println("woot")
    if (canGetSmaller(powerOfTwo))
      countPathsOdd((powerOfTwo - 1) / 3, lengthO)
    else
      0
  }

  val log = Logger(LoggerFactory.getLogger(Euler494.getClass.toString))

  def collectFamilies(familyLength: Int, limit: Int): Stats = {
    val pf = (1 to limit).map(prefix(_)).filter(_.size == familyLength)
    val forw = pf.foldLeft(Map[List[Change], List[List[Long]]]().withDefaultValue(List()))({ case (forw: Map[List[Change], List[List[Long]]], cur) =>
      val key: List[Change] = upDownsForward(cur)
      forw + ((key, cur +: forw(key)))
    })
    Stats(forw, Set())
  }

  def prefix(n: Long): List[Long] = {
    val rev: List[Long] = collatz(n).reverse.toList
    if (n % 100000 == 0)
      log.debug("prefix for " + n)
    rev.zip(up +: upDownsForward(rev)).dropWhile(_._2 == up).map(_._1).reverse
  }

  def relativePrefix(n: Long): List[Change] = upDownsForward(prefix(n))

  def upDownsReverse(nums: Seq[Long]): List[Change] = inverse(upDownsForward(nums))

  def upDownsForward(nums: Seq[Long]): List[Change] = {
    nums.zip(1L +: nums).drop(1).map {
      case (cur, prev) => if (cur < prev) down else up
    }.toList
  }
}



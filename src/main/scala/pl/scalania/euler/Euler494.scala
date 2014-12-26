package pl.scalania.euler

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory
import pl.scalania.euler.euler494.Change
import pl.scalania.euler.euler494.Change.{inverse, down, up}

case class Stats(forwards: Set[List[Change]], reverses: Set[List[Change]])

object Euler494 extends Collatz {
  val log = Logger(LoggerFactory.getLogger(Euler494.getClass.toString))

  def collectFamilies(familyLength: Int, limit: Int): Stats = {
    val pf = (1 to limit).map(prefix(_)).filter(_.size == familyLength)
    pf.foreach((p) =>println(p.last))
    val (forw, rev) = pf.foldLeft((Set[List[Change]](), Set[List[Change]]()))({ case ((forw, rev), cur) =>
      (forw + upDownsForward(cur), rev + upDownsReverse(cur))
    })
    Stats(forw, rev)
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



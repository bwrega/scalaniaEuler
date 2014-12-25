package pl.scalania.euler

import scala.annotation.tailrec

object Euler12 {
  def atLeastNFactors(i: Int): Long = {
    triangles.dropWhile(countFactors(_) < i).next()
  }

  def countFactors(l: Long): Int = {
    val sqrt = Math.sqrt(l).toLong
    @tailrec
    def factorsToRoot(i: Long, acc: Int): Int = {
      if (i > sqrt)
        acc
      else
        factorsToRoot(i + 1, acc + {
          if ((l % i) == 0)
            1
          else
            0
        })
    }
    def squareFix() = if (sqrt * sqrt == l) 1 else 0
    factorsToRoot(1, 0) * 2 - squareFix()
  }

  def triangles: Iterator[Long] = {
    def trianglesProduces(i_sum: (Long, Long)): (Long, Long) = i_sum match {
      case (i, sum) => (i + 1L, sum + i + 1L)
    }
    Iterator.iterate((1L, 1L))(trianglesProduces).map(_._2)
  }
}

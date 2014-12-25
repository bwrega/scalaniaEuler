package pl.scalania.euler

object Euler14 extends Collatz {
  def longestCollatzTo(l: Long): Long = {
    Range.Long.inclusive(1, l, 1).maxBy(collatz(_).size)
  }
}

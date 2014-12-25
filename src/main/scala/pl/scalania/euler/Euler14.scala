package pl.scalania.euler

object Euler14 {
  def longestCollatzTo(l: Long): Long = {
    Range.Long.inclusive(1, l, 1).maxBy(collatz(_).size)
  }

  def collatz(n: Long): Stream[Long] = {
    lazy val next = if (n % 2L == 0L) n / 2L else 3L * n + 1L
    if (n == 1L)
      Stream(1L)
    else
      Stream.cons(n, collatz(next))
  }
}

package pl.scalania.euler

trait Collatz {
  def collatz(n: Long): Stream[Long] = Collatz.collatz(n)
}

object Collatz {
  var resultsCache: Map[Long, Stream[Long]] = Map[Long, Stream[Long]]()

  def collatz(n: Long): Stream[Long] = {
    if (n == 1) {
      Collatz.resultsCache += n -> Stream(1L)
      Stream(1L)
    } else {
      lazy val next = if (n % 2L == 0L) n / 2L else 3L * n + 1L
      lazy val collatzForNext: Stream[Long] = {
        val nc: Stream[Long] = collatz(next)
        Collatz.resultsCache += next -> nc
        nc
      }
      Stream.cons(n, Collatz.resultsCache.getOrElse(next, collatzForNext))
    }
  }
}

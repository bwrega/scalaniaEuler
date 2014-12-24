package pl.scalania.euler

object Euler12 {
  def allFactors(l: Long):List[Long] = {
    List(22)
  }

  def triangles: Stream[Long] = {

    def trianglesRec(currentI:Long, previousSum:Long):Stream[Long] = {
      val newSum = previousSum + currentI
      Stream.cons(newSum, trianglesRec(currentI + 1, newSum))
    }
    trianglesRec(1L, 0L)
  }
}

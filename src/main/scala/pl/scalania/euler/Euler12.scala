package pl.scalania.euler

object Euler12 {
  def allFactors(l: Long):List[Long] = {
    List(1)
  }

  def triangles: Iterator[Long] = {
    def trianglesProduces( i_sum:(Long, Long) ) : (Long, Long)  = i_sum match {
      case (i, sum) => (i+1L, sum+i+1L)
    }
    Iterator.iterate((1L,1L))(trianglesProduces).map(_._2)
  }
}

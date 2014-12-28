
package pl.scalania.euler

object Euler18 {
  def maxTriangle(triangle: List[List[Int]]) = {
    var valueCache = Map[(Int, Int), Int]()



    case class Position(triangle: List[List[Int]], row: Int, col: Int) {
      lazy val isLastRow: Boolean = row + 1 == triangle.length

      def left: Option[Position] = if (isLastRow) None else Some(Position(triangle, row + 1, col))

      def right: Option[Position] = if (isLastRow) None else Some(Position(triangle, row + 1, col + 1))

      lazy val value = triangle(row)(col)
      lazy val max: Int = {
        valueCache.getOrElse((row, col), {
          val maxLeft: Int = left.map(_.max).getOrElse(0)
          val maxRight: Int = right.map(_.max).getOrElse(0)
          val ret: Int = if (maxLeft > maxRight)
            maxLeft + value
          else
            maxRight + value
          valueCache += (row, col) -> ret
          ret
        })
      }
    }
    Position(triangle, 0, 0).max
  }

}

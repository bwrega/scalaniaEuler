
package pl.scalania.euler

object Euler18 {
  def maxTriangle(triangle: List[List[Int]]) = {
    Position(triangle, 0, 0).max
  }

  case class Position(triangle: List[List[Int]], row: Int, col: Int) {
    lazy val isLastRow: Boolean = row + 1 == triangle.length

    def left: Option[Position] = if (isLastRow) None else Some(Position(triangle, row + 1, col))

    def right: Option[Position] = if (isLastRow) None else Some(Position(triangle, row + 1, col + 1))

    lazy val value = triangle(row)(col)
    lazy val max: Int = {
      val maxLeft: Int = left.map(_.max).getOrElse(0)
      val maxRight: Int = right.map(_.max).getOrElse(0)
      if (maxLeft > maxRight)
        maxLeft + value
      else
        maxRight + value
    }
  }

}

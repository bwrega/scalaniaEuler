package pl.scalania.euler

object Euler15 {
  type Grid = List[List[BigInt]]

  def replace(g: Grid, r: Int, c: Int, newValue: BigInt): Grid = {
    g.updated(r, g(r).updated(c, newValue))
  }

  def ways(GridSize: Int): BigInt = {
    val grid: Grid = replace(List.fill(GridSize + 1, GridSize + 1)(0), GridSize, GridSize, 1)
    def waysRec(g: Grid, r: Int, c: Int): BigInt = {
      def rep(newValue: BigInt) = replace(g, r, c, newValue)
      val gr = rep({
        val rowPart: BigInt = if (r != GridSize)
          g(r + 1)(c)
        else
          0
        val colPart: BigInt = if (c != GridSize)
          g(r)(c + 1)
        else
          0
        rowPart + colPart
      })
      (r, c) match {
        case (0, 0) => {
          gr(0)(0)
        }
        case (_, 0) => waysRec(gr, r - 1, GridSize)
        case (_, _) => waysRec(gr, r, c - 1)
      }
    }
    waysRec(grid, GridSize, GridSize - 1)
  }

}

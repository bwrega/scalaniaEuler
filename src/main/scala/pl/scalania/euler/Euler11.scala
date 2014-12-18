package pl.scalania.euler

object Euler11 {
  var values = Map[Int, AnyRef]()

  def largestProductInGrid(grid: Array[Array[Int]]): Int = {
    def productsForRow(row: Array[Int]): Iterator[Int] = {
      row.tails.map(_.take(4).product)
    }
    def productsForRowL(row: List[Int]): Iterator[Int] = {
      row.tails.map(_.take(4).product)
    }
    def diagonals(grid: Array[Array[Int]]) = {
      def diagonalsFromFirstRow(grid: Array[Array[Int]]): List[List[Int]] = {
        val start = (List.fill(grid.length)(List(1)), 0)
        grid.foldLeft(start)({
          case ((acu, skipNum), curRow) => {
            val newElems: Array[Int] = curRow.drop(skipNum)
            val newFilled: Array[Int] = newElems ++ List.fill(skipNum)(1)
            (acu.zip(newFilled).map({ case (l, a) => a :: l}), skipNum + 1)
          }
        })._1
      }
       val ret: List[List[Int]] = grid.tails.flatMap(diagonalsFromFirstRow).toList
//      val ret: List[List[Int]] =  diagonalsFromFirstRow(grid)
//      println(ret)
      ret
    }
    val pHorizontal: Array[Int] = grid.flatMap(productsForRow)
    val pVertical: Array[Int] = grid.transpose.flatMap(productsForRow)
    val pDiagSE = diagonals(grid).flatMap(productsForRowL)
    val pDiagNE = diagonals(grid.reverse).flatMap(productsForRowL)
    (pHorizontal ++ pVertical ++ pDiagSE ++ pDiagNE).max
  }
}

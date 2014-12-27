package pl.scalania.euler.euler494

object Euler494Gen {
  def count(length: Int): BigInt = {
    def countRec(length: Int, ups: BigInt, downs: BigInt): BigInt = {
      if (length == 1)
        ups+downs
      else {
        val newUps: BigInt = downs
        val newDowns: BigInt = downs + ups
        countRec(length-1, newUps, newDowns)
      }
//        planned.head * countRec(length - 1, sumElems(List(3, 1), planned))
    }
    if (length<3)
      1
    else
      countRec(length - 2, 1, 1)
  }

  def generate(length: Int): Set[String] = {
    def generateRec(length: Int): Set[String] = {
      if (length == 0)
        Set("")
      else
        generateRec(length - 1).map("d" + _) ++ {
          if (length > 1)
            generateRec(length - 2).map("ud" + _)
          else if (length == 1)
            Set("u")
          else
            Set()
        }
    }
    generateRec(length - 2).map("ud" + _)
  }

  def sumElems(l1: List[Int], l2: List[Int]): List[Int] = {
    (l1++List.fill(l2.size-l1.size)(0), l2++List.fill(l1.size-l2.size)(0)).zipped.map(_ + _)
  }

}

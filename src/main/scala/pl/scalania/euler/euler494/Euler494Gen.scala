package pl.scalania.euler.euler494

object Euler494Gen {
  def count(length: Int): Long = {
    def countRec(length: Int): Long = {
      if (length == 0)
        1L
      else if (length == 1)
        2L
      else
        countRec(length - 1) + countRec(length - 2)
    }
    countRec(length - 2)
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

}

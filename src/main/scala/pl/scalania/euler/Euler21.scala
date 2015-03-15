package pl.scalania.euler


object Euler21 {
  def getAmicableNumbers(ceil: BigInt): Seq[BigInt] = {
    Range.BigInt.apply(2, ceil, 1)
      .filter(testForAmicable)
  }

  private def printingWrapper(fun: (BigInt)=>Boolean)(i:BigInt) :Boolean = {
    if (i % BigInt(10)==BigInt(0))
      println("Working on "+i)
    fun(i)
  }
  def testForAmicable(a: BigInt):Boolean = {
    val b = Divisions.exclusive(a).sum
    val bSum = Divisions.exclusive(b).sum
    bSum==a && a!=b
  }
}

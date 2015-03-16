package pl.scalania.euler.euler22

/**
 * Created by bartek on 3/15/15.
 */
object Euler22 {
  def scoreForAll(names:Seq[String]): BigInt = {
    names.map(scoreExcludingPosition)
      .zipWithIndex
      .map( {case (score,index) => score*(index+1) })
    .sum
  }

  def scoreExcludingPosition(name:String):BigInt = {
    def scoreRec(acu:Int, word:Seq[Char]):Int = word match {
      case Nil => acu
      case h::t => scoreRec(1 + h -'A' + acu, t)
    }
    scoreRec(0, name.toCharArray.toList)
  }
}

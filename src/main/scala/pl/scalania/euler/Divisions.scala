package pl.scalania.euler

import scala.annotation.tailrec

/**
 * Created by bartek on 3/15/15.
 */
object Divisions {
  def exclusive(input: BigInt): Seq[BigInt] = {

    @tailrec
    def divisionsRec(acu: Seq[BigInt], i:BigInt):Seq[BigInt] = {
      if (input == i)
        acu
      else
        if ((input % i) == BigInt(0))
          divisionsRec(i +: acu, i+1)
      else
        divisionsRec(acu, i+1)
    }
    divisionsRec(Nil,1).reverse
  }

}

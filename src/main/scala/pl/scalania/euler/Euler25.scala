package pl.scalania.euler

import scala.annotation.tailrec

object Euler25 {
  def firstWithNDigits(targetDigits: Int) = {
    @tailrec
    def checkNFibonacci(prev:BigInt, prevPrev:BigInt, counter:Int):Int = {
      val current = prev + prevPrev
      if (current.toString().size == targetDigits)
        counter
      else
        checkNFibonacci(current, prev, counter+1)
    }
    checkNFibonacci(0, 1, 1)
  }
}

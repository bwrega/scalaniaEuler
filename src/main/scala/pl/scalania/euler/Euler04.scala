package pl.scalania.euler

import scala.collection.immutable.NumericRange.Inclusive

object Euler04 {

  def largestPalindrome(digits:Int):Long = {
    val wholeRange: Inclusive[Long] = Range.Long.inclusive(start(digits), end(digits), 1L)
    allPalindromes(wholeRange).max
  }

  private def allPalindromes(wholeRange: Inclusive[Long]):IndexedSeq[Long] =
    for {
      x <- wholeRange
      y <- wholeRange.dropWhile(_<x)
      if isPalindrome((x * y).toString)
    } yield x * y

  def start(digits: Int):Long =
    List.fill(digits-1)(10L).foldLeft(1L)( _*_ )

  def end(digits: Int):Long =
    List.fill(digits)(10L).foldLeft(1L)( _*_ ) - 1

  def isPalindrome(word: String):Boolean = {word == word.reverse}
}

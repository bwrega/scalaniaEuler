package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}

class Euler04Spec extends FlatSpec with MustMatchers {

  "Largest palindrome product of 2 digits numbers" should "be " in {
    val result = Euler04.largestPalindrome(2)
    assert(result == 9009)
  }


  "Largest palindrome product of 3 digits numbers" should "be " in {
    val result = Euler04.largestPalindrome(3)
    assert(result == 580085)
  }

}

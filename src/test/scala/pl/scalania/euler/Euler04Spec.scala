package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}

class Euler04Spec extends FlatSpec with MustMatchers {

  "Largest palindrome product " should "be " in {
    val result = Euler04.largestPalindrome(2)
    assert(result == 9009)
  }


}

package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}

class Euler04Spec extends FlatSpec with MustMatchers {

  "Largest palindrome product of 2 digits numbers" should "be " in {
    val result = Euler04.largestPalindrome(2)
    assert(result == 9009)
  }


  "Largest palindrome product of 3 digits numbers" should "be " in {
    val result = Euler04.largestPalindrome(3)
    assert(result == 906609)
  }

  "Largest palindrome product of 4 digits numbers" should "be " in {
    val result = Euler04.largestPalindrome(4)
    assert(result == 99000099)
  }

  "Empty string " should "be palindrome " in {
    val isPalindrome = Euler04.isPalindrome("")
    assert(isPalindrome)
  }

  "One char " should "be palindrome " in {
    val isPalindrome = Euler04.isPalindrome("a")
    assert(isPalindrome)
  }

  "Longer palindrome " should "be palindrome " in {
    val isPalindrome = Euler04.isPalindrome("abcba")
    assert(isPalindrome)
  }

  "Not palindrome " should "not be a palindrome " in {
    val isPalindrome = Euler04.isPalindrome("abcaba")
    assert(!isPalindrome)
  }

  "Start of 4 digits " should "be 1000" in {
    val result: Long = Euler04.start(4)
    assert(result == 1000)
  }

  "End of 4 digits " should "be 9999" in {
    val result: Long = Euler04.end(4)
    assert(result == 9999)
  }

}

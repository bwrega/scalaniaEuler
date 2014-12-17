def isPalindrome(word: String):Boolean = {word == word.reverse}
val wholeRange = Range.Long.inclusive(1L,10L, 1L)
for {
  x <- wholeRange
  y <- wholeRange
  if isPalindrome((x*y).toString)
} yield x*y
2121

5454

10000*10000*10000*10000

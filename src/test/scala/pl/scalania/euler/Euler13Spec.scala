package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}

import scala.io.Source

class Euler13Spec extends FlatSpec with MustMatchers {

  "sum of 1 " should " be 1 " in {
    assert(Euler13.bigSum(List("1")) === BigInt(1))
  }

  "sum of 1,12345678901234567890 " should " be 12345678901234567891 " in {
    assert(Euler13.bigSum(List("1", "12345678901234567890")) === BigInt("12345678901234567891"))
  }

  val numbers: List[String] = Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("euler13_big_numbers.txt")).getLines().toList

  "last number in file " should " be " in {
    assert(numbers.last === "53503534226472524250874054075591789781264330331690")
  }

  "sum of big numbers " should "be " in {
    val sum: BigInt = Euler13.bigSum(numbers)
    println("Euler13: sum of big numbers: " + sum)
    println("Euler13: first ten digits: " + sum.toString().take(10))
  }
}

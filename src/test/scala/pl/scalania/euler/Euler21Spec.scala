package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec, FunSuite}

class Euler21Spec extends FlatSpec with MustMatchers {

    "testAmicable(220)" should "be true" in {
      assert(Euler21.testForAmicable(220) === true)
    }

  "amicable pairs under 10000" should "be" in {
    println(Euler21.getAmicableNumbers(10000))
  }
}

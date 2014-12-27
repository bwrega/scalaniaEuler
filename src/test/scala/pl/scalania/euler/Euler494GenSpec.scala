package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}
import pl.scalania.euler.euler494.Euler494Gen
import pl.scalania.euler.euler494.Euler494Gen.sumElems

class Euler494GenSpec extends FlatSpec with MustMatchers {

  "generate(2) " should "return ud" in {
    assert(Euler494Gen.generate(2) === Set("ud"))
  }

  "generate(3) " should "return udd,udu" in {
    assert(Euler494Gen.generate(3) === Set("udd","udu"))
  }

  "generate(4) " should "return uddd,udud,uddu" in {
    assert(Euler494Gen.generate(4) === Set("uddd", "udud", "uddu"))
  }

  "generate(5) " should "return (udddd, udddu, uddud, ududd, ududu)" in {
    assert(Euler494Gen.generate(5).toList.sorted === Set("udddd", "udddu", "uddud", "ududd", "ududu").toList.sorted)
  }

  "learning: sum of elememts of List(1, 2, 3) and List(1, 2)" should "return (2,4,3)" in {
    assert(sumElems(List(1, 2, 3), List(1, 2)) === List(2, 4, 3))
  }

  "learning: sum of elememts of List(1, 2) and List(1, 2, 3)" should "return (2,4,3)" in {
    assert(sumElems(List(1, 2), List(1, 2, 3)) === List(2, 4, 3))
  }

  "count(2) " should "return 1" in {
    assert(Euler494Gen.count(2) === 1)
  }

  "count(3) " should "return 2" in {
    assert(Euler494Gen.count(3) === 2)
  }

  "count(4) " should "return 3 (uddd, udud, uddu)" in {
    assert(Euler494Gen.count(4) === 3)
  }

  "count(5) " should "return 5" in {
    assert(Euler494Gen.count(5) === 5)
  }

  "count(10) " should "return 55" in {
    assert(Euler494Gen.count(10) === 55)
  }

  "count(20) " should "return 6771" in {
    assert(Euler494Gen.count(20) === 6771)
  }

  "count(90) " should "return ?" in {

    println("Euler494 solution: "+Euler494Gen.count(90))
  }



}

package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}

class Euler17Spec extends FlatSpec with MustMatchers {
  "1" should "return one" in {
    assert(Euler17.spell(1) === "one")
  }

  "2" should "return two" in {
    assert(Euler17.spell(2) === "two")
  }

  "19" should "return nineteen" in {
    assert(Euler17.spell(19) === "nineteen")
  }

  "20" should "return twenty" in {
    assert(Euler17.spell(20) === "twenty")
  }

  "78" should "return seventyeight" in {
    assert(Euler17.spell(78) === "seventyeight")
  }

  "121" should "return onehundredtwentyone" in {
    assert(Euler17.spell(121) === "onehundredandtwentyone")
  }

  "400" should "return fourhundred" in {
    assert(Euler17.spell(400) === "fourhundred")
  }

  "1000" should "return onethousand" in {
    assert(Euler17.spell(1000) === "onethousand")
  }

  "count(342)" should "return 23" in {
    assert(Euler17.count(342) === 23)
  }

  "count(115)" should "return 20" in {
    assert(Euler17.count(115) === 20)
  }

  "count(1000)" should "return ???" in {
    println("Euler17 solution: " + Euler17.solution())
  }
}

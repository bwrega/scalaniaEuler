package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}
import pl.scalania.euler.Euler15.Grid

class Euler15Spec extends FlatSpec with MustMatchers {

  "grid (1..9) replace (1,2) with 99 " should "give (4,5,99) in second row" in {
    val g: Grid = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
    val target = List(List(1, 2, 3), List(4, 5, 99), List(7, 8, 9))
    assert(Euler15.replace(g, 1, 2, 99) === target)
  }

  "ways(1)" should "be 2" in {
    assert(Euler15.ways(1) === 2)
  }


  "ways(2)" should "be 6" in {
    assert(Euler15.ways(2) === 6)
  }

  "ways(20)" should "be ???" in {
    println("Euler15 solution: " + Euler15.ways(20))
  }

}

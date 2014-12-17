package pl.scalania.euler

import org.scalatest.{FlatSpec, MustMatchers}

import scala.io.Source

class Euler11Spec extends FlatSpec with MustMatchers {

  val grid = Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("grid.txt")).getLines().map { line => line.split("\\s+").map(_.toInt)}.toArray

  "Largest product in a grid " should "be " in {
    val result = Euler11.largestProductInGrid(grid,4)
    assert(result == 70600674)
  }

  "Largest number in a grid " should "be " in {
    val result = Euler11.largestProductInGrid(grid,1)
    assert(result == 99)
  }


}

package pl.scalania.euler

import java.util.Arrays

import org.scalatest.{FlatSpec, MustMatchers}

import scala.io.Source

class Euler11Spec extends FlatSpec with MustMatchers {

  "Largest product in a grid " should "be " in {
    val grid = Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("grid.txt")).getLines().map { line => line.split("\\s+").map(_.toInt)}.toArray
    grid.foreach(row => println(s"${Arrays.toString(row)}"))
    val result = Euler11.largestProductInGrid(grid)
    assert(result == 70600674)
  }


}

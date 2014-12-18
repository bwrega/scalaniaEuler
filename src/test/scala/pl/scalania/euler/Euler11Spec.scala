package pl.scalania.euler

import org.scalatest.{FlatSpec, MustMatchers}

import scala.io.Source

class Euler11Spec extends FlatSpec with MustMatchers {
  "Largest product in a grid " should "be " in {
    val grid = Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("grid.txt")).getLines().map { line => line.split("\\s+").map(_.toInt)}.toArray
//    grid.foreach(row => println(s"${util.Arrays.toString(row)}"))
    val result = Euler11.largestProductInGrid(grid)
    assert(result === 3)
  }

  "Grid of ones " should "be " in {
    val ones: Array[Array[Int]] = Array.fill(4,4)(1)
    val maxProduct = Euler11.largestProductInGrid(ones)
    assert(maxProduct === 1)
  }

  "detects max in horizontals " should "be 24" in {
    val horiz = Array.fill(5,5)(1).updated(2, Array(1,1,2,3,4))
    val maxProduct = Euler11.largestProductInGrid(horiz)
    assert(maxProduct === 24)
  }

  "detects max in verticals " should "be " in {
    val vert = Array(
      Array(1, 1, 1, 1, 1),
      Array(1, 2, 1, 1, 1),
      Array(1, 3, 1, 1, 1),
      Array(1, 3, 1, 1, 1),
      Array(1, 3, 1, 1, 1)
    )
    val maxProduct = Euler11.largestProductInGrid(vert)
    assert(maxProduct === 54)
  }
  "detects max in verticals 2" should "be " in {
    val vert = Array(
      Array(1, 4, 1, 1, 1),
      Array(1, 2, 1, 1, 1),
      Array(1, 3, 1, 1, 1),
      Array(1, 3, 1, 1, 1),
      Array(1, 0, 1, 1, 1)
    )
    val maxProduct = Euler11.largestProductInGrid(vert)
    assert(maxProduct === 72)
  }

  "detects max in diagonal \\" should "be 48" in {
    val diagsSE = Array(
      Array(0, 1, 1, 1),
      Array(1, 2, 1, 1),
      Array(1, 1, 3, 1),
      Array(1, 1, 1, 7)
    )
    val maxProduct = Euler11.largestProductInGrid(diagsSE)
    assert(maxProduct === 42)
  }

  "detects max in diagonal /" should "be " in {
    val diagsNE = Array(
      Array(1,  1,  1, 10, 3),
      Array(1,  2, 10, 20, 1),
      Array(1, 10, 20,  1, 1),
      Array(1, 20,  1,  8, 1),
      Array(2,  1,  1,  8, 1)
    )
    val maxProduct = Euler11.largestProductInGrid(diagsNE)
    assert(maxProduct === 24000)
  }
  "detects max in diagonal / 2" should "be " in {
    val diagsNE = Array(
      Array(1,  1,  1, 10, 3),
      Array(1,  2, 10, 20, 1),
      Array(1, 10, 20,  1, 1),
      Array(1, 20,  1,  8, 1),
      Array(4,  1,  1,  8, 1)
    )
    val maxProduct = Euler11.largestProductInGrid(diagsNE)
    assert(maxProduct === 32000)
  }
  "detects max in diagonal / 3" should "be " in {
    val diagsNE = Array(
      Array(1,  1,  1, 10, 3),
      Array(1,  2, 10, 20, 30),
      Array(1, 10, 20,  30, 1),
      Array(1, 20,  30,  8, 1),
      Array(4,  30,  1,  8, 1)
    )
    val maxProduct = Euler11.largestProductInGrid(diagsNE)
    assert(maxProduct === 810000)
  }

  "from forum " should " be " in {
    val forum = Array(Array(9, 8, 5, 2, 1, 3, 4, 7, 6))
    val maxProduct = Euler11.largestProductInGrid(forum)
    assert(maxProduct === 720)
  }
}

package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}

class Euler67Spec extends FlatSpec with MustMatchers {
  "Euler67 solution" should "be ???" in {
    val triangle: List[List[Int]] = NumberReader.readFromFileList("p067_triangle.txt")
    println("Euler67 solution is: " + Euler18.maxTriangle(triangle))
  }
}

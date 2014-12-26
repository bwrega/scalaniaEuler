package pl.scalania.euler

import org.scalatest.{FlatSpec, MustMatchers}
import pl.scalania.euler.euler494.Change.{down, up}

class Euler494Spec extends FlatSpec with MustMatchers {

  "ups and downs forward for (6, 3, 10, 5) " should "be (Down, Up, Down)" in {
    assert(Euler494.upDownsForward(Seq(6, 3, 10, 5)) === List(down, up, down))
  }

  "ups and downs forward for (1,7,2,6,9) " should "be (Up, Down, Up, Up)" in {
    assert(Euler494.upDownsForward(List(1, 7, 2, 6, 9)) === List(up, down, up, up))
  }

  "ups and downs reverse for (1,7,2,6,9,17)" should " be (down,down,down,up,down)" in {
    assert(Euler494.upDownsReverse(Seq(1, 7, 2, 6, 9, 17)) === List(down, down, down, up, down))
  }

  "Collatz relative prefix for 1 " should " be ()" in {
    assert(Euler494.relativePrefix(1L) === List())
  }

  "Collatz relative prefix for 8 " should " be ()" in {
    assert(Euler494.relativePrefix(8L) === List())
  }

  "Collatz relative prefix for 3 (3,10,5,16,8,4,2,1) " should " be (up,down)" in {
    assert(Euler494.relativePrefix(3L) === List(up, down))
  }

  "Collatz relative prefix for 454 (454, 227, 682, 341, ...) " should " be (down,up,down)" in {
    assert(Euler494.relativePrefix(454L) === List(down, up, down))
  }

  "Collatz prefix for 454 " should " be (454, 227, 682, 341)" in {
    assert(Euler494.prefix(454L) === List(454, 227, 682, 341))
  }

  "Collatz prefix for 8 " should " be ()" in {
    assert(Euler494.prefix(8L) === List())
  }

  val limit: Int = 10000
  "Families for length 6 " should " be ???" in {
    gatherStats(6)
  }

  def gatherStats(familyLength: Int) {
    val stats: Stats = Euler494.collectFamilies(familyLength, limit)
    println("forwards: ")
    stats.forwards.foreach((p) => {
      println(p._1)
      p._2.foreach(v => println(v + ": " + (v.last * 3 + 1)))
      println()
    })
  }

  "Families for length 5 " should " be ???" in {
    gatherStats(5)
  }

  "Families for length 4 " should " be ???" in {
    gatherStats(4)
  }

  "Families for length 3 " should " be ???" in {
    gatherStats(3)
  }

  "Families for length 2 " should " be ???" in {
    gatherStats(2)
  }

  "Families for length 1 " should " be ???" in {
    gatherStats(1)
  }

  "Paths for 16 with length 5" should " exist 3" in {
    assert(Euler494.countPaths(16L, 5) === 3)
  }

  "Paths for 262144 with length 2" should " exist 1" in {
    assert(Euler494.countPaths(262144L, 2) === 1)
  }

  "Paths for 65536 with length 6" should " exist 4" in {
    assert(Euler494.countPaths(65536, 6) === 4)
  }

  "Paths for 256 with length 6" should " exist 4" in {
    assert(Euler494.countPaths(256, 6) === 4)
  }

  //  "Families for length 10 " should " be ???" in {
  //    val stats: Stats = Euler494.collectFamilies(10, 1000000)
  //    println("forwards: size: " + stats.forwards.size)
  //    stats.forwards.foreach(println)
  //  }

  //  "to million" should " take some memory " in {
  //    Range.Long.inclusive(1, 1000000, 1).map(Euler494.collatz).filter(_.length>2000)
  //  }
}

package pl.scalania.euler.euler22

import org.scalatest.{MustMatchers, FlatSpec, FunSuite}

class Euler22Spec extends FlatSpec with MustMatchers {

  "Score outside order of COLIN" should " be 53 " in {
    assert(Euler22.scoreExcludingPosition("COLIN") === 53)
  }
  "Score of all " should "be ???" in {
    val scoreForAll: BigInt = Euler22.scoreForAll(NamesReader.readNames("p022_names.txt"))
    println("score for all: " + scoreForAll)
  }
}

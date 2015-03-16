package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}

class Euler23Spec extends FlatSpec with MustMatchers {

  "isAbundant(12)" should "be true" in {
    assert(Euler23.isAbundant(12) === true)
  }

  "isAbundant(28)" should "be false" in {
    assert(Euler23.isAbundant(28) === false)
  }

  "24 " should "be creatable from abundants" in {
    assert(Euler23.isCreatable(24) === true)
  }

  "Sum of all not creatable from abundants" should "be" in {
    val notCreatable: Seq[BigInt] = Euler23.allNotCreatable2
    println("all not creatable: " + notCreatable)
    println("sum: " + notCreatable.sum)
  }
}

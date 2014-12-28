package pl.scalania.euler

import java.time.{LocalDate, Month}

import org.scalatest.{FlatSpec, MustMatchers}

class Euler19Spec extends FlatSpec with MustMatchers {
  "1 January 1901 + 2 months" should " be 1 march 1901" in {
    val jan1: LocalDate = LocalDate.of(1901, Month.JANUARY, 1)
    val march1Act: LocalDate = jan1.plus(Euler19.oneMonth).plus(Euler19.oneMonth)
    val march1Exp: LocalDate = LocalDate.of(1901, Month.MARCH, 1)
    assert(march1Act === march1Exp)
  }

  "Euler19" should "be ???" in {
    println("Euler19 solution is: " + Euler19.sundays())
  }
}

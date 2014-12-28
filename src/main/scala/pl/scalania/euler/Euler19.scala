package pl.scalania.euler

import java.time.Month.DECEMBER
import java.time.{DayOfWeek, LocalDate, Month, Period}

import scala.annotation.tailrec

object Euler19 {
  val oneMonth: Period = Period.ofMonths(1)

  def sundays(): Int = {
    val endDate: LocalDate = LocalDate.of(2000, DECEMBER, 1)
    @tailrec
    def sundaysRec(d: LocalDate, acu: Int): Int = {
      if (d.isAfter(endDate))
        acu
      else {
        val newAcu = acu + {
          if (d.getDayOfWeek == DayOfWeek.SUNDAY)
            1
          else
            0
        }
        sundaysRec(d.plus(oneMonth), newAcu)
      }
    }
    sundaysRec(LocalDate.of(1901, Month.JANUARY, 1), 0)
  }

}

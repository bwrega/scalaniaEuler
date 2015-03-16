package pl.scalania.euler.euler22

import org.scalatest.{MustMatchers, FlatSpec, FunSuite}
import pl.scalania.euler.Divisions

/**
 * Created by bartek on 3/15/15.
 */
class NamesReaderTest extends FlatSpec with MustMatchers {

    "readNames" should "return between 5000 and 6000 names" in {
      val names: Seq[String] = NamesReader.readNames("p022_names.txt")
      assert(names.size>5000)
      assert(names.size<6000)
    }
}

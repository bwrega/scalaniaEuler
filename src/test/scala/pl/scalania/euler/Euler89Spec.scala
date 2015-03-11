package pl.scalania.euler

import org.scalatest.{FlatSpec, MustMatchers}
import pl.scalania.euler.Euler89.countMinimizedChars

import scala.io.Source

class Euler89Spec extends FlatSpec with MustMatchers {
  "Euler89.deminimize(I)" should "return I" in {
    checkDemini("I", 1)
  }

  "Euler89.deminimize(IV)" should "return IIII" in {
    checkDemini("IV", 4)
  }

  "Euler89.deminimize(IX)" should "return I*9" in {
    checkDemini("IX", 9)
  }

  "Euler89.deminimize(XIX)" should "return I*19" in {
    checkDemini("XIX", 19)
  }

  "Euler89.deminimize(XL)" should "return I*40" in {
    checkDemini("XL", 40)
  }

  "Euler89.deminimize(XC)" should "return I*90" in {
    checkDemini("XC", 90)
  }

  "Euler89.deminimize(CD)" should "return I*400" in {
    checkDemini("CD", 400)
  }

  "Euler89.deminimize(CDX)" should "return I*410" in {
    checkDemini("CDX", 410)
  }

  "Euler89.deminimize(CM)" should "return I*900" in {
    checkDemini("CM", 900)
  }

  "Euler89.deminimize(L)" should "return I*50" in {
    checkDemini("L", 50)
  }

  "Euler89.deminimize(C)" should "return I*100" in {
    checkDemini("C", 100)
  }

  "Euler89.deminimize(D)" should "return I*500" in {
    checkDemini("D", 500)
  }

  "Euler89.deminimize(M)" should "return I*1000" in {
    checkDemini("M", 1000)
  }

  "Euler89.deminimize(MMMMCCCLXII)" should "return I*4362" in {
    checkDemini("MMMMCCCLXII", 4362)
  }

  "Euler89.deminimize(DCCXLIIII)" should "return I*744" in {
    checkDemini("DCCXLIIII", 744)
  }

  //  "Euler89.minimize(14)" should "return XIV" in {
  //    assert(Euler89.minimize("I" * 14) === "XIV")
  //  }
  //
  //  "Euler89.minimize(1009)" should "return MIX" in {
  //    assert(Euler89.minimize("I" * 1009) === "MIX")
  //  }
  //
  //  "Euler89.minimize(8)" should "return VIII" in {
  //    assert(Euler89.minimize("I" * 8) === "VIII")
  //  }

  "Euler89.minimize(902)" should "return CMII" in {
    assert(Euler89.minimize("I" * 902) === "CMII")
  }

  "Euler89.minimize(503)" should "return DIII" in {
    assert(Euler89.minimize("I" * 503) === "DIII")
  }

  "Euler89.minimize(2503)" should "return MMDIII" in {
    assert(Euler89.minimize("I" * 2503) === "MMDIII")
  }

  "Euler89.minimize(403)" should "return CDIII" in {
    assert(Euler89.minimize("I" * 403) === "CDIII")
  }

  "Euler89.minimize(203)" should "return CCIII" in {
    assert(Euler89.minimize("I" * 203) === "CCIII")
  }

  "Euler89.minimize(192)" should "return CXCII" in {
    assert(Euler89.minimize("I" * 192) === "CXCII")
  }

  "Euler89.minimize(53)" should "return LIII" in {
    assert(Euler89.minimize("I" * 53) === "LIII")
  }

  "Euler89.minimize(43)" should "return XLIII" in {
    assert(Euler89.minimize("I" * 43) === "XLIII")
  }

  "Euler89.minimize(33)" should "return XXXIII" in {
    assert(Euler89.minimize("I" * 33) === "XXXIII")
  }

  "Euler89.minimize(19)" should "return XIX" in {
    assert(Euler89.minimize("I" * 19) === "XIX")
  }

  "Euler89.minimize(8)" should "return VIII" in {
    assert(Euler89.minimize("I" * 8) === "VIII")
  }

  "Euler89.minimize(4)" should "return IV" in {
    assert(Euler89.minimize("I" * 4) === "IV")
  }

  "Euler89.minimize(XLIIIIIIIII)" should "return XLIX" in {
    assert(Euler89.minimize("XLIIIIIIIII") === "XLIX")
  }

  "Euler89 solution" should "be ???" in {
    val input: List[String] = Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("p089_roman.txt")).getLines().map(_.trim).toList
    val res: Int = countMinimizedChars(input)
    println(s"Euler89 solution is: $res")
    def eq12(p: (String, String)): Boolean = p._1 == p._2
    input.map(r => (r, Euler89.minimize(r))).filterNot(eq12)
      .foreach(println)
  }

  "countMinimizedChars(II,III,IIII)" should "return 7" in {
    assert(Euler89.countMinimizedChars(List("II", "III", "IV")) === 7)
  }

  "countMinimizedChars(II)" should "return 7" in {
    assert(Euler89.countMinimizedChars(List("II")) === 2)
  }

  def checkDemini(roman: String, arabic: Int) {
    val demini: String = Euler89.deminimize(roman)
    assert(demini.forall(_ == 'I'), s"roman $roman deminimized $demini")
    assert(demini.length === arabic)
  }
}

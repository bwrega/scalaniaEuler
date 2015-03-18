package pl.scalania.euler.euler24

import org.scalatest.{MustMatchers, FlatSpec}

class Euler24Spec extends FlatSpec with MustMatchers {

  "Collecting processor " should "work" in {
    //given
    val proc = new CollectingProcessor
    Leaf.registerLeavesProcessor(proc)
    //when
    new Leaf("abc")
    new Leaf("def")
    //then
    assert(proc.getCollected===Seq("abc", "def"))
  }

  "Permutations of 012" should "be correct" in {
    //given
    val source = "012"
    val proc = new CollectingProcessor
    Leaf.registerLeavesProcessor(proc)
    //when
    new Euler24Node("", source)
    //then
    assert(proc.getCollected === Seq("012", "021", "102", "120", "201", "210"))
  }
  "3rd Permutation of 012" should "be 102" in {
    //given
    val source = "012"
    val proc = new PrintNthAndExit(3)
    Leaf.registerLeavesProcessor(proc)
    //when
    new Euler24Node("", source)
    //then
  }

  "answer for problem24" should "be ???" in {
    //given
    val source = "0123456789"
    val proc = new PrintNthAndExit(1000000)
    Leaf.registerLeavesProcessor(proc)
    //when
    new Euler24Node("", source)
    //then
  }
}

class CollectingProcessor extends LeavesProcessor {
  private var collected = Seq[String]()
  @Override
  def processLeaf(l:Leaf) = {
    collected = l.path +: collected
  }
  def getCollected = collected.reverse
}
package pl.scalania.euler

import org.scalatest.{MustMatchers, FlatSpec}
import pl.scalania.euler.Euler494S.Node
import pl.scalania.euler.euler494.Change

class Euler494SSpec extends FlatSpec with MustMatchers {

  "tree for 8, 1 " should " return empty tree" in {
    assert(Euler494S.tree(8, 1) === None)
  }

  "tree for 16, 1 " should " return Some(Node(5,None,None))" in {
    assert(Euler494S.tree(16, 1) === Some(Node(5, None, None)))
  }

  "tree for 16, 3 " should " return tree" in {
    val bigger2 = Some(Node(20, None, None))
    val smaller2 = Some(Node(3, None, None))
    val bigger1 = Some(Node(10, bigger2, smaller2))
    assert(Euler494S.tree(16, 3) === Some(Node(5, bigger1, None)))
  }

  "tree for 256, 4 " should " return Tree" in {
    val biggerN = Some(Node(680, None, None))
    val smallerN = Some(Node(113, None, None))
    assert(Euler494S.tree(256, 4) === Some(Node(85, Some(Node(170, Some(Node(340, biggerN, smallerN)), None)), None)))
  }

  "families for 256, 4" should " exist" in {
    println("families:")
    val tree: Node = Euler494S.tree(256, 4).get
    val families: Set[List[Change]] = tree.families
    families.foreach(println)
  }

  "families for 16, 3" should " exist" in {
    println("families:")
    val tree: Node = Euler494S.tree(16, 3).get
    val families: Set[List[Change]] = tree.families
    families.foreach(println)
  }

  "for length 5 " should " exist 5 families " in {
    assert(Euler494S.countFamilies(5) === 5)
  }

  "for length 10 " should " exist 55 families " in {
    assert(Euler494S.countFamilies(10) === 55)
  }

  "for length 20 " should " exist 6771 families " in {
    assert(Euler494S.countFamilies(20) === 6771)
  }

}

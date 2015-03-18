package pl.scalania.euler.euler24

trait LeavesProcessor {
  def processLeaf(leaf: Leaf)
}

class PrintNthAndExit (target: Int) extends LeavesProcessor {
  private var counter = 0
  override def processLeaf(leaf: Leaf): Unit = {
    counter += 1
    if (counter==target) {
      println(s"${target}th permutation is: ${leaf.path}")
    }
  }
}
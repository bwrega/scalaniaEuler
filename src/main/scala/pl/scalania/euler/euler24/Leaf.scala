package pl.scalania.euler.euler24

class Leaf (val path: String) {
  Leaf.processor.processLeaf(this)
}

object Leaf {
  var processor: LeavesProcessor = null

  def registerLeavesProcessor(p:LeavesProcessor): Unit = {
    processor = p
  }
}
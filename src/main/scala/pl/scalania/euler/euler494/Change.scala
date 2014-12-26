package pl.scalania.euler.euler494

trait Change {
  def inverse: Change
}


object Change {

  def inverse(changes: Seq[Change]): List[Change] = changes.reverseMap(_.inverse).toList

  case class Up__() extends Change {
    @Override
    def inverse: Change = Down()
  }
  case class Down() extends Change {
    @Override
    def inverse: Change = Up__()
  }

  val up: Change = Up__()
  val down: Change = Down()
}

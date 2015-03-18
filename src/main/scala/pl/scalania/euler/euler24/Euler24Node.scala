package pl.scalania.euler.euler24

class Euler24Node (path:String, whatsLeft:String) {

  createChildren

  def createChildren = {
    if (whatsLeft.size == 1)
      new Leaf(path+whatsLeft)
    else {
      for (c <- whatsLeft.toCharArray) {
        new Euler24Node(path+c, whatsLeft.filterNot(_==c))
      }
    }
  }
}

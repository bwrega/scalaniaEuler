package pl.scalania.euler.euler22

import scala.io.Source

object NamesReader {
  def readNames(resource:String):Seq[String] =
    Source.fromInputStream(getClass.getClassLoader.getResourceAsStream(resource))
      .mkString.split("\"")
      .filterNot(_==",")
      .filterNot(_.isEmpty)
      .sorted
}

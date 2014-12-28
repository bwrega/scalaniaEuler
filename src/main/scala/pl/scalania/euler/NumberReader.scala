package pl.scalania.euler

import scala.io.Source

object NumberReader {
  def readIntsFromFile(file: String): Iterator[Array[Int]] = {
    Source.fromInputStream(getClass.getClassLoader.getResourceAsStream(file)).getLines().map { line => line.split("\\s+").map(_.toInt)}
  }
  def readFromFileList(file: String): List[List[Int]] = {
    readIntsFromFile(file).toList.map(_.toList)
  }

}

package pl.scalania.euler

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory
import pl.scalania.euler.euler494.Change
import pl.scalania.euler.euler494.Change.{Up__, Down}

import scala.annotation.tailrec

object Euler494S {
  val maxPower = 50000

  def getFamilies(length: Int): Set[List[Change]] = {
    @tailrec
    def countRec(powLeft: Int, n: BigInt, acu: Set[List[Change]]): Set[List[Change]] = {
      if (powLeft == 0) {
        acu
      }
      else {
        if (powLeft %100 == 0)
          log.debug("cache hits: "+cacheHits)
        val newAcu = acu ++ tree(n, length).map(_.families).getOrElse(Set())
        countRec(powLeft - 1, n * 2L, newAcu)
      }
    }
    countRec(maxPower, 4, Set())
  }

  def countFamilies(length: Int): Int = getFamilies(length).size

  var treeCache = Map[(BigInt, Int), Option[Node]]()
  var cacheHits = 0L

  def tree(n: BigInt, depth: Int): Option[Node] = {
    def treeOdd(n: BigInt, depth: Int): Option[Node] = {
      val cached = treeCache.get((n, depth))
      if (cached.nonEmpty) {
        cacheHits += 1L
        cached.get
      } else {
        val ret: Option[Node] = depth match {
          case 1 => Some(Node(n, None, None))
          case _ =>
            val bigger = treeOdd(n * 2L, depth - 1)
            val smaller = {
              if (canGetSmaller(n))
                treeOdd((n - 1L) / 3L, depth - 1)
              else
                None
            }
            if (bigger.nonEmpty || smaller.nonEmpty)
              Some(Node(n, bigger, smaller))
            else
              None
        }
        treeCache += (n, depth) -> ret
        ret
      }
    }
    def canGetSmaller(n: BigInt): Boolean = {
      (n - 1L) % 3L == BigInt(0) && ((n - 1L) / 3L) % 2L == BigInt(1)
    }

    if (canGetSmaller(n)) {
      val newN: BigInt = (n - 1L) / 3L
      val ret: Option[Node] = treeOdd(newN, depth)
      ret
    }
    else
      None
  }

  case class Node(n: BigInt, bigger: Option[Node], smaller: Option[Node]) {

    def families: Set[List[Change]] = {
      def withNilIfLeaf: Set[List[Change]] = {
        if (isLeaf)
          Set(Nil)
        else
          Set()
      }
      val bs: Set[List[Change]] = if (bigger.nonEmpty) bigger.get.families.map(_ :+ Down()) else withNilIfLeaf
      val ss: Set[List[Change]] = if (smaller.nonEmpty) smaller.get.families.map(_ :+ Up__()) else withNilIfLeaf
      bs ++ ss
    }

    def isLeaf: Boolean = {
      bigger.isEmpty && smaller.isEmpty
    }
  }
  val log = Logger(LoggerFactory.getLogger(Euler494S.getClass.toString))

}

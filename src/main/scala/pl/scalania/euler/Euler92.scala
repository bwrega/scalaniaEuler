package pl.scalania.euler

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

object Euler92 {
  def count89s(ceil: Int) = (1 until ceil).map(n => {
    if (n % 1000 == 0)
      log.debug("n: " + n)
    chainLast(n)
  }).count(_ == 89)

  val log = Logger(LoggerFactory.getLogger(Euler92.getClass.toString))

  //  @tailrec
  def chainLast(n: BigInt): BigInt = n.toLong match {
    case 1L => 1
    case 89L => 89
    case _ =>
      chainLast(n.toString().toList.map(_.toString).map(BigInt(_)).map(c => c * c).foldLeft(BigInt(0))(_ + _))
  }

}

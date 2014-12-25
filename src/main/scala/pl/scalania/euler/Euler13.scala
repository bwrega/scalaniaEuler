package pl.scalania.euler

object Euler13 {
  def bigSum(nums: List[String]) = nums.map(BigInt(_)).foldLeft(BigInt(0))(_ + _)
}

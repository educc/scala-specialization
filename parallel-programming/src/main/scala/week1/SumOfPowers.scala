package week1

import scala.collection.parallel.Task

object SumOfPowers {


  def sumSeqInParralel(numbers: Array[Int]) = {

    def sumSeq(from: Int, to: Int): Int =
      (from until to)
        .map(i => numbers(i))
        .sum

    def inner(from: Int, to: Int): Int =
      if (to - from <= 2) {
        sumSeq(from, to)
      } else {
        val mid = (to - from) / 2
        val midTo = from + mid
        val (left, right) = parallel(
          inner(from, midTo),
          inner(midTo + 1, to)
        )
        left + right
      }


    inner(0, numbers.size)
  }

  def parallel[A, B](a: => A, b: => B): (A, B) = {
    val myTask = Task {
      b
    }
    val resultA = a
    (resultA, myTask.join())
  }


  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5)
    val result = SumOfPowers.sumSeqInParralel(arr)
    println(result)
  }

}

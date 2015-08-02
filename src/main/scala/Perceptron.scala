import methods.Sigmoid

import scala.annotation.tailrec

object Perceptron {

  val learnRate = 0.3

  case class Teach(input: Seq[Double], tf: Int)

  def activation(inputs: Seq[Double], weights: Seq[Double]): Double = {
    def sumInputs: Double = {
      inputs.zipWithIndex.map{ case (x, i) =>
        x * weights(i)
      }.sum
    }
    Sigmoid.sigmoid(sumInputs, 1)
  }

  /**
   * Hebb学習則
   * @return (更新した重み, 更新したかどうか)
   */
  def hebbianRule(weight: Double, input: Double, teach: Double, output: Double): (Double, Boolean) =
    weight + {
      teach - output match {
        case a if a > 0 => -learnRate * input
        case a if a == 0 => 0
        case a if a < 0 => learnRate * input
      }
    } -> (teach - output != 0)


  /**
   * 学習する
   * @param trainingData
   * @param start_weights
   * @return 学習した重みを返却.
   */
  def training(trainingData: Seq[Teach], start_weights: Seq[Double]): Seq[Double] = {
    def iteration(weights: Seq[Double]): (Seq[Double], Boolean) = {
      trainingData.foldLeft(weights -> false)((weights_new, teach) =>
      {
        val (ws, doUpdate) = weights_new
        val teach_add = teach.input ++ Seq(-1.0)
        val output = activation(teach_add, ws)
        ws.zipWithIndex.foldLeft(weights_new) { (weights, w_i) => {
          val updateW = hebbianRule(w_i._1, teach_add(w_i._2), teach.tf, output)
          weights._1.updated(w_i._2, updateW._1) -> (updateW._2 && weights._2)
        }}
      }
      )
    }
    @tailrec
    def loop(weights: (Seq[Double], Boolean)): Seq[Double] = {
      if(!weights._2) weights._1
      else loop(iteration(weights._1))
    }
    loop(start_weights, true)
  }

}
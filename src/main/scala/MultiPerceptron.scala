/**
 * Created by Yuto Suzuki on 15/08/23.
 */

import Methods.{SampleMatrix, SampleVector}
import breeze.linalg._
import breeze.numerics.{ pow, sqrt }
import breeze.plot.Figure
import breeze.stats.distributions.Gaussian
import breeze.plot._

object MultiPerceptron {

  def forward(input: DenseVector[Double], weight: DenseMatrix[Double], bias: DenseVector[Double]): DenseVector = {
    input * weight + bias
  }

  def main(args: Array[String]): Unit = {
    val dimension = 3

    val startWeight = SampleMatrix.gaussianMatrix(dimension, dimension)
    forward(startWeight,)
  }
}

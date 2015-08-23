package methods
import scala.math._

object Sigmoid {
  def sigmoid(input: Double, const: Int): Double = 1 / (1 + pow(E, -input * const))

  def sigmoid_1diff(input: Double, const: Int): Double = const * sigmoid(input, const) * (1 - sigmoid(input, const))
}
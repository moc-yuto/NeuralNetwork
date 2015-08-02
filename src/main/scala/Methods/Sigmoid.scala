package methods
import scala.math._

object Sigmoid {
  def sigmoid(input: Double, const: Int): Double = 1 / (1 + pow(E, -input * const))
}
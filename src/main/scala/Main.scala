import Perceptron._

object Main{

  def main(args: Array[String]) {
    val teachData = Seq(Teach(Seq(1,0), 0), Teach(Seq(0,0),1), Teach(Seq(0,1),0), Teach(Seq(1,1),0))
    val weights = Seq(0.5, 0.5, 0.5)
    val trainedWeight =  Perceptron.training(teachData, weights)
    println(trainedWeight)
    println(s"discriminant function: y = -${trainedWeight(0)/trainedWeight(1)}x + ${-trainedWeight(2)/trainedWeight(1)}")
  }
}
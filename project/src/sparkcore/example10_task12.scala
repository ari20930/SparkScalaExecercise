package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
/*
 * 
 */
object example10_task12 {
  def main(args:Array[String])={
    val sc = new SparkContext(new SparkConf().setAppName("task12").setMaster("local"))
  }
}
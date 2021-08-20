package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
/*
 * 19.	Data For Task
 * val a = sc.parallelize(List("dog","tiger","lion","cat","panther","eagle"))
 * Accomplish the following:-
 * Array[(Int, String)] = Array((4,lion), (5,tigereagle), (3,dogcat), (7,panther))
 */
object example10_task19 {
  def main(args:Array[String])={
    val sc = new SparkContext(new SparkConf().setAppName("example9").setMaster("local"))
    sc.setLogLevel("ERROR")
    
    val a = sc.parallelize(List("dog","tiger","lion","cat","panther","eaggle"))
    
    val b = a.collect.map(x=>(x(2),x(1)))
    
    b.foreach(println)
    
    
    
  }
}
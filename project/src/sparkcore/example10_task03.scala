package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
/*
 *---------------------------------
 *3. Data For Task
 *---------------------------------
 *("We", "Are" ,"Learning" , "Hadoop" , "From" , "Inceptez" , "We", "Are" ,"Learning" , "Spark" , "From" , "Inceptez.com" , "hadoop" , "HADOOP")
 *
 *Accomplish the followings:-
 *
 *1. Create an RDD using using the given words
 *2. Once RDD is created count all the words
 *3. Now filter out all the words which does not have Hadoop keyword, however make sure it would count all the different cases(upper/lower) as well
 */
object example10_task03 {
  def main(args:Array[String])={
    val sc = new SparkContext(new SparkConf().setAppName("task03").setMaster("local"))
    sc.setLogLevel("ERROR")
    
    val values = List("We", "Are" ,"Learning" , "Hadoop" , "From" , "Inceptez" , "We", "Are" ,"Learning" , "Spark" , "From" , "Inceptez.com" , "hadoop" , "HADOOP")
    val rdd1 =sc.parallelize(values)
    val rdd2 = rdd1.count()
    val rdd3 = rdd1.map(x=>x.toUpperCase()).filter(x=> !x.contains("HADOOP"))
    
    //map(x=>List(x)).
    rdd3.foreach(println)
    
  }
}
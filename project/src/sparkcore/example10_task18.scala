package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
/*
 * DATATASK-18
 * You have been given below list in scala (name,sex,cost) for each work done.
 * List( ("Deepak" , "male", 4000), ("Deepak" , "male", 2000), ("Deepika" , "female", 2000),
 * ("Deepak" , "female", 2000), ("Deepak" , "male", 1000) , ("Neeta" , "female", 2000))
 * 
 * Accomplish the followings:-
 * Now write a spark program to load this list as an RDD and do the sum of cost for combination 
 * of name and gender (as key)
 * 
 * 
 */
object example10_task18 {
  def main(args:Array[String])={
    val sc = new SparkContext(new SparkConf().setAppName("task18").setMaster("local"))
    sc.setLogLevel("ERROR")
    
    val a = List( ("Deepak" , "male", 4000), ("Deepak" , "male", 2000), ("Deepika" , "female", 2000),("Deepak" , "female", 2000), ("Deepak" , "male", 1000) , ("Neeta" , "female", 2000))
    
    val b = sc.parallelize(a.toString)
  
    
  }
}
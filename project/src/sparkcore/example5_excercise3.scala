package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
/*
 *  ***********************
 *  3. Data For Task
 *  **********************
 *  ("We","Are","Learning","Hadoop","From","Inceptez","We","Are","Learning","Spark',"From","Inceptez.com","hadoop","HADOOP")
 * 
 *  **************************
 *  
 *  Accomplish the followings:-
 *  
 *  1. Create a RDD using the given word
 *  2. Once created count all the words
 *  3. Filter out all the words which does not contains Hadoop keyword,however make sure it would count all the upper case and lower case
 *  4. Filter all the lines which does not contains "Inceptez" and count the lines
 *  
 */
object example5_excercise3 {
  def main(args:Array[String])=
  {
    val sc = new SparkContext(new SparkConf().setAppName("Example5.3").setMaster("local"))
    sc.setLogLevel("ERROR")
    val lst = List("We","Are","Learning","Hadoop","From","Inceptez","We","Are","Learning","Spark","From","Inceptez.com","hadoop","HADOOP")
    val rdd = sc.parallelize(lst)
    println(rdd.count) 
     
     val rdd1 = rdd.map(x=> x.toUpperCase()).filter(x=> x.contains("HADOOP"))
     println(s"Count of Hadoop: ${rdd1.count}")

  
  }
}
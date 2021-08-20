package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
/*
 *  ***********************
 *  2. Data For Task
 *  **********************
 *  Inceptez2.text
 *  I am learning Apache Spark from Inceptez Learning Resources 
 *  I am learning Apache Hadoop from Inceptez Learning Resources 
 *  I have created my technical profile at www.QuickTechie.com
 *  I am learning Apache Spark from-Training4exam Learning Resources
 *  I am learning Apache Spark from-Training4exam Learning Resources
 *  **************************
 *  
 *  Accomplish the followings:-
 *  
 *  1. Create this text file is HDFS
 *  2. Once files is created, write the spark Application which will read from HDFS as an RDD
 *  3. Filter all the lines which contains "Inceptez" and count the lines
 *  4. Filter all the lines which does not contains "Inceptez" and count the lines
 *  
 */
object example5_excercise2 {
  def main(args:Array[String])={
     val sc = new SparkContext(new SparkConf().setAppName("example5.2").setMaster("local"))
     sc.setLogLevel("ERROR")
     val rdd = sc.textFile("hdfs://localhost:54310/user/hduser/hadoop/Inceptez2.txt")
 
     
     /*
      * filter(x=>x.contains("string/char name")  -> it will give whatever the lines it contains particular text/char/string
      */
     val rdd1 = rdd.filter(x=>x.contains("Inceptez"))
     rdd.foreach(println)
     println(rdd.filter(x=>x.contains("Inceptez")).count)
     
     
     
     /*
      * filter(x=> !(x.contains("string/char name"))  -> it will give whatever the lines it does not contains particular text/char/string
      */
     println(rdd.filter(x=> !(x.contains("Inceptez"))).count)
     
     
     
     
    
  }
 
    
}
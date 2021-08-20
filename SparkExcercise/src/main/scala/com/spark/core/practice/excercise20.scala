package com.spark.core.practice
import org.apache.spark.{SparkContext,SparkConf}
/*
*val a= sc.parallelize(List("dog","tiger","lion","cat","panther","eagle"))
*ccomplish the following:-
*Array[(Int, String)] = Array((4,lion), (5,tigereagle) , (3,dogcat), (7,panther))
*/
object excercise20 {
 def main(args:Array[String]):Unit={
   val sc = new SparkContext(new SparkConf().setAppName("excercise20").setMaster("local"))
       sc.setLogLevel("ERROR")
   val a= sc.parallelize(List("dog","tiger","lion","cat","panther","eagle"))
   val keyValueRdd=a.map(x=>(x.length,x)).reduceByKey(_+_) 
   println("Output is::")
       keyValueRdd.foreach(println)
       
 }
  
}
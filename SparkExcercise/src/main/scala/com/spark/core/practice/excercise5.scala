package com.spark.core.practice
import org.apache.spark.{SparkContext,SparkConf}
/*
 * 
 * 
 * Accomplish the followings:-

1.	Create an RDD using using the given words
2.	Once RDD is created count all the words
3.	Now filter out all the words which does not have Hadoop keyword, however make sure it would count all the different cases(upper/lower) as well
 * 
 * 
 * 
 */
object excercise5 {
  def main(args:Array[String]):Unit={
    val sc = new SparkContext(new SparkConf().setAppName("excercise5").setMaster("local"))
    sc.setLogLevel("ERROR")
    val arr=Array("We","Are","Learning","Hadoop","From","Inceptez","We","Are","Learning","Spark","From","HADOOP","Inceptez.com","hadoop")
    
    val rdd1=sc.parallelize(arr)
    val rdd2=rdd1.flatMap(_.split(",")).filter(!_.toUpperCase().equals("HADOOP"))
    
    println("total word count"+" "+rdd1.count)
    println("word that doesn't contains HADOOP")
    rdd2.foreach(println)
    
    
  }
}
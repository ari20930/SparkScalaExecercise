package com.spark.core.practice
/*
 * 
 * Inceptez2.txt
I am learning Apache Spark from Inceptez Learning Resources 
I am learning Apache Hadoop from Inceptez Learning Resources
I have created my technical profile at www.QuickTechie.com
I am learning Apache Spark from Training4exam Learning Resources 
I am learning Apache Spark from Training4exam Learning Resources

Accomplish the followings:-
1.	Create this file in HDFS
2.	Once file is created, write a spark application which will read this file from HDFS as an RDD
3.	Filter all records contains 'Inceptez' in line and count of lines
4.	Filter all records does not contains 'Inceptez' in line and count the lines
 * 
 * 
 */
import org.apache.spark.{SparkContext,SparkConf}
object excercise4 {
  def main(args:Array[String]):Unit={
    
    val sc= new SparkContext(new SparkConf().setAppName("excercise4").setMaster("local"))
    sc.setLogLevel("ERROR")
    
    val fileRdd=sc.textFile("hdfs://localhost:54310/user/hduser/Inceptez2.txt")
    val filterRdd1=fileRdd.filter(_.contains("Inceptez"))
    val filterRdd2=fileRdd.filter(!_.contains("Inceptez"))
     
    
    println("records contains Inceptez::")
    filterRdd1.foreach(println)
    println("------------------------------------------")
    println("count the number records present with Inceptez"+" "+filterRdd1.count())
    
    println("------------------------------------------")
    println("records doesnot contain Inceptez")
    filterRdd2.foreach(println)
    println("------------------------------------------")
    println("count the number records not present with Inceptez"+" "+filterRdd2.count())
    
    
    
    
  }
}
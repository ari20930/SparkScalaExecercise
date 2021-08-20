package com.spark.core.practice
import org.apache.spark.{SparkConf,SparkContext}
object excercise3 {
  def main(args:Array[String]):Unit={
    val sc= new SparkContext(new SparkConf().setAppName("excercise3").setMaster("local"))
    sc.setLogLevel("ERROR")
    
    val fileRdd=sc.textFile("hdfs://localhost:54310/user/hduser/Inceptez1.txt")
    
    println("No. of lines present in rdd is:: "+" "+fileRdd.count())
  
  
  }
  
}

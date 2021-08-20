package com.spark.practice
import org.apache.spark.SparkConf
object wordcount {
  def main(args:Array[String]):Unit={
    
    //Initialize SparkContext with SparkConf
    val conf= new SparkConf().setAppName("WordCount").setMaster("Local")
    
  }
}
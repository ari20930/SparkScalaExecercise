package com.spark.sparkcorepractice
import org.apache.spark.{SparkConf,SparkContext}

object WordCount {
  def main(args:Array[String]):Unit={
   val conf = new SparkConf().setAppName("wordcount").setMaster("local")
   val sc = new SparkContext(conf)
    println("Hello World")
   val rdd1=sc.textFile("file:/home/hduser/sample.text")
   rdd1.foreach(println)
  }
}
package com.spark.core.practice
import org.apache.spark.{SparkConf,SparkContext}
object WordCount {
  def main(args:Array[String]):Unit={
    val conf = new SparkConf().setAppName("wordcount").setMaster("local")
    val sc = new SparkContext(conf)
    println("Hello World")
  }
}
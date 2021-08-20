package com.spark.core.practice
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

//wordcount problem
object excercise1 {
  def main(args:Array[String]):Unit={
    val conf = new SparkConf().setAppName("excerise1").setMaster("local")
    //SparkConf->class -> we method setAppName & setMaster -> we passing some parameter to these method
    val sc=new SparkContext(conf)
    sc.setLogLevel("ERROR")
    
    try{
    val sentenceRdd = sc.textFile("file:/home/hduser/sample.text")
    
    val wordRdd= sentenceRdd.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)
    
    println("Result Of wordCount is::")
    wordRdd.foreach(println)
    }
    catch{
      case e:Throwable=>println(e)
    }
    

    
  }
}
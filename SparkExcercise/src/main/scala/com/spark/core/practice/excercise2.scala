package com.spark.core.practice
import org.apache.spark.{SparkConf,SparkContext}
//pass the file location as argument

//set("spark.hadoop.validateOutputSpecs","false") 
//to overwrite a file using sparkCore in hdfs & local
object excercise2 {
  def main(args:Array[String]):Unit={
    //val conf= 
    val sc= new SparkContext(new SparkConf().setAppName("excercise2").setMaster("local").set("spark.hadoop.validateOutputSpecs","false"))
    sc.setLogLevel("ERROR")
    //Array("/home/hduser/sampe.text")
    if(args.length<1)
     println("missing argument")
    
    val file1=sc.textFile(args(0))
    
    val wordCountRdd=file1.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)
    wordCountRdd.foreach(println)
    
  // println(wordCountRdd.getNumPartitions)
    
    wordCountRdd.saveAsTextFile("hdfs://localhost:54310/user/hduser/wordCountExample1/")
    println("file has been saved in hdfs location")
    
    wordCountRdd.saveAsTextFile("file:/home/hduser/wordCountExample1/")
    println("file has been saved in local location")
    
    
    
  }
}
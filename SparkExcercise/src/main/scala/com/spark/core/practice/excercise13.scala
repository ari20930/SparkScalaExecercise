package com.spark.core.practice
import org.apache.spark.{SparkContext,SparkConf}
/*
*Content.txt
*Hello this is Inceptez.com
*This is TechCert.com
*Apache Spark Training
*This is Spark Learning
*Session Hello, is, this, the
*Spark is faster than MapReduce
*
*Remove.txt
*Hello,is,this,the 
*
*Accomplish the following:-
*write the spark program which reads the content.txt file and load as RDD, 
*remove all the words from the Content.txt(which is loaded as an RDDs of words from Remove.txt). 
*count the occurances of each word and save it as text file in HDFS
*/
/****need to see*****/
/*def removeWord(x:String):Boolean={
*val removeWords = List("Hello","is","this","the")
*for(i<-removeWords)
*return !x.contains(i)
*}
*/

object excercise13 {
  
  def main(args:Array[String]):Unit={
    val sc = new SparkContext(new SparkConf().setAppName("excercise13").setMaster("local").set("spark.hadoop.validateOutputSpecs","false"))
        sc.setLogLevel("ERROR")
    val contentFile = sc.textFile("file:/home/hduser/Content.txt")
    val removeFile  = sc.textFile("file:/home/hduser/Remove.txt")
    val removeFieldsRdd = removeFile.map(x=>x.split(",")).map(x=>(x(0),x(1),x(2),x(3)))
    val removeFromContentByRemoveFileRdd = contentFile.filter(removeWord)
    val wordCount = removeFromContentByRemoveFileRdd.flatMap(x=>x.split(" ")).map(x=>(x,1)).reduceByKey(_+_)
        wordCount.saveAsTextFile("hdfs://localhost:54310/user/hduser/excercise13")
    println("file has been saved successfully")
    println("word count result is:: ")
        wordCount.foreach(println)   
    
  }
  
def removeWord(x:String):Boolean={
val removeWords = List("Hello","is","this","the")
!(x.contains(removeWords(0)) ||x.contains(removeWords(1)) ||x.contains(removeWords(2))||x.contains(removeWords(3)))
}
  
}
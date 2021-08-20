package com.spark.core.practice
import org.apache.spark.{SparkContext,SparkConf}
/*
*You have given the follwing data in a file coursefee.txt 
*CourseName,Price,TaxandOthersinPercen
*Hadoop,3000,10
*Spark,3500,14
*AWS,2700,13
*Azure,2800,11
*Java,3000,16
*HBase,3200,20
*
*Accomplish the followings:-
*
*1.	Load this csv file in ROD
*2.	Now calculate the final price using tax and add as 2 column
*3.	Save the final data in HDFS in location "/sparkworkouts/coursefeewithtax" with one file
*/

object excercise11 {
  def main(args:Array[String]):Unit={
    val sc = new SparkContext(new SparkConf()
             .setAppName("excercise11")
             .setMaster("local")
             .set("spark.hadoop.validateOutputSpecs","false"))
        sc.setLogLevel("ERROR")
        
    val courseFileRdd = sc.textFile("file:/home/hduser/coursefee.txt")
    val header= courseFileRdd.first  
    val dataRdd=courseFileRdd.filter(!_.equals(header))
    val courseFieldsRdd = dataRdd.map(x=>x.split(",")).map(x=>(x(0),x(1).toFloat,x(2).toFloat))
    val finalPrice = courseFieldsRdd.map(x=>(x._1,(x._2/x._3)))
    finalPrice.coalesce(1).saveAsTextFile("hdfs://localhost:54310/sparkworkouts/coursefeewithtax") 
    println("file has been sucessfully saved")
        
  }
}
package com.spark.core.practice
import org.apache.spark.{SparkContext,SparkConf}
/*
*4.	Data For Task hdpcd/Inceptez4A.txt
*Inceptez.com techcert.com Incepeztchcert.com
* 
*hdpcd/Inceptez4B.txt
*Hadoop Spark Scala Python Java Cloud DataScience
*
*hdpcd/Inceptez4C.txt
*India USA UK Canada Australia Accomplish the followings:-
*1.	Load all 3 files in different RDDS
*2.	Concatnate all the data in single RDDS
*3.	Count all the words in of all 3 files
 */
object excercise6 {
  def main(args:Array[String]):Unit={
    val sc = new SparkContext(new SparkConf().setAppName("excercise6").setMaster("local"))
    sc.setLogLevel("ERROR")
    
    val rdd1=sc.textFile("file:/home/hduser/hdpcd/Inceptez4A.txt")
    val rdd2=sc.textFile("file:/home/hduser/hdpcd/Inceptez4B.txt")
    val rdd3=sc.textFile("file:/home/hduser/hdpcd/Inceptez4C.txt")
    val rddFinal=rdd1.union(rdd2.union(rdd3))
    rddFinal.foreach(println)
    
  }
}
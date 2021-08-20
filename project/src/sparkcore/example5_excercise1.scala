package sparkcore

import org.apache.spark.{SparkContext,SparkConf}
/*
 *  ***********************
 *  1. Data For Task
 *  **********************
 *  Inceptez1.text
 *  I am learning Apache Spark from Inceptez Learning Resources 
 *  I am learning Apache Hadoop from Inceptez Learning Resources 
 *  I have created my technical profile at www.QuickTechie.com
 *  I am learning Apache Spark from-Training4exam Learning Resurces
 *  **************************
 *  
 *  Accomplish the followings:-
 *  
 *  1. Create this text file is HDFS
 *  2. Once files is created, write the spark Application which will read from HDFS as an RDD
 *  3. Once RDD loaded, do the line count of this RDD
 *  
 */


object example5 {
  def main(args:Array[String])={
    val sc = new SparkContext(new SparkConf().setAppName("Example5.1").setMaster("local"))
    sc.setLogLevel("ERROR")
    val filerdd = sc.textFile("hdfs://localhost:54310/user/hduser/hadoop/Inceptez1.txt")
    println(filerdd.count)
    
  }
}
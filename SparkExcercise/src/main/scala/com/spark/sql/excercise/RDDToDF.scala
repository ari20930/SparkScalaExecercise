package com.spark.sql.excercise

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col
/*
 * toDF
 * createDataFrame()
 */
//userId,movieId,rating,timestamp

case class MovieClass(userID:Int,movieID:Int,rating:Double,timestamp:String)
object RDDToDF {
  def main(args:Array[String]):Unit={
   val spark= SparkSession.builder().appName("RDDToDF").master("local").getOrCreate()
   val sc   = spark.sparkContext
     
     sc.setLogLevel("ERROR")

   val movieRdd = sc.textFile("file:/home/hduser/movies.csv")
   val movieHeader = movieRdd.first 
   val movieDataWithoutHeader = movieRdd.filter(!_.equals(movieHeader))
   
   import spark.implicits._
   val movieCase= movieDataWithoutHeader.map(_.split(",")).map(x=>MovieClass(x(0).toInt,x(1).toInt,x(2).toDouble,x(3)))
   val movieDF = movieCase.toDF()
       movieDF.show()
       movieDF.printSchema()
 
  }
}
package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.Row
import org.apache.spark.sql.functions._


object RDDToDFUsingExplicitSchema {
  def main(args:Array[String]):Unit={

   val spark= SparkSession.builder().appName("RDDToDF").master("local").getOrCreate()
   val sc   = spark.sparkContext
     
     sc.setLogLevel("ERROR")

   val movieRdd = sc.textFile("file:/home/hduser/movies.csv")
   val movieHeader = movieRdd.first 
   val movieDataWithoutHeader = movieRdd.filter(!_.equals(movieHeader))
   val movieMapData = movieDataWithoutHeader.map(_.split(",")).map(x=>Row(x(0).toInt,x(1).toInt,x(2).toDouble,x(3)))
   //In the below  ->Typed Schema ->Explicit Schema
   val schema = StructType(
                StructField("userId",IntegerType,false)::
                StructField("movieId",IntegerType,false)::
                StructField("rating",DoubleType,false)::
                StructField("timestamp",StringType,true)::Nil)

 import spark.implicits._   
   val movieDF = spark.createDataFrame(movieMapData, schema)
    //   movieDF.show()
 
   val schema1 = StructType(Array(
                StructField("userId",IntegerType,false),
                StructField("movieId",IntegerType,false),
                StructField("rating",DoubleType,false),
                StructField("timestamp",StringType,true)))
   val movieDF1 = spark.createDataFrame(movieMapData, schema)                
     //  movieDF1.show()
  
       
     val schema2 = StructType(List(
                StructField("userId",IntegerType,false),
                StructField("movieId",IntegerType,false),
                StructField("rating",DoubleType,false),
                StructField("timestamp",StringType,true)))
   val movieDF2 = spark.createDataFrame(movieMapData, schema)                
     //  movieDF2.show()
     //  movieDF2.filter(col("rating") >=3.0).show()

       
      movieDF2.createOrReplaceTempView("movieDF2View")
      
      spark.sql("""select * from movieDF2View where rating >=4.0""").show()
  }
}
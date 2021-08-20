package com.spark.core.practice
import org.apache.spark.{SparkContext,SparkConf}
/*
*movies.csv
*id,              name            year,rating,views
*1,The Nightmare Before Christmas,1993,3.9,4568
*2,The Mummy,1932,3.5,4388
*3,Orphans of the Storm,1921,3.2,9062
*4,The Object of Beauty,1991,2.8,6150
*5,Night Tide,1963,2.8,5126
*6,One Magic Christmas,1985,3.8,5333
*7,Muriel's Wedding,1994,3.5,6323
*
*
*Accomplish the followings:-
*1.	Load the movies data into the RDD.
*2.	List the movies that having a rating greater than 3
*3.	List the movies that are released after 1980
*4.	List the movies by release year
*5.	Save the final data in HDFS in location "/sparkworkouts/movierelease" into 2 files
*/

object excercise12 {
def main(args:Array[String]):Unit={
  val sc = new SparkContext(new SparkConf().setAppName("excercise12").setMaster("local").set("spark.hadoop.validateOutputSpecs","false"))
      sc.setLogLevel("ERROR")
  val moviesFile = sc.textFile("file:/home/hduser/movies_srini.csv")
  val fieldsRdd  = moviesFile.map(x=>x.split(",")).map(x=>(x(0).toInt,x(1),x(2).toInt,x(3).toFloat,x(4)))
  println("++++++++++++++++++++++solution1+++++++++++++++++++++++++")
  val ratingRdd  = fieldsRdd.filter(x=>x._4 >3)
  println("List the movies that having a rating greater than 3")
      ratingRdd.foreach(println)
  println("++++++++++++++++++++++solution3+++++++++++++++++++++++++")
  println("List the movies that are released after 1980")
  val realaseYearRdd  = fieldsRdd.filter(x=>x._3 >1980)  
      realaseYearRdd.foreach(println)
  println("++++++++++++++++++++++solution4+++++++++++++++++++++++++")
  val moviesByYearRdd=fieldsRdd.map(x=>(x._2,x._3))
  println("List the movies by release year")
      moviesByYearRdd.foreach(println)
  moviesByYearRdd.repartition(2).saveAsTextFile("hdfs://localhost:54310/sparkworkouts/movierelease")
  println("file has been saved successfully") 
}  
}
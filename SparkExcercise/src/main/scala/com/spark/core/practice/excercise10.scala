package com.spark.core.practice
import org.apache.spark.{SparkContext,SparkConf}

/*
*3.	Get the date having maximum transactioncount
* 
*Create and copy file cricket.txt in hdfs location with the data below: 
*Rajiv,21
*Sharma,19 
*Kiran,22 
*Vijay,20 
*Ramesh,25
*
*Create and copy file hockey.txt in hdfs location with the data below: 
*Ramesh,25
*Vimal,21 
*Karthik,24 
*Vinod,22 
*Vijay,20
*Create and copy file football.txt in hdfs location with the data below:
*Ravinder,21 
*Ramesh,25 
*Karthik,24 
*Vijay,20 
*Kannan,22 
*Rajiv,21
*
*Accomplish the followings:-
*
*1.	Find the players who are in cricket and football
*2.	Find the players who are in all 3 sports
*3.	Get all the distinct players
*/

object excercise10 {
  def main(args:Array[String]):Unit={
  val sc = new SparkContext(new SparkConf().setAppName("excercise10").setMaster("local"))
      sc.setLogLevel("ERROR")
      
  val cricketRdd=sc.textFile("file:/home/hduser/cricket.txt")
  val hockeyRdd=sc.textFile("file:/home/hduser/hockey.txt")
  val footballRdd=sc.textFile("file:/home/hduser/football.txt") 
  
  println("+++++++++++++++++++++++++++++++solution1+++++++++++++++++++++++++++++++")
  val cricketFootBallRdd= cricketRdd.intersection(footballRdd)
  println("Find the players who are in cricket and football")
  cricketFootBallRdd.foreach(println)
  
  println("+++++++++++++++++++++++++++++++solution2+++++++++++++++++++++++++++++++")
  val commonPlayerForAllSports=cricketRdd.intersection(footballRdd).intersection(hockeyRdd)
  println("Find the players who are in all 3 sports")
  commonPlayerForAllSports.foreach(println)
  
  
  println("+++++++++++++++++++++++++++++++solution2+++++++++++++++++++++++++++++++")
  val unionRdd=cricketRdd.union(hockeyRdd.union(footballRdd))
  val distinctElementRdd=unionRdd.map(x=>x.split(",")).map(x=>(x(0).trim)).distinct
  println("Get all the distinct players")
  distinctElementRdd.foreach(println)
  
  
  
  }
  
}
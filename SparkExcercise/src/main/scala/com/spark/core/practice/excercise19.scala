package com.spark.core.practice
import org.apache.spark.{SparkContext,SparkConf}
/*
*You have been given below list in scala (name,sex,cost) for each work done.
*List( ("Deepak" , "male", 4000), ("Deepak" , "male", 2000), ("Deepika"
*, "female", 2000),("Deepak" , "female", 2000), ("Deepak" , "male", 1000) , ("Neeta" , "female", 2000))
*Accomplish the followings:-
*Now write a spark program to load this list as an ROD and do the sum of cost for combination of name and gender (as key)
*/

object excercise19 {
def main(args:Array[String]):Unit={  
  val sc = new SparkContext(new SparkConf().setAppName("excercise19").setMaster("local"))
      sc.setLogLevel("ERROR")
  val customerList=List(("Deepak","male",4000),("Deepak","male",2000),("Deepika","female",2000),("Deepak","female",2000), ("Deepak","male",1000),("Neeta","female",2000))
  val customerRdd=sc.parallelize(customerList)
  val resultRdd=customerRdd.map(x=>((x._1,x._2),x._3.toFloat)).reduceByKey(_+_).map(x=>(x._1._1,x._1._2,x._2))
  println("Output of sum of cost for combination of name and gender (as key)")  
      resultRdd.foreach(println)
}
}
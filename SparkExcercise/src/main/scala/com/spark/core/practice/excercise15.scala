package com.spark.core.practice
import org.apache.spark.{SparkContext,SparkConf}
/*
*Given filename sparkworkouts/student.csv 
*1,Lokesh 
*2,Bhupesh 
*3,Amit 
*4,Ratan 
*5,Dinesh
*
*sparkworkouts/marks.csv 
*1~90~80~95
*2~88~90~89
*3~78~76~70
*4~92~69~89
*5~88~70~86
*Note:flatMap one i/p -> mulitple o/p   map-> one i/p ->one o/p
*Accomplish the followings:-
*
*1.	Load the files into RDD and get the studentid,students,markl,mark2,marks3,totalmarks
*2.	Get the highest totalmark mark scored studentinfo
*/

object excercise15 {
  def main(args:Array[String]):Unit={
  val conf = new SparkConf().setAppName("excercise13").setMaster("local").set("spark.hadoop.validateOutputSpecs","false")
  val sc   = new SparkContext(conf)
      sc.setLogLevel("ERROR")
  val studentRdd = sc.textFile("file:/home/hduser/sparkworkouts/students.csv")
  val studentFieldsRdd = studentRdd.map(x=>x.split(",")).map(x=>(x(0),x(1)))
  val markRdd    = sc.textFile("file:/home/hduser/sparkworkouts/marks.csv")
  val markFieldsRdd = markRdd.map(x=>x.split("~")).map(x=>(x(0),(x(1),x(2),x(3))))   
      
  //studentid,students,markl,mark2,marks3,totalmark

  val joinRdd = studentFieldsRdd.join(markFieldsRdd)
  val joinRddTransform = joinRdd.map(x=>(x._1,x._2._1,x._2._2._1,x._2._2._2,x._2._2._3))
  val totalmarks=joinRddTransform.map(x=>(x._1,x._2,x._3,x._4,x._5,x._3.toInt+x._4.toInt+x._5.toInt))
  val highestMarks = totalmarks.sortBy(x=>x._6,false).map(x=>(x._1,x._2,x._6))  
    highestMarks.repartition(2).saveAsTextFile("hdfs://localhost:54310/user/hduser/highestMarks/")
  println("file has been saved succesfully")
  println("Highest Marks gain by student that is:: "+highestMarks.first)
  
  //println(highestMarks.getNumPartitions)
  
  //repartiton -> we can inrease and decrease the no  of partiton and 
  //here data distributed among the partitions equally 
  //i.e. even distrbution of data that is one of the costly method to remove dataskewness 
  //reparition ->full shuffle will happen datamovement from partitions 
  
  //Now if i want to get the o/p in a single file , i will consider coalesce instead repartiton 
  //why
  //beacuse in coalesce , complete shfulle of data will not happen , that's reason it is less 
  //costlier than repartition
  //coalesce is used mainly to decrease the no. of partition-> we might get uneven distribution of data that might lead dataskewness 
  
  
  
}
}
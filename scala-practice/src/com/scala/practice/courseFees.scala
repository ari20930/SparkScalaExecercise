package com.scala.practice

object courseFees {
  def main(args:Array[String]):Unit={
  println("Please enter the cousrse you want:")
  val courseName = scala.io.StdIn.readLine()
  if(courseName == "DataScience")
  {
    println("Please enter the which type of DataScience Course You want:")
    val courseName1 = scala.io.StdIn.readLine()
    println("The Course Is :" + " "+courseName1 +" "+"courseFee is: "+" "+ couseFeesFunction(courseName1))    
    
  }
  else{
    if(courseName == "BigData" || courseName== "Spark")
    {
     println("The Course Is :" + " "+courseName +" "+"courseFee is: "+" "+ couseFeesFunction(courseName))    
    }
    else 
    {
      println("Not a valid Course")
    }
  }
  
  }
  
  def couseFeesFunction(course:String):Int={
    if(course =="BigData")
      return 25000
    else if(course =="Spark")
      return 15000
    else if(course =="MachineLearning")
      return 35000
    else 
      return 45000

      
      
      
  }
 
  
}
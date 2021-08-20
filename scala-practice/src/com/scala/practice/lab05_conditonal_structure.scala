package com.scala.practice

object lab05_conditonal_structure {
  def main(args:Array[String]):Unit={
    
    println("please provide the courseName")
    val courseName = scala.io.StdIn.readLine() 
    
   
  
    
    if(courseName == "bigdata")
      println("fees of bigdata is :" +25000)
    else if(courseName =="spark")
      println("fees of spark is :" +15000)
    else if(courseName =="datascience")
    {
      println("please provide the particular datascient courseName either ml,dl")
     val courseName1 = scala.io.StdIn.readLine() 
      
      if(courseName1 =="machinelearning")
        println("fees of machinelearning is :" +35000)
      else if(courseName1 =="deeplearning")
        println("fees of machinelearning is :" +45000)
        
    }
    
  }
}
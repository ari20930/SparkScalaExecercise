package com.scala.practice

object arrayex3 {
  def main(args:Array[String]):Unit={
    val studMarks=Array(10,20,30,40,50)
    
    val result=studMarks.map(x=>marksValidation(x))
    
    result.foreach(println)
    
  }
  
  def marksValidation(x:Int)={
    if(x<50)
      x+30
    else x  
  }
}
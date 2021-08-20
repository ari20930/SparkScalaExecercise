package com.scala.practice

object amstrong_conditional_structure {
  def main(args:Array[String]):Unit={
    val num = 153
    var n= num
    var remainder=0
    var result=0 
    while(n > 0)
    {
      remainder=n%10
      result=result + scala.math.pow(remainder,3).toInt
      n = n/10
      
      
    }
    
    if(result==num)
    {
      println("It's an armstrong number")
    }
    else
    {
      println("It's not an armstrong number")
    }
  }
}
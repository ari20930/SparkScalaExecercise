package com.scala.practice

object greatestOfThreeNumber {
  def main(args:Array[String]):Unit={
    
    println((largestNum(5,10,15)))
    
  }
  
  def largestNum(a:Int,b:Int,c:Int):Int={
    if(a>b && a>c)
      return a 
    else if(b>a && b>c)
      return b 
    else
      return c 
      
  }
}
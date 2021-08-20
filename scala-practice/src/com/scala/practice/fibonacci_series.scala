package com.scala.practice

object fibonacci_series {
  def main(args:Array[String]):Unit={
    val n=4
    println("fibonacci series is:: "+fibonacci(n))
    
  }
  
  def fibonacci(n:Int):Int={
    if(n<=1)
      n
    else  
      fibonacci(n-1)+fibonacci(n-2)
  }
}
//0 1 2 3 
package com.scala.practice

object reverseOfNumber {
  def main(args:Array[String])={
  val op= reverse1(987654)
    println("Reverse of number is",op)

    
    val num = 123
    val stringOfNum = num.toString()
    println("Reverse of Number is "+ stringOfNum.reverse.toInt)
    
  }
 def reverse1(num:Int):Int={
    var n = num
    var reverse=0 
    var remainder =0 
    
    while(n>0)
    {
      remainder = n %10 
      reverse = (reverse *10) + remainder 
      n = n/10
    }
    return reverse
  }
 
}
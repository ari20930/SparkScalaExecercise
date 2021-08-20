package com.scala.practice
import scala.math._
object armstrongNumber {
  def main(args:Array[String]):Unit={
    val num=153
    var remainder=0
    var totalCubeValue=0 
    var n=num 
   while(n>0){
    remainder=n%10
    totalCubeValue=totalCubeValue+(remainder*remainder*remainder)
    n=n/10 
    
   }
    println("totalCubeValue"+" "+totalCubeValue)
    
    if(totalCubeValue==num)
      println("it's an armstrong number")
    else
      println("it's not an armstrong number") 
    
    
  }
}
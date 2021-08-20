package com.scala.practice

object lab_partially_applied_function {
  def main(args:Array[String]):Unit={
    val add =(a:Int, b:Int, c:Int) => a+b+c 
    
    val c = add(10,20,_:Int)
    
    println(c(30))
    
    val d = add(10,_:Int,_:Int)
    
    println(d(30,50))
  }
}
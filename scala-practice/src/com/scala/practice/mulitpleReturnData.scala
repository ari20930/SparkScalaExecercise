package com.scala.practice

object mulitpleReturnData {

  def main(args:Array[String]):Unit={
    println("1st return of addition of two integer"+" "+add(10,5))
    println("2nd return of divison of two integer"+" "+div(10,3))
    
  }
  
  def add(a:Int,b:Int):Int={
    a+b
  }
    
  def div(a:Int,b:Int):Float={
    a.toFloat/b.toFloat
  }
}


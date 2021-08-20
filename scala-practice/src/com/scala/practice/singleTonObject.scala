package com.scala.practice

object singleTonObject {
  def main(args:Array[String]):Unit={
 
   println(obj1.a)
   println(obj1.add(200,300))
  }
}

object obj1{
  val a =20
  val b =20 
  
  def add(num1:Int,num2:Int):Int={
    return num1+num2
  }
}
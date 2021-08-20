package com.scala.practice
// compile time polymorphism ->method overloading 
//run time polymorephism -> method overiding


object overloading {
  
  def main(args:Array[String]):Unit={
    println(add(2,3))  //1st one 
    println(add(2.0f,3)) //2nd one 
    println(add(2,3,6))  ///3rd one
    
  }
  
  def add(a:Int,b:Int):Int={
    a+b
  }
  
    
  def add(a:Float,b:Int):Float={
   a-b
  }
  
   def add(a:Int,b:Int,c:Int):Float={
   (a.toFloat+b.toFloat+c.toFloat)/3
  }
  
  
}
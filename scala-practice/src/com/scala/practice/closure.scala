package com.scala.practice

object closure {
  var a = 10  //impure due to the variable is var 
  val add=(x:Int) => a+x 
  
  val b = 20   //pure due to the varibale is val
  val sub =(y:Int) => b-y
  def main(args:Array[String])={
    println(add(20))
    
    println(sub(10))
    
  }
  
  
}
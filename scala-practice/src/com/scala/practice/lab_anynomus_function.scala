package com.scala.practice

object lab_anynomus_function {
  def main(args:Array[String]):Unit={
    
 val myfc1 = (str1:String, str2:String) => str1 + str2
  println(myfc1("arindam", "ghosh"))
 
 val add = (x:Int, y:Int) => x+y
 println(add(10, 20))
 
 
 val sub = (x:Int, y:Int) => x-y
  
 println("substraction is: " +sub(30,20))
 
 
 
 
 
 

  
  /*
   * with using wild card
   */
 
   val mul =(_:Int)*(_:Int)
   
   println("multiplication of two number is " +mul(2,3))
   
   
   
   
  
    
  }
}
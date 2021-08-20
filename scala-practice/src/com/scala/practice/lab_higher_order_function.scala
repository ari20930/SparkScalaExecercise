package com.scala.practice

object lab_higher_order_function {
  def math(x:Double , y:Double, func: (Double,Double)=>Double):Double= func(x,y)

 
  def main(args:Array[String])={
    
    
    
    println(math(10,29,(_+_)))
    
    
    val result1 = math(10,20,(x,y)=>x+y)
    
    println("result of addition " +result1)
    
    
    
   
   
    
    
    
    
  }
}
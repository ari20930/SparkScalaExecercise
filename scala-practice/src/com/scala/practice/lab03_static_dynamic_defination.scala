package com.scala.practice

/*
 * we can not assign any value after declearing the val variable
 * we can not assign any type of valyes to existing type either static or dynamic 
 */
object lab03_static_dynamic_defination {
  def main(args:Array[String]):Unit={
    /*
     * Static defination
     */
    val a:Int = 5
    var b:Int = 6
    
    /*
     * Dynamic defination
     */
    
    val a1 = "arindam"
    var b1 = 3.5
    
    println("the static defination data type of val-a is :" +a.getClass())
    println("the static defination data type of var-b is :" +b.getClass())
    
    println("the dynamic defination data type of val-a1 is :" +a1.getClass())
    println("the dynamic defination data type of var-b1 is :" +b1.getClass())
    
   
 
    
   
    
  }
}
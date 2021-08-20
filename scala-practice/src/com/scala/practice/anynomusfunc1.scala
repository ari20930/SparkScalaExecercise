package com.scala.practice

object anynomusfunc1 {
  def main(args:Array[String]):Unit={
    println("The o/p Of anynomus function is::"+" "+increments(5))
    printHelloWorld() 
    
    println(add(3,2))
  }
  
 val increments =(x:Int)=>(x+1)
 
 //Normal Function
 /*def printHelloWorld():Unit={
   println("Hello World")
 }
 * 
 */
 //Anynoms function with zero parameter and zero return
 
 val printHelloWorld=() => println("Hello World")
 
 //Normal Function
 
 /*def add(x:Int,y:Int):Int={
   x+y
 }
 * 
 */
 
 //Anynomus function 
 
val add =(x:Int,y:Int) =>(x+y)

}
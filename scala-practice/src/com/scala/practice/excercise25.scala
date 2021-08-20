package com.scala.practice
//Create a method to find the highest value in the given array 
//if the array is non empty and print 
//it, you must pass array as an argument to the method
object excercise25 {
  def main(args:Array[String]):Unit={
    
    val arrayInput=Array(1,9,12,10,0,2,3)
    printNonEmptyArray(arrayInput)
    
  }
  
  val printNonEmptyArray=(a:Array[Int])=>{
    if(!a.isEmpty){
     a.foreach(println)
     
     println("Higest Elements of an Array::"+" "+a.max)
    }
  }
}
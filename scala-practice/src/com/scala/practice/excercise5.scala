package com.scala.practice
import scala.math._
//Write a progam to find the squareroot, area 
//and perimeter of a circle for the given input using higher order function 
object excercise5 {
  def main(args:Array[String]):Unit={
    
    println("Enter the number which you want find out the square root")
    val num=scala.io.StdIn.readInt()
    println("square root of Number "+num+" is:: "+squareRoot(num))
    println("perimiter of circle is "+perimeter(squareRoot(num)))
    println("area of circle is "+area(squareRoot(num)))
  }
  
val squareRoot:(Int)=>Double =(x:Int)=> sqrt(x)

val perimeter=(r:Double)=> 2*(22.0/7)*r

val area=(r:Double)=> (22.0/7)*r*r


}

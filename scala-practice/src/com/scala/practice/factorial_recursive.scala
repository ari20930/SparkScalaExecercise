package com.scala.practice

object factorial_recursive {
  def main(args:Array[String]):Unit={
    println("Enter the number which you want the factorial")
    val a = scala.io.StdIn.readInt()
    println(factorial(a))
  }
  def factorial(n:Int):Int={
  if(n<=1)
    1
  else
    n*factorial(n-1)
  }
}
package com.scala.practice

object simpleinterest {
  def main(args:Array[String])={
    val op = simpleInterest(10000,2,10.5f)
    println("The simpleinterest is " ,op)
    
  }
  def simpleInterest(p:Int,n:Int,r:Float):Double={
    val cal = (p*n*r)/100
    val totalamt= cal +p 
    return totalamt
  }
}
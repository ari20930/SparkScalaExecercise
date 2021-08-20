package com.scala.practice

object constructor {
  def main(args:Array[String]):Unit={
    val obj1 = new constructor1(1,2.0,"primary")
    val obj2 = new constructor1
    val obj3 = new constructor1(5)
    val obj4 = new constructor1(5,6.0)
  }
  
}

class constructor1(val a:Int,val b:Double,val c:String)
{
  val x =a
  val y =b
  val z =c
  
println(s"the value of x is $x, the value of y is $y, the value of z is $z")

  
  def this(){
    this(20,20.0,"HelloWorld")
  }
  
  def this(a:Int)
  {
    this(a,20.0,"aux2")

  }
  
  def this(a:Int,b:Double)
  {
    this(a,b,"aux3")
  }
}
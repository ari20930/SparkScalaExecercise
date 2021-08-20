package com.scala.practice
import implicit12._
object implicitObject1 {
  def main(args:Array[String]):Unit={
    printDummy()
    val obj=new demo123
    obj.clasmethod
  }
  
  def printDummy():Unit={
    val a="Muthu Krishna"
    println(a.firstChar())
  }
}

class demo123{
  def clasmethod()={
  val b="P.V.Sudhakar"
  println("callig implicit class method firstChar within in class: "+b.firstChar())
  }
  }
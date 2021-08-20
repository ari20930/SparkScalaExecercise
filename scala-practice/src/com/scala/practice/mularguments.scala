package com.scala.practice

object mularguments {
  def main(args:Array[String]):Unit={
    multipleTimes(3,s="Arindam","Ghosh","M")
  }
  
  def multipleTimes(n:Int,s:String*):Unit={
    for(x<-s)
      println(x*n)
  }
}
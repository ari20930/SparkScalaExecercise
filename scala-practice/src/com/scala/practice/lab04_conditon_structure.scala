package com.scala.practice

object lab04_conditon_structure {
  def main(args:Array[String]):Unit={
    val a = 120;
    val b = 130;
    val c = 40;
    
    if (a>b && a>c)
      println(a)
    else if(b>a && b>c)
      println(b)
    else
      println(c)
      
  }
}
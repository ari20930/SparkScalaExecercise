package com.scala.practice

object divisibleBy7NotBy5 {
  def main(args:Array[String]):Unit={
    for(i<-320 to 2000;if(i%7==0 && i%5!=0))
      println(i)
  }
}
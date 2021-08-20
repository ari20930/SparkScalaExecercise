package com.scala.practice

object leapyear {
  def main(args:Array[String])={
    leapyearfun(2013)
  }
  
  def leapyearfun(year:Int):Unit={
    if (year %4 ==0 && year %100 !=0 || year % 400==0)
    {
      println("Year is Leap Year",year)
    }
    else
    {
      println("Year is not Leap Year",year)
    }
  }
}
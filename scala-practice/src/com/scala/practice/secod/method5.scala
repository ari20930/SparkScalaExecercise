package com.scala.practice.secod

object method5 {
  
  def main(args:Array[String]):Unit={
   val result = isLeapYear(2021)  //This year is not LeapYear 2021
   //result = "This year is not LeapYear 2021"
   println(result)
    
  }
 //Unit -> it will not return any  value 
  def isLeapYear(a:Int):String={
    if(a%4==0 && a%100!=0 || a%400==0)
    {
      //If we have more than one statements
      println("This is if block")
       "The year is LeapYear"+" "+a 
     
    }
    
    else{
      println("This is else block")
      println("This is else1 block")

      "The year is not LeapYear"+" "+a  //This year is not LeapYear 2021
    
    }
    
    
  }
}


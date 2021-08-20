package com.scala.practice.secod

// a year is leap year 
// i want to create a customized -> there the i/p paramter  will be year 
object method4 {
  def main(args:Array[String]):Unit={
    
    isLeapYear(2021)
    
  }
  
 //Unit -> it will not return any  value 
  def isLeapYear(a:Int):Unit={
    if(a%4==0 && a%100!=0 || a%400==0)
    {
      //If we have more than one statements
      println("This is if block")
      println("The year is LeapYear"+" "+a)
      
    }
    
    else{
      println("This is else block")
      println("The year is not LeapYear"+" "+a)
      
    }
    
    
  }
}

/*
if(condition){
  
}
else if(condition){
  
}
else{
  
}
*/
//If always have one else but it can have multiple else if


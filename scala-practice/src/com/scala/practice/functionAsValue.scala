package com.scala.practice

object functionAsValue {
  def main(args:Array[String]):Unit={
    
    name(concatName("Muthu","Krishna"))
    
  }
  
 val  name=(s1:String)=>println("The concatination of firstName and lastName is::"+" "+s1)
 
 val concatName=(fname:String,lname:String)=>fname+lname
  
}
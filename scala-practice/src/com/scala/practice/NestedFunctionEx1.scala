package com.scala.practice

object NestedFunctionEx1 {
  def main(args:Array[String]):Unit={
    parentFunction("Arindam")
    
  
  }
  
  def parentFunction(s1:String):Unit={
    //Arindam
    
    def childFunction(str1:String,str2:String):Unit={
      println("concat of two string"+" "+"is"+" "+(str1+str2))
    }
    
   // childFunction(s1,"Ghosh")
    //childFunction(Arindam,Ghosh)
  }
}
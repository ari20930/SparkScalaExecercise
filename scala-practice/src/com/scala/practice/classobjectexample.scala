package com.scala.practice

object classobjectexample {
  def main(args:Array[String]):Unit={
    val obj1 = new name  //way of creating the object 
     println(obj1.lname)
     println(obj1.fname)
     println(obj1.concat1("Mri"))
     
    val obj2 = new name
    obj2.fname="Ari"
    
    println(obj2.fname)
    
    println(obj1==obj2)
    
     
     
    
  }
  
}

class name{
  var fname="arindam"
  val lname="ghosh"
  
 def concat1(midname:String):String={
    val fullname = fname+midname+lname
    
    return fullname
    
  }
}



/*
*public  ->object, class,subclass
*private -> with in a class , it only accessable
*protected ->class->subclass can access method/variable
*/
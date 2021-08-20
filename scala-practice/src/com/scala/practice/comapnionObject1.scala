package com.scala.practice
//whenever an object & class name is same
//object can access the variable and methods && vice-versa 

// to access a class variable and method  -> will create object of class->objectname.variables/method
object comapnionObject1 {
  def main(args:Array[String]):Unit={
    
    val obj1 = new comapnionObject1// object of class companionObject1
    //to access class varible 
    println("the value of x from class is::"+" "+obj1.x)
    println("the value of y from class is::"+" "+obj1.y)
    //to access class method
    
    println("the result of method add from class is::"+" "+obj1.add(200,300))
    
  }
  //object variable should be there outside of main method
  val z=450
  def sub(c:Int,d:Int):Int={
    return c-d
  }
  
}

class comapnionObject1{
  val x=20
  val y=30
  
  def add(a:Int,b:Int):Int={
    return a+b
  }
  
  //accesing object varible
  println("the value of z from object is::"+" "+comapnionObject1.z)
  
  //accssing object method
  
  println("the result of method  inside the object is::"+" "+comapnionObject1.sub(30,20))
  
}


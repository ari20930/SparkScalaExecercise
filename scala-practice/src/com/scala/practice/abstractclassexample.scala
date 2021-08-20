package com.scala.practice
//We can't create object of abstract class

//If i want to access abstract class methods and variables , i need create child class out of it
//Then we need to create object of that child class then access the variables and method of absract class
object abstractclassexample {
  def main(args:Array[String]):Unit={
    val obj = new childclass12
    println(obj.add(30, 24))
    obj.sub(70,30)
    
  }
  
}

abstract class abstract123{
  def add(a:Int,b:Int):Int //unimplemented method
  
  def sub(c:Int,d:Int):Unit={
    println(c-d)
  }
}


class childclass12 extends abstract123{
  def add(a:Int,b:Int):Int={
    return a+b
  }
  

  println("This is child class of abstract class")
}
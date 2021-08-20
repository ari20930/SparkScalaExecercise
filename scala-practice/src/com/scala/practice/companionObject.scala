package com.scala.practice
object companionObject {
  
  def main(args:Array[String]):Unit={
    
  
    
   val object1 = new companionObject
  /* println("the object variable-c "+object1.c)
   println("the object varibale-d "+object1.d)
   println("the class method "+object1.sub(90,30))*/
   
   
  }
  
  val a = 20
  val b =30
  def add(num1:Int,num2:Int):Int={
   return num1+num2
   }
}

class companionObject{
  /*val c= 40
  val d=60
   def sub(num1:Int,num2:Int):Int={
      return num1-num2
    }
  println("the object variable-a "+companionObject.a)
  println("the object varibale-b "+companionObject.b)
  
  println("the object method-add "+companionObject.add(300,400))*/

}
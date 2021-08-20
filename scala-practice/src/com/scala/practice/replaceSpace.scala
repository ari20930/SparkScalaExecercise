package com.scala.practice

object replaceSpace {
  def main(args:Array[String]):Unit={
    val obj1 = new replacingSpace
    println(obj1.replaceSpaceFunction("My name is Arindam who belongs to kolkata"))
  }
  
}

class replacingSpace{
  def replaceSpaceFunction(text1:String):String={
    val replaceText = text1.replace(' ','-')
      return replaceText
  }
}
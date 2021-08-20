package com.scala.practice

class CompanionDemo{
  var x = 5

  def getValue(): Unit ={
    println(s"Value of x is: ${x} and value of y is: ${CompanionDemo.y}" )
  }
}


object CompanionDemo {
  var y = 2.2

  def main(args: Array[String]): Unit = {
    val objectForCompanionDemoClass = new CompanionDemo()
    println(s"Value of x when retrieved from companion object is ${objectForCompanionDemoClass.x}")
    println(s"Value of y when retrieved from companion object is ${y}")

    objectForCompanionDemoClass.getValue
  }

}
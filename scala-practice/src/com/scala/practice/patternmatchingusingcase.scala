package com.scala.practice

object patternmatchingusingcase {
  def main(args:Array[String]):Unit={
  println("Please give the type of operation you want to made")
   val x=scala.io.StdIn.readLine()  //text/string

   
   
   println(x.getClass.getName)
   
println("Please enter the first number")
val a = scala.io.StdIn.readInt() //it will take only intger 

println("Please enter the second number")
val b = scala.io.StdIn.readFloat() //it will take only float 

x match{
case "add"=> println(a+b)
case "sub"=> println(a-b)
case "mul"=> println(a*b)
case "div"=> println(a.toFloat/b.toFloat)
case _=> println("It's not add,sub,mul,div")
  }
}
  
}
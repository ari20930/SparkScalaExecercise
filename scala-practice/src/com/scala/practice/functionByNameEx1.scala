package com.scala.practice

object functionByNameEx1 {
def main(args:Array[String]):Unit={
println(mul(operation(20,30)))
}
val operation=(a:Int,b:Int)=> a+b
def mul(t: => Int):Int={
  //println("calling function operation:"+" "+t)
  return t}
}
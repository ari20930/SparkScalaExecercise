package com.scala.practice

object lab_demo {

def add(x:Int=20,y:Int=30):Int={
x+y
}

def main(args:Array[String]):Unit={
val result = add() 
println("result of addition",result)
println(add())
}
}





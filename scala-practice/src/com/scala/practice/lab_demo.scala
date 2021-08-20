package com.scala.practice

object lab_function_with_default_parameter {

def add(x:Int=20,y:Int=30):Int={
x+y
}

def main(args:Array[String]):Unit={
val result = add() 
println("result of addition",result)
println(add())


println("with one parameter"+ add(40))
}
}





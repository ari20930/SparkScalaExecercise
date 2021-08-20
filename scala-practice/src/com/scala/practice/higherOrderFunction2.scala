package com.scala.practice

object higherOrderFunction2 {
  def main(args:Array[String]):Unit={
   incrementDummy(20)
}

val incrementDummy=(x:Int)=>println("Increment of the number is of x:: "+" "+" "+increment(x))
val increment=(y:Int)=>{
println("value is of y is:: "+" "+y)
var z=y+1 
println("the increment value of the number:: "+y+" "+"is:: "+z)
z
}
}
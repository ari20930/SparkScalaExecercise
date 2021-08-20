package com.scala.practice

object higherorderFunction1 {
 def main(args:Array[String]):Unit={
//  incrementDummy(12)
   incrementDummy(increment(12)) //Here firstTime inner function will be called and o/p or return data will be passed to outter function
}

def incrementDummy(x:Int):Unit={
//println("Increment of the number is:: "+" "+increment(x))
println("Increment of the number is of x:: "+" "+" "+x)  
}
/*
 * 
 */
def increment(y:Int):Int={
println("value is of y is:: "+" "+y)
var z=y+1 
println("the increment value of the number:: "+y+" "+"is:: "+z)
z
}
}


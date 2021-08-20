package com.scala.practice

object functionByParameter {
def main(args:Array[String]):Unit={
operation(sub,20,30)
}



def operation(m:(Int,Int)=>Int,x:Int,y:Int)={


println("the value of x::"+" "+x+" the value of y::"+" "+y)
println(" two number is::"+" "+m(x,y))

}

val add=(x:Int,y:Int)=>x+y
val sub=(x:Int,y:Int)=>x-y

}
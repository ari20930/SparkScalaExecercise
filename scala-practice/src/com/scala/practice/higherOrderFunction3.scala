package com.scala.practice
//A higher-order function takes other functions as a parameter or returns a function 
//as a result
object higherOrderFunction3 {
  def main(args:Array[String]):Unit={
   incrementDummy(increment(20)) //function ->increment() ->o/p or value -> we are taking as parameter of incrementDummy 
}

val incrementDummy=(x:Int)=>{
  println(x)
  
  }
val increment:(Int)=>Int=(y:Int)=>(y+1)
}


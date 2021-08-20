package com.scala.practice

object multiplicationdivision {
 def main(args:Array[String]):Unit={
   println(mul(12,13))
   println(div(12,13))
 }
 def mul(a:Int,b:Int):Int={
   val z = a*b
   z
 }
 def div(a:Int,b:Int):Float={
  val z1 = a.toFloat/b.toFloat
  z1
 }
}
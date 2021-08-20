package com.scala.practice

object oddoreven {
 def main(args:Array[String]):Unit={
   oddeven(5)
 }
 
 def oddeven(num:Int):Unit={
   if(num%2==0)
     println("number is even"+"number is", num)
   else
     println("number is odd"+"number is",num)
 }
}
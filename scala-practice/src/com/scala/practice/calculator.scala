package com.scala.practice

object calculator {
def main(args:Array[String]):Unit={
  
  println("this is calculation o/p multiplication:"+" "+calculator_operation(20,30,"mul"))
  println("this is calculation o/p addition:"+" "+calculator_operation(20,30,"add"))
  println("this is calculation o/p sub:"+" "+calculator_operation(20,30,"sub"))
  println("this is calculation o/p division:"+" "+calculator_operation(20,30,"div"))
}

def calculator_operation(a:Int,b:Int,c:String):Any={
  if(c=="add"){
   return a+b
  }
 else if(c=="sub")
 {
   return a-b
 }
 else{
   if(c=="mul")
     return a*b
   else if(c=="div")
     return a.toFloat/b.toFloat   
 }
}
}


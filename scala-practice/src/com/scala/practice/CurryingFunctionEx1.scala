package com.scala.practice

object CurryingFunctionEx1 {
 def main(args:Array[String]):Unit={
val s1="Muthu"
val s2="Krishna"
println("o/p is"+" "+concat(s1)(s2))

}

def concat(str1:String)(str2:String):String={
str1+" "+str2 
}
}
package com.scala.practice.secod

object palindrome {
 def main(args:Array[String]):Unit={
   isPalindromeOfInt(111)
   isPalindromeOfString("madam")
 } 

val isPalindromeOfInt =(number:Int) =>{
if(number.toString.reverse.toInt==number)
{
println("this is palindrome:: "+number)
}
else 
{
println("this is not palindrome:: "+number)
}
}

val isPalindromeOfString=(word:String) =>{
if(word.reverse==word)
{
println("this is palindrome:: "+word)
}
else 
{
println("this is not palindrome:: "+word)
}
}
}



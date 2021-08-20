package com.scala.practice

object palindrome {
  def main(args:Array[String]):Unit={
    palindromeString("arindam")
    palindromeNumber(122)
    
    
  }
  
  def palindromeString(stringText:String):Unit={
    val text1 = stringText 
    val revtext1 = text1.reverse
    
    if(revtext1 == text1)
    {
      println("It's a palindorme string",text1)
    }
    else{
       println("It's not a palindorme string",text1)
    }
  }
  
  def palindromeNumber(Num:Int):Unit={
    val n= Num 
    val nString = n.toString()
    val revNum = nString.reverse.toInt
    if(n==revNum)
    {
      println("It's a palindorme Number",n)
    }
    else
    {
       println("It's not a palindorme Number",n)
      
    }
  }
}
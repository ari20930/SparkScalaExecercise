package com.scala.practice

object lab06_conditional_structure {
  def main(args:Array[String]):Unit={
    println("enter which type of data either text or number you want to check palindrome: ")
    val type1 = scala.io.StdIn.readLine()
    if(type1=="number")
    {  
    println("please enter the number which you want to validate palindrome or not")
    val orginalNum:Int = scala.io.StdIn.readInt()
    
    var remainder=0
    var reverseNumber =0
    var num =orginalNum
     
    while(num!=0)
    {
      remainder = num%10
      reverseNumber = reverseNumber*10 + remainder
      num = num/10  
    }
    
    
    if(reverseNumber == orginalNum)
     println("palindrome")
    else 
     println("not palindrome")
    }
    else if(type1 == "text")
    {
      println("please enter the text which you want to validate palindrome or not")
      val text = scala.io.StdIn.readLine()
      val charecter = text.toCharArray()
     
      if(charecter.length !=1)
      {  
        if(text.reverse == text)
          println("it's a palindrome")
       else 
         println("it's not a palindrome")
      }
      else
      {
        println("it's a single charecter text , it can't be a text, please enter a proper input")
      }
    }
    
    
  }
}
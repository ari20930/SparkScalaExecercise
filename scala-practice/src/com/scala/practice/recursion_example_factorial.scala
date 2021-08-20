package com.scala.practice

object recursion_example_factorial {
  def main(args:Array[String]):Unit={
    val num=5
    println("factorial of num"+" "+num+" "+factorial(num))
  }
  
  def factorial(x:Int):Int={
    
    if(x==1)
    1
    else
      x*factorial(x-1) 
  }

  //2 =2 *1
  //4 = 4 *3 *2 *1

}

//armstrong number abc=a^3 +b^3+c^3   153=1^1+5^3+3^3=1+125+27 =153




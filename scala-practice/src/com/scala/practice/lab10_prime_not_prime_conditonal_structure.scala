package com.scala.practice

object lab10_prime_not_prime_conditonal_structure {
  def main(args:Array[String]):Unit={
    var num =12
    var flag=0
    var n=num 
    for(i<-2 to n/2)
    {
      if(n%i==0)
      {
        flag=1
      }        
    }
    if(flag!=1)
    {
      println("It's a prime number")
    }
    else
    {
      println("It's a non prime number")
    }
  }
}
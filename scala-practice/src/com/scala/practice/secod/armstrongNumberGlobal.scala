package com.scala.practice.secod
import scala.math._ // to access inbuilt math function

object armstrongNumberGlobal {
  def main(args:Array[String]):Unit={
    val number =548834
    
    val numberLength = number.toString.length() // to get number length -> converting to String and using length() to get the length 
    var n=number
    var remainder=0
    var total=0
    
    while(n>0){
      remainder=n%10  //5488334%10=4
      total=total+( pow(remainder, numberLength).toInt)  //pow() -> it will return Double to convert it into Int using toInt
                                                    //0+pow(4,5)= 0+4*4*4*4*4
      n=n/10 //54883
    }
    
    println("total is:: "+total)
     if(total==number)
     {
       println("this is armstrong number:: "+number)
       
     }
     else
     {
        println("this is not armstrong number:: "+number)
     }
  }
  }
package com.scala.practice.secod
//args data will get from runtime/argument(Run Configuration ->click on argument -> pass the argument)
object method2 {
  def main(args:Array[String]):Unit={
    
    val result = abdc5(20,30)
    println("result is :: "+" "+result)  //result is ::  0
        
    val result1 = abdc6(20,30)  // you will not get anything ()

    println("result1 is :: "+" "+result1)  //result1 is ::  ()
    
  }
  
          //20    30
  def abdc5(a:Int,b:Int)={  //Int
    
  //  println(a+b)
  //  a*b
  //  a/b
  //  a+b
    
  //a=50
  //b=60  -> reassignment to val
    
    val e =a  //20
    val f =b //30
    println("the addition is of abdc5:: "+" "+(e+f))  // it will give the result 
                                                      //the addition is of abdc5::  50
    e*f
    e-f
    e/f // it will return  //result is ::  0
   
  }
              //20  30 
    def abdc6(a:Int,b:Int)={  //Unit
    val e =a  //20
    val f =b  //30 
    e*f
    e-f
    println("the addition is abdc6:: "+" "+(e+f)) //the addition is abdc6::  50
  }
}

// when a function return a vlaue -> the return type should be other than Unit -> it can Int,Float,Double,String,Char,Map[Int,String],(String,String),List[Int],Array[String],Set(Int)..
//when a function does'nt return a value -> the return type must be Unit 

//i can return a value from a function using return a / a 
// return keyword -> return type must be there 
// if don't use return keyword -> return dataype is optional 







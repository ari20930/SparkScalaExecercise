package com.scala.practice

object highOrderFunction4 {
  def main(args:Array[String]):Unit={
    println("addition of two numbers are:: "+calculator(add,20,30))
    println("multiplication of two numbers are:: "+calculator(mul,20,30))
    println("divsion of two numbers are:: "+calculator(div,20,30))
    println("subtraction of two numbers are:: "+calculator(sub,20,30))
  }
  
  val calculator=(m:(Int,Int)=>AnyVal,x:Int,y:Int)=>m(x,y)
   
  //val add:(Int,Int)=>Int=(a:Int,b:Int)=>a+b
  
  /*
   * println(num1=20,num2=30,functionasParamter=add)
   * 
   * def calcualtor(num1:Int,num2:Int,functionasParamter:(Int,Int):AnyVal):AnyVal={
   * 
   * functionasParamter(num1,num2)
   * //add(20,30)
   * 
   * }
   * 
   * def add(a:Int,b:Int):Int={
   * 
   * a+b
   * }
   * 
   */
  

  val add=(a:Int,b:Int)=>a+b 
  //val add:(Int,Int)=>Int=(a:Int,b:Int)=>a+b
  val sub=(a:Int,b:Int)=>a-b
  val mul=(a:Int,b:Int)=>a*b
  val div=(a:Int,b:Int)=>(a.toFloat/b.toFloat)
  val defualt=(a:Int,b:Int)=>println("a::"+" "+a+"b::"+" "+b)
  

  
  //val add:(Int,Int)=>Int=()
}
package com.scala.practice

object partiallyAppliedFunctionex3 {
  def main(args:Array[String]):Unit={
    petorlPrice(2021,102.00)
    dieselPrice(2021,98.00)
    
    println("Hello Word")
  }
  
  val petorlPrice=oil(_:Int,_:Double,"Petrol")
  val dieselPrice=oil(_:Int,_:Double,"Diesel")
  val oil=(year:Int,price:Double,oilType:String)=> println("This "+" "+year+" "+oilType+" "+"price is "+ price )
}
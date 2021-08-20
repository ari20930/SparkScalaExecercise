package com.scala.practice
//Create customer class and every 100 rupees purchase credit 1 points

//bigbazar wallet=10 
// purchased =1000 rs product 
//bigbazar wallet=10+10
object excerecise1 {
  
  def main(args:Array[String]):Unit={
    
    println("enter the total amount which customer purchased")
    val amtPurchase=scala.io.StdIn.readDouble()
    
    println("enter the total credit point which customer has")
    val creditPoint=scala.io.StdIn.readInt()
    
    val obj = new Customer
    println("customer wallte point is:: "+obj.addCredit(amtPurchase,creditPoint))

  }
  
}

class Customer{
  var walletbalence1=0
  def addCredit(amt:Double,walletbalence:Int):Int={
   if(amt>100) 
   {
     walletbalence1=walletbalence //creditpoint =10
     walletbalence1=walletbalence1+((amt/100)*1).toInt
   }
   
    walletbalence1
  }
  
  
}

//2000/100=20*1.0
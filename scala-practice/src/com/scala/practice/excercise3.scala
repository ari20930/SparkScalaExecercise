package com.scala.practice
//Create order class and add, delete,update and get orders using list
import scala.collection.mutable._
object excercise3 {
  def main(args:Array[String]):Unit={
    
    println("Enter the  no. of order to be added")
    val addOrder=scala.io.StdIn.readInt()
    
    println("Enter the  no. of order to be deleted")
    val deleteOrder=scala.io.StdIn.readInt()
    
    println("Enter the  which no. of order to be updated")
    val updateOrder=scala.io.StdIn.readInt()
    
    println("Enter the  new updated order no.")
    val updateOrder1=scala.io.StdIn.readInt()
    val obj = new order
    
    //println("newly added order list:: "+obj.add(addOrder))
   // println("after removing from the exisiting list then the new order list:: "+obj.remove(deleteOrder))
   // println("updating an order from an existing list:: "+obj.update(updateOrder,updateOrder1))
  
    
    println("Intial Elements in order list:: ")
    obj.get()
    
    obj.add(addOrder)
    println("newly added order list:: ")
    obj.get()
    
    
    obj.remove(deleteOrder)
    println("after removing order from list:: ")
    obj.get()
    
     obj.update(updateOrder,updateOrder1)
     println("after updating order from list:: ")
     obj.get()
     
  }

}

class order{
 
  
  var order=ListBuffer[Int](1,2,3,4,5)

  val add:(Int)=>Unit=(addOrder:Int)=> {
    order+=addOrder 
    order.toList
    
  }
  
  
  val remove:(Int)=>Unit=(deleteOrder:Int)=> {
    order-=deleteOrder
    order.toList
  }
  
  val update:(Int,Int)=>Unit=(updateOrder:Int,updateOrder1:Int)=>{
    
    for(i<-0 to order.length-1){
      if(order(i)==updateOrder)
        order(i)=updateOrder1
    }
    
   order.toList
  }
  
   def get():Unit={
   println(order.toList)
 }
 
}
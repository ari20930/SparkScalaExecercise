package com.scala.practice
//Write a program to create an Int List with 5 different values using range 
//and sum all the values

object excercise26 {
  def main(args:Array[String]):Unit={
    val list1=Range(1,6)
    
   
 //   println("sum of 5 different number is:: "+list1.toList.sum)
    sum1(list1.toList)
    
    }

val sum1=(list1:List[Int])=>{
      var sumValue=0
      for(i<-list1)
        sumValue=sumValue+i
      println("sum of 5 different number is:: "+sumValue)  
      }
  
}
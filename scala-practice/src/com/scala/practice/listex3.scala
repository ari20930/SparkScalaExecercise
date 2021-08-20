package com.scala.practice

object listex3 {
  def main(args:Array[String]):Unit={
    val list1=List(1,2,3,4,10,12,11,14,13,19,21)
    
  
    
    var listOdd:List[Int]=Nil
    var listEven:List[Int]=Nil
    
    for(i<-0 to list1.length-1)
    {
      if(i%2==0)
      {
        listOdd=i ::listOdd 
        
        //listOdd=i +:listOdd
        
      }
      else
      {
        listEven=i ::listOdd 
        
      }
      
    }
    
    println(listOdd.max)
    println(listEven.max)
    
    
    
    
    
  }
}
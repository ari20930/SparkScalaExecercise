package com.scala.practice

object listex1 {
  def main(args:Array[String]):Unit={
    val list1=List(1,2,3,4,10,12,11,14,13,19,21)
    
    var element1=list1(0)  //1
    var element2=list1(0)  //1 
    
    for(i<-0 to list1.length-1)
    {
      if(element1<list1(i))  //4<10
      {
        element2=element1  //element2=4
        element1=list1(i)  //element1=10  
      }
      else{
        if(element2 > list1(i) && element1!=list1(i)){
          element2=list1(i)
        }
        
      }
      
    }
    
    println(element2)
    
    
  }
}
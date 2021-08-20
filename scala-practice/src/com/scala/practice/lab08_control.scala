package com.scala.practice

object lab08_control {
  def main(args:Array[String]):Unit={
   var number= 5;
   while(number >=5 && number <=20)
   {
     if(number % 2 ==0)
       println("even number is: " +number)
     else
       println("odd number is: " +number )
      
   number +=1   
       
   }
   
   for(i<- 5 to 20)
   {
     if(i%2 ==0)
       println("even ",i)
     else
       println("odd ",i)
       
   }
   var n =0
   println("============incrementa value==============")
   for(i<-0 to 21)
   {
     println("incremental number of i+3", n)
    n = i+3
    
   }
   
   println("===========cube of number===============")
   var qubic =0
   var n2=0
   println("plese enter the number which you want to find cube")
   val n1=0
   while(n1!=0)
   {
     n2=n1
     qubic=n2*n2*n2
   }
   
  }
}
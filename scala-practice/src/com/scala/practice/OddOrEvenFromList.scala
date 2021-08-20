package com.scala.practice

object OddOrEvenFromList {
 def main(args:Array[String]):Unit={
   val list1 =List(1,2,3,4,5,6,7,8,9,10)
   for(i<-0 to list1.length)
   {
     if(list1(i)%2==0)
     {
       println(s"even Number is $list1(i)")
     }
   }
 }

}
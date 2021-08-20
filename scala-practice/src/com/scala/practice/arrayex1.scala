package com.scala.practice
import scala.collection.mutable.ArrayBuffer
object arrayex1 {
  def main(args:Array[String]):Unit={
    
  val array1=ArrayBuffer[Int]()

    arrayMax(array1)
    
    array1+=(2,4,5,6,7,8,10)
    arrayMax(array1)
    
  val array2=ArrayBuffer[Int](40,50) 
  array2+=(2,4,5,6,7,8,10)
  arrayMax(array2)
  
  }
def arrayMax(a:ArrayBuffer[Int]):Unit={
  if(a.isEmpty)
  println("Array is empty")
  else 
  println("the maximum value of this array is::"+a.max) 
}
}
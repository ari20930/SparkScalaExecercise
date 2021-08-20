package com.scala.practice

object listex2 {
  def main(args:Array[String]):Unit={
    
val list1 = List(10,12,21,-23,7,16,32,23,18,-10)

var sumNegativeNumbers=0
var sumEvenNumbers=0
var sumOddNumbers=0
list1.foreach(x=>{
if(x<0)
sumNegativeNumbers=sumNegativeNumbers+x
else if(x%2==0)
sumEvenNumbers=sumEvenNumbers+x 
else if(x%2!=0)
sumOddNumbers=sumOddNumbers+x 
})
println("sumNegativeNumbers:: "+sumNegativeNumbers)
println("sumEvenNumbers :: "+sumEvenNumbers)
println("sumOddNumbers:: "+sumOddNumbers)


    
  }
}
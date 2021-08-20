package com.scala.practice

object excercise4 {
  def main(args:Array[String]):Unit={
val list1=List(List("Hadoop",2900,15),List("Spark",3500,14),List("AWS",2700,13),List("Azure",2800,11),List("Java",3000,16),List("HBase",3200,20))
//List[List[Any]]
list1.map(x=>{
 var price:Any=0.0
  var percentage:Any=0.0
  var courseName:Any=null
  courseName=x(0)
  price=x(1) 
  percentage=x(2)
 calculate1(courseName.toString(),price.toString().toDouble,percentage.toString().toDouble)    
   
})
}
  
  
  
val calculate1:(String,Double,Double)=>Unit=(courseName:String,price:Double,percentage:Double)=>{
var totalPrice=0.0 
totalPrice=totalPrice+(price*(percentage/100))
println("courseName is"+" "+courseName+" "+"total price with tax is:: "+" "+totalPrice)

}  
}
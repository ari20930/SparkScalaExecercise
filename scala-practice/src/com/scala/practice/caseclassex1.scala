package com.scala.practice

object caseclassex1 {
  def main(args:Array[String]):Unit={
    //here while creating an object of this class new is not mandate
    
    val obj = car("BMW","s02")
    obj.printDummy()
    obj.name = "Mercedes" // since the default constructor variable type is val
   println("The new car name is"+obj.name)
  }
}



case class car(var name:String,model:String){
  val carName = name
  val carModel = model 
  
  def printDummy():Unit={
    println(s"car name is $carName and car-model is $carModel")
    
  }
}
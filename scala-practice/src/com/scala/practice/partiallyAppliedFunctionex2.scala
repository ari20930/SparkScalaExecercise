package com.scala.practice

object partiallyAppliedFunctionex2 {
  def main(args:Array[String]):Unit={
    car("Suzuki")
    truck("Swraj")
  }
  
  val car=fourWheeler(_:String,"Car",200000)
  val truck=fourWheeler(_:String,"truck",400000)
  
  val fourWheeler=(carName:String,carType:String,price:Int)=>println(carName+" "+carType+" "+price)
}
package com.scala.practice

object patternmatch1 {
  def main(args:Array[String]):Unit={
    
   println("The datatype of the variable::" + " "+dataTypeOfVariable(10))
    println("The datatype of the variable::" + " "+dataTypeOfVariable(10.5f))
     println("The datatype of the variable::" + " "+dataTypeOfVariable(10.5))
      println("The datatype of the variable::" + " "+dataTypeOfVariable("Muthu"))
       println("The datatype of the variable::" + " "+dataTypeOfVariable('T'))
  }
  def dataTypeOfVariable(x:Any):Any={
    x match{
      case _:Int => "Integer Type"
      case _:Float => "Float Type"
      case _:Double => "Double Type"
      case _:String => "String Type"
      case _:Char   => "Charecter type"
      case _       => "It's not belongs Int/Float/Double/String/char"
    }
  }
}


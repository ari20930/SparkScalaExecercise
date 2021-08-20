package com.scala.practice

  //def method(a:Int,b:Int)={}
  //def method(a:Int,b:Int):Unit={}
 // def method(a:Int,b:Int):Int={}

//Any 
//AnyVal AnyRef
//AnyVal->Int,Float,Double,Short,Byte etc 
//AnyRef->Object,collections(List,Map,Set,Array),String

object patternmatch2 {
  def main(args:Array[String]):Unit={
    println(pattermatch(6.0))
     
    
  }
  def pattermatch(a:Any):Any=a match{
    case _:Int => "Integer Type"
    case _:Double => "Double Type"
    case _:String => "String Type"
    case _:Float  => "Float Type"
    case _:Char => "Character Type"
  }
}

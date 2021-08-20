package com.scala.practice

object implictclassobject {
  implicit class classdummy(s:String){
    def firstChar():String={
      s.substring(0,1)
    }
  }
}
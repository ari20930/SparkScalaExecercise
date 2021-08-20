package com.scala.practice

import scala.util.control.Exception.catching

object catchingexceptionex1 {
  def main(args:Array[String]):Unit={
val catchException = catching(classOf[ArithmeticException]).withApply(e=>println("ArithmaticException occure"+" "+e))
val a = catchException(10/0)

if(a!=())
{
println(a)
}

}


}
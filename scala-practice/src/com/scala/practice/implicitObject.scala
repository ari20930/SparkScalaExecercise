package com.scala.practice

import implicit12._

object implicitObject {
  def main(args:Array[String]):Unit={
    val arr="Arindam Ghosh"
    println(arr.firstChar())
  }
}
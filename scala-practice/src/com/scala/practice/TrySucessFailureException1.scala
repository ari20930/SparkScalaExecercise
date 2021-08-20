package com.scala.practice
import scala.util.Try
import scala.util.Success
import scala.util.Failure
object TrySucessFailureException1 {
  def main(args:Array[String]):Unit={
    val a = Try(10/0)
    
    a match{
      case Success(a1) => println(a1)
      case Failure(b1)=>println(b1)
    }
  }
  
  
}
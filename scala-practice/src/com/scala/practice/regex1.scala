package com.scala.practice
import scala.util.matching.Regex

/*
 * step1: 
 * import scala.util.matching.Regex
 * step2:
 * create an object of Regex class with the pattern which you want to match
 *
 * val obj= new Regex("Hello")
 * 
 * or 
 * 
 * val obj1= ("Hello").r 
 * 
 * step3:
 * 
 * val op= (obj findFirstIn text1)
 * 
 * val op=(obj findAllIn text1).toArray / .mkString(",")
 *  
 *
 */

object regex1 {
  def main(args:Array[String]):Unit={
    val obj = new Regex("Hello")
    
    val textDetails = "Hello how are you madam !! Hello"
    
    println("This is first o.p=>")
    var op= (obj findFirstIn textDetails)
    println(op)
    
   val obj1 = new Regex("Hello")
    
     println("This is second o.p=>")
   var op1 = (obj1 findAllIn textDetails).mkString(",")
   println(op1)
   
   println("This is third o.p=>")
   var op2 = (obj1 findAllIn textDetails).toArray
   op2.foreach(println)
   
   
   val obj3 = new Regex("(H|h)ello")
    
    println("This is four o.p=>")
   val textDetails1 = "Hello how are you madam !! Hello hello" 
     var op3 = (obj3 findAllIn textDetails1).mkString(",")
   println(op3)
   
      
   val obj4 = ("[H|h]ello").r //[H|h],[H,h],(H|h)
    
    println("This is five o.p=>")
     var op4 = (obj4 findAllIn textDetails1).mkString(",")
   println(op4)
   
  val textDetails2 = "Hello ,Sir this is my address 1231 bekar street 12th floor apratmentnme 012" 
 //("//d+")=> it will more than one digit , if we use only ("//d") will give single sigle digit
 //("//D+")=> it will all words from a text/string other than number, if we use only ("//D") will give single  char 
  val obj5=("\\d+").r
  println("This is six o.p=>")
     var op5 = (obj5 findAllIn textDetails2).mkString(",")
   println(op5)
  
    
  }
}
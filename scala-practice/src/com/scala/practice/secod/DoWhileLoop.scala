package com.scala.practice.secod

object DoWhileLoop {
  def main(arg:Array[String]):Unit={
   var a=30
   do{
     a=a+1
     println(a)
   }while(a<=20)
  }
}

/*

do{
//statements
 }while(codition)

*/

/*  while -> 1st check the condition and do the work 
 *  do while -> 1st do the work then check the condition
 *  while -> if the condition is not satisfying then it will not go into the loop that means in we will got any thing
 *  do while -> if the condition is not satisfying still we will get one value because condition checking happening the after doing the work.
 *  
 */


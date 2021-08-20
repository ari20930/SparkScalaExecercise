package com.scala.practice.secod

object forLoop {
  def main(args:Array[String]):Unit={
    /*
     * 1st way
     * 
     */
    
    for(i<-0 to 10) 
    {
      println("1st way::"+i)
    }
    
    /*
     * 2nd way
     */
    println("+++++++++++++++++++++++++++++++++++++++++++++++++++")
    for(i<-0 until 11)
    {
      println("2nd way::"+i)
    }
  println("+++++++++++++++++++++++++++++++++++++++++++++++++++")

  for(i<-0 to 10 by 2)
  {
     println("3rd way::"+i)
  }
  
println("+++++++++++++++++++++++++++++++++++++++++++++++++++")
      for(i<-0 until 11 by 2)
    {
      println("4th way::"+i)
    } 
println("+++++++++++++++++++++++++++++++++++++++++++++++++++")
var a=0
for(i<-0 to 10)
{
  a=i+2
  println("5th way::"+a)
}



println("+++++++++++++++++++++++++++++++++++++++++++++++++++")

for(i<-0 until 11)
{
  var b=0
  b=i+2
  println("6th way::"+b)
}




  }
}
package com.scala.practice
//if you are using return keyword while returning any value from a method ,
//it's mandatory to give reuturn data type
//But it's not mandate to have return key word although to have return datatype
// If we have mulitple return statements with out return keyword- it will retrun the last statements
//If we have mulitple return statements , some of them with return keyword- 
//In this case 1st return statements with return keyword will give the result


object multiplereturnstatements {
  def main(args:Array[String]):Unit={
    println("1st return",add(10,5))
    
    println("2nd return",mulreturn(20,25))
    
      println("3rd return",mulreturn1(40,10))
        println("4th return",mulreturn2(40,15))
    
  }
  //a+b =15
  def add(a:Int,b:Int):Int={
    return a+b
    a*b
    a-b
  }
  //a+a =40
    def mulreturn(a:Int,b:Int):Int={
    a*b
    a-b
    a+a
  }
    
    //a-b =30
    def mulreturn1(a:Int,b:Int):Int={
    a*b
    return a-b
    a+a
    return b+b
  }
    
   //a/b -> retrun type as float  2.66..      
    def mulreturn2(a:Int,b:Int)={
    a*b
    a-b
    a+a
    b+b
    a.toFloat/b.toFloat
  }
}
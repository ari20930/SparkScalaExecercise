package com.scala.practice

//Primary paremetrized constructor with default value 
//Primary paremetrized constructor with out default value
//Auxilary->Parameterized or Non-Parameterized 
//No. Of. Primary Constructor in a class -> 1  
//No. Of. Aux Constructor in a class -> multiple  
object constructor23 {
  def main(args:Array[String]):Unit={
   //   val obj = new construc(20,30) //50
  //    val obj1 = new construc() //40
  //    val obj2 = new construc(50) //90
    
    val obj3 = new construc() //49

  }

}

class construc(a:Int=25,b:Int=24){
  val a1=a
  val b1=b
  println("a value is:"+" "+a1+" b value is:"+" "+b1+" addition of two value is:"+" "+(a1+b1))
  
 /* def this(){
    this(30,10)
  }
  
  def this(a:Int)
  {
    this(a,40)
  }
  * 
  */
}
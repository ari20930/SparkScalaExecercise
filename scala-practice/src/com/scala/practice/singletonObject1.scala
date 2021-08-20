package com.scala.practice

object singletonObject1 {
  def main(args:Array[String]):Unit={
   //objectname.varibale_name objectname.methodname 
    println("the value of x is: "+" "+singletoneobject2.x)
     println("the value of y is: "+" "+singletoneobject2.y)
    singletoneobject2.dummyMethod()
    

    
  }
}

object singletoneobject2{
  val x=20
  val y=30
  
 def dummyMethod():Unit={
    println("This is the method under singletone object")
  }
}



/*
*1st: SigleTonObject-> If one object have only a single object
* 2nd: To access object method/variable  objectname.variable_name/objectname.method_name
*/

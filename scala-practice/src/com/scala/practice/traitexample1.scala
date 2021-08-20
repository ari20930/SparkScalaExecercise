package com.scala.practice


//Note1: to access multiple parent class from one/child class using inheritence property, 
//it's not possible, scala we are having something traits to achive this property.

//Note2: We can access traits methods and variables using child class object 

//Note3: We can have unimplemented method in trait and same unimplemented method can be 
//implementd in child class 


object traitexample1 {
  def main(args:Array[String]):Unit={
   val childobj = new BMW1
   childobj.breaks()
   childobj.wheels()
   childobj.engine()
   childobj.musicSystem()
   println(childobj.xyz)
   println(childobj.yzw)
  }
}

trait car124{
  def engine():Unit={  //function declaration
   println("This is 500 cc car")
  }
  def wheels()  //function defination
  def breaks()  //function defination
  
  def musicSystem():Unit={
    println("Dolby")
  }
  val xyz=1234
  val yzw=546
}


class BMW1 extends car124{
  def wheels():Unit={
    println("4 wheels")
  }
  
  def breaks():Unit={
    println("2 breaks")
  }
}



package com.scala.practice.secod

object oopsex1 {
  def main(args:Array[String]):Unit={
   val obj1 = new A  // obj1 is the regular object or normal object or instance name 
    
    println("+++++++++++++++++inside the main method+++++++++")
    obj1.method1() // to access class methods 
    println("obj1.variable1 "+obj1.variable1)// to acess class variables 
    println("obj1.variable2 "+obj1.variable2)
    
    /*
     * Accessing singleton object i.e.singleton2 method and variables inside the main method
     * 
     */
    
    singleton2.singleTonMethod()
    println("singleton2.singleton2variable "+ singleton2.singleton2variable)
    
  }
  
   val obj2 = new A  // obj1 is the regular object or normal object or instance name 
    println("+++++++++++++++++outside the main method+++++++++")
    obj2.method1() // to access class methods 
    println("obj2.variable1 "+obj2.variable1)// to acess class variables 
    println("obj2.variable2 "+obj2.variable2)
    
    
    
}

class A{
  
  def method1(){
   println("this is class method1") 
  }
  
  val variable1=20
  val variable2 =30
  
  
  
}

//to access singleton object variables and methods from
//inside the main-method of singletoneobject/outside the main-method/or
//any other singleton object /or from any class -> 
//we can directly use singleobjectname.methodname or variablename

object singleton2{
  
  /*
   * to access class A methods and variables
   */
  val obj3 = new A 
  println("+++++++++++++++++Inside the other singleton object accessing class variable and methods+++++++++")
  obj3.method1()
  println("obj3.variable1 "+obj3.variable1)// to acess class variables 
  println("obj3.variable2 "+obj3.variable2)
  
  /*
   * Single tone variable and method
   */
 
  val singleton2variable ="SingletonVariable"
  
  def singleTonMethod(){
    println("this is singleton method")
  }
  
  
  
}
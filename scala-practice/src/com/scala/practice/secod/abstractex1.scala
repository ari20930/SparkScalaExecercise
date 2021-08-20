package com.scala.practice.secod

/*
 * 1st: we can't instantiate abstract class i.e. we can't directly create object or instance out of it 
 * 2nd: to access abstract class methods/ variables, we need to have a child class from the child class object we can access the corresponding abstract class methods and variables
 * 3rd: We can have unimplemented method under the abstract class , it will implemented under the child class
 *  
 *  
 * Abstraction is the process to hide the internal details and showing only the functionality
 * In Scala, abstraction is achieved by using an abstract class.
 * In Scala, an abstract class is constructed using the abstract keyword.
 * It contains both abstract and non-abstract methods and
 * *cannot support multiple inheritances. 
 *  A class(child class) can extend only one abstract class.
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 */
object abstractex1 {
  def main(args:Array[String]):Unit={
    
 
    val childobj = new child1
    /*abstract class methods and variables*/
    println("childobj.ab1 "+childobj.ab1)
    println("childobj.ab2 "+childobj.ab2)
    childobj.abmethod()
    childobj.abmethod1()  // unimplemented method of abstract class
    
    
    /*child class variables and methods*/
    println("childobj.ch1 "+childobj.ch1)
    println("childobj.ch2 "+childobj.ch2)
    childobj.childmethod1()
    
    
    

    
  }
  
}

abstract class abs1{
  val ab1=20
  val ab2=30
  
  //implemented method  or non-abstract method
  def abmethod()={
    println("this is abstract method")
  }
  
  
  def abmethod1() // unimplemented method or abstract method
  
}

class child1 extends abs1{
  
  
  // we are implementing abstract class unimplemented method to it's child class
  def abmethod1()={
    println("this is implemented method in child class of unimplemented method from abstract class")
  }
  
  
  val ch1=70
  val ch2=80
  
  def childmethod1()={
    println("this is childmethod1")
  }
}


 
package com.scala.practice

//Note1:value class -> can't extends a trait  for that we have something 
//that is called universal trait

//Note2:Value class -> must have one parameter type as val 
//class classname(val a:Int) extends AnyVal

//Note3:Value class must extends AnyVal

//Note4: Value class must not have any fields defination/variables decleration
//val a=5 

//Note5: Universal trait is nothing but a trait which is extending "Any" class 
//trait a extends Any ->Universal Trait 


//Benefits:
//a. Memory consumption will be less since it doesn't have any variables decleration 
//b. Provides better Peformance 
//c. less intialze 






object valueclassexample {
  def main(args:Array[String]):Unit={
    
    val obj = new valueclass1(5)
   println(obj.a)
    
    println("++++++++++++++++++++++++++++++++++++")
    obj.printDummy()
    println("++++++++++++++++++++++++++++++++++++")
   obj.printDummyValueClassMethod()
    println("++++++++++++++++++++++++++++++++++++")
     println(obj.printVariables())
    
    
  }
}


//creating universal trait 

trait carnew9 extends Any{
  def printDummy():Unit={
  println("This is an universal trait")
  }  
}


//creating a value class 

//AnyVal->Int,Flot,Double,Short,Byte,Long etc 
//String & collections are not come under AnyVal,it comes under AnyRef

class valueclass1(val a:Int) extends AnyVal with carnew9{
 
  def printDummyValueClassMethod():Unit={
    println("this is value-class method")
  }
 
def printVariables():Int={
    return a
  }


//like the below field defination /declaration /printing of variables 

//println(a)
//val c =10


}



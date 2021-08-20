package com.scala.practice
//object can have main method or can't have method
// whatever object can't have main method that is called singleton object
//to run program you must have main method under a object that is mandatory
//but a porgam can/can't have 
//singleton object,class,trait etc.
	   trait traitnew{
	   def add(a:Int,b:Int):Int   //unimplemeted method
	   
	   def sub(a:Int,b:Int):Int={  //implemented method 
	   a-b
	   }
	   }
	   
	   
	   class child extends traitnew{
	   def add(a:Int,b:Int):Int={
	   a+b
	   }
	   //i want to printDummy() from child class 
	 //  object1.printDummy()
	   }
//this is object where main method is there	   
	   object main1{
	   def main(args:Array[String]):Unit={
	   val childobj = new child
	   println(childobj.add(12,34))
	   println(childobj.sub(30,20))
	  
	   }
	    val x=12
	   val y=123
	   println(x,y)
	   
	   }
/*	   
//this is an singleton object	   
	   object object1{
	   val childobj1 = new child
	   println(childobj1.add(12,34))
	   println(childobj1.sub(30,20))
	   
	   def printDummy()={
	   println("This is object1")
	   }
	   
	   val z1=2
	   val z2=3
	   println(z1,z2)
	   
	   //i want to access main1 variables x,y  ->x,y should be there out-side the main method
	   println("this is from main1 object where main method is there value of X:: "+main1.x)
	    println("this is from main1 object where main method is there value of Y:: "+main1.y)
	   }
*/
package com.scala.practice

//import com.scala.practice.classDummy123._
object overidingex1 {
  def main(args:Array[String]):Unit={
    val child1obj = new child1 
    child1obj.add(2,1)
    
    val parentobj = new parent 
    parentobj.add(2,1)
    
   println( child1obj.a)
   
  // println( child1obj.x)  ->It will throw an error because it's private value of parent class 
   
 //child1obj.mul(21,23)   -> ->It will throw an error because it's private metho of parent class
    
   
 //  child1obj.div(2,3) ->Since it's protected method of parent class so it can be access by parent class and with in child class
 val objClassDummy = new classDummy123
 objClassDummy.printDummy()
  
  }
  
}

class parent{
  def add(a:Int,b:Int):Unit={
    println(a+b)
    
  }
  
  val a=20
  
  private val x=20  // can be accssable using prent object only 
  
  protected val y=30 //can be accessable using parent object and in child class directly
  
  private def mul(a:Int,b:Int):Unit={
    println(a*b)
  }
  
  protected def div(a:Int,b:Int):Unit={
    println("div+"+" "+" "+a/b.toFloat)
  }
}

class child1 extends parent{
  override def add(a:Int,b:Int):Unit={
    println(a-b)
  } 
  
  override val a=30
  println("y"+" "+y)   
  
 div(30,40) 
}

class child2 extends child1{

div(40,30)
 println("y"+" "+y)   

}

//access level->public,private,protected

//abstraction->trait,abstract class  -> trait and abstract class variable /methods only accessed by child object 


//mutlilevel Inheritance -> class a  -> class b extends a  -> child c extends b 

//multiple inheritance ->can be achive by traits 
// when one class acessing more than one parent/super class  i.e. multiple inheritence 

//class parent1  class parent2 class parent3   
//class child1 extends parent1 with parent2 with parent3 
// this is not possible using inheritance 

//class parent1,trait parent2,trait parent3 

//class child1 extends parent1 with parent2 with parent3 
/*
class parent1{
  
  
}

trait parent2{
  
}

trait parent3{
  
  
}

class child123 extends parent1 with parent2 with parent3 {
  
}
*/

/**
 * 
 * 
 * Encapsulation is defined as the wrapping up of data under a single unit.
 * It is the mechanism that binds together code and the data it manipulates. 
 * Another way to think about encapsulation is, it is a protective shield 
 * that prevents the data from being accessed by the code outside this shield
 * 
 * 
 * //access level->public,private,protected
 * 
 * 
 */
 
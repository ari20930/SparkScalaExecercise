package com.scala.practice.secod

// We have a parent class there we can't declare a method declearation only  and we can't define method/function in child class 
// to achive it we have some concept call abstract class

object inheritenceex1 {
  def main(args:Array[String]):Unit={
  /* val gpobj = new grandparent
   println("grandparent variables1 "+ gpobj.gp1)
   println("grandparent variables2 "+ gpobj.gp2)
   gpobj.gpmethod() 
   
      val pobj = new parent
   println("parent variables1 "+ pobj.p1)
   println("parent variables2 "+ pobj.p2)
   pobj.parentmethod()
   
   val cobj = new child
      println("child variables1 "+ cobj.c1)
   println("child variables2 "+ cobj.c2)
   cobj.childmethod()*/
    
   val cobj1 = new child 
    /*this inherited property*/
    println("cobj1.gp1 "+cobj1.gp1)
    println("cobj1.gp2 "+cobj1.gp2)
    cobj1.gpmethod()
    
    println("cobj1.p1 "+cobj1.p1)
    println("cobj1.p2 "+cobj1.p2) 
    cobj1.parentmethod()
    
    /* this is it's own child method and variables this is nothing how we are accessing regular class methods and variables*/
    /*cobj1.c1
    cobj1.c2
    cobj1.childmethod()*/ 
    
    
    /* we are accessing inherited property of grand parent from it's child class name as parent*/
    val pobj1 = new parent
    println("pobj1.gp1 "+pobj1.gp1)
    println("pobj1.gp2 " +pobj1.gp2)
    pobj1.gpmethod()
    
    

   }
  
}

class grandparent{
val gp1=10
val gp2=20

/*function defination*/
def gpmethod()={
println("this is grandparent class")
}


//def gpmethod1() // function declearation this is not possible
}

class parent extends grandparent{
val p1=30
val p2=40
def parentmethod()={
println("this is parent class")
}
/*
 * def gpmethod1={
 * prinltn("gp method1")
 * }
 */
}


class child extends parent{
val c1=10
val c2=20
def childmethod()={
println("this is child class")
}

}
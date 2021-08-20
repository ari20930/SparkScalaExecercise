package com.scala.practice

object traitexample3 {
  def main(args:Array[String]):Unit={
    val obj = new child2123
    obj.printDummy1()
    obj.printDummy2()
    obj.printDummy3()
    obj.printDummy4()
    obj.printDummy5()
  }
}

trait trait1{
  def printDummy1():Unit={
    println("This is trait1")
  }
  
}

trait trait2{
   def printDummy2():Unit={
    println("This is trait2")
  }
  
}
trait trait3{
     def printDummy3():Unit={
    println("This is trait3")
  }
  
}
trait trait4{
     def printDummy4():Unit={
    println("This is trait4")
  }
  
}
trait trait5{
     def printDummy5():Unit={
    println("This is trait5")
  }
  
}

class child2123 extends trait1 with trait2 with trait3 with trait4 with trait5{
  println("this is child class")
}

package com.scala.practice

//regular class+auto generated method
/*
//case should be there before the class name
// new keyword is not mandatory while creating an object
//we can use auto-generated copy method to copy from one object to other
//we can equals method (==,.equals)

//pattern matching using case class
 * These all the above features are not possible in regular class
 */

//toString method is auto-generated
object caseclassex2 {
def main(args:Array[String]):Unit={
    //here while creating an object of this class new is not mandate
    
    val obj = car1("BMW","s02")
    obj.printDummy1()
    
    val obj1=obj.copy(name="Mercedes")  //Here auto-generated copy method
    obj1.printDummy1()
    
  // println(obj.equals(obj1))  // we can use equals method
    println(obj==obj1)
    
    println("The value of obj is:: " +" "+ obj)
    println("The value of obj1 is:: " +" "+ obj1)
    
    /*
     * Pattern Matching using case class
     */
    
    obj1 match{
      case car1(a,b) =>{
        if(a=="BMW")
          println(a)
        else
          println("it's not bmw car")
      }
    }
 
   
    
  

  }
}



case class car1(var name:String,model:String){
  val carName = name
  val carModel = model 
  
  def printDummy1():Unit={
    println(s"car name is $carName and car-model is $carModel")
    
  }
}
package com.scala.practice

//object can have main method or can't have method
// whatever object can't have main method that is called singleton object
//to run program you must have main method under a object that is mandatory
//but a porgam can/can't have 
//singleton object,class,trait etc.

//Note1: class can't have main method 
//Note2: singletoneObject i.e. objectnew1 /Object(main-method)i.e. main2 ->
//       If i want access singletoneobject/objectnew1 methods or variables 
//       from traits/class/from any-other object  -> we can access using 
//       objectname.methodname/variablesname 
//  e.g. printDummy1() method if want access from traitnew1,childnew1,objectnew2,main2 
//      need call using objectnew1.printDummy1()  inside traitnew1,childnew1,objectnew2,main2 
//      Same goes for variables 
//      objectnew1.z1 objectnew1.z2  inside traitnew1,childnew1,objectnew2,main2 
//
//Conclusion:Method/variables of an object can be accessed from anywhere using the 
//objectname.method/variablesname 

//Note3:If i want access a class method/variables from anywhere 
//      To access it
//      a. first we need to create an object this class using
//        val objectname = new classname 
//      b. to acess the method/variables from that class we need to give 
//         objectname.classmethods or classvariables 

//Note4:For trait -> if i want acess variables or method of it 
//      a.first we need to have child class which will extends trait 
//      b. then we can create object of this child class the way we can create for regular class 
//      c. then that childclassobjectname.trait_method_name /trait_variable_name

//Note5:If we have companionObject -> object name & class_name should name 
//a.If i want to access companionObject as per the example objectnew1 variables/methods
// i.e. printDummy()/printDummy1() z1 z2 -> want access from comapnionObjectClass 
// objectname.method/variablename here objectnew1.z1 objcenew1.z2 objectnew1.printDummy()
//
//b.If i want access companionObjectclass variables /method here its c1,c2,
//companionjectClassMethod() from companionobject i.e objectnew1 
// How can i access it??
//i.we need an object of companionObjectclass 
//  val object1 = new companionObjectclassname 
//  i.e. val obj1 = new objectnew1
//
//ii.obj1.mehtodname/varaiblesname 

//Note6:abstract class ->it's a class where can't instantiate i.e. 
//nothing but we can't create an obejct -> we can create child class out of it using extends keyword 





object main2 {
  def  main(args:Array[String]):Unit={
  val childobj = new childnew1
  


  println("++++++++++++++++++++++++++++++++++++++++++++")
  println("This is trait unimplemented method::add:: "+" "+childobj.add(20, 30))
  println("++++++++++++++++++++++++++++++++++++++++++++")

  println("++++++++++++++++++++++++++++++++++++++++++++")
  println("This is trait implemented method in child class::sub:: "+" "+childobj.sub(20, 30))
  println("++++++++++++++++++++++++++++++++++++++++++++")
  //to call class methods/variables or singletonobject methods/variables ->
  // we can call from inside main method or outside of main method
    
  
  //calling the singleton object method from main-method 

   
   println("++++++++++++++++++++++++++++++++++++++++++++")
   println(objectnew1.printDummy()+"---------calling from main-method")
   println("++++++++++++++++++++++++++++++++++++++++++++")
   
   
   //accessing singletoneObject variables from main method
   

   println("++++++++++++++++++++++++++++++++++++++++++++")
   println("The value of z1 from singletone object calling from main method:: "+" "+objectnew1.z1)
   println("++++++++++++++++++++++++++++++++++++++++++++")


   println("++++++++++++++++++++++++++++++++++++++++++++")
   println("The value of z2 from singletone object calling from main method:: "+" "+objectnew1.z2)
   println("++++++++++++++++++++++++++++++++++++++++++++")
  }
  
  val x=100
  val y=300
  
  //To invoke the method from dummyImplictMethodCallClass which is calling implicit class method
  val objnew1 = new dummyImplictMethodCallClass
  objnew1.dummyMethod()
  
  //To invoke the regexclass which we have created to find all the number from a text 
  //find a paritcular word occurance from a given text
  val objreg1= new regexexample
  objreg1.findAllNumbersInAString("this is my address:: 123 Bekar Street Road Number:3rd Chennai TamilNadu 5000012")
  
  objreg1.findParticularWordInAString("My name is arindam , i'm from westbengal, i am working in IT, this is  a sample program written by me", "is")
}

trait traitnew1{
def add(a:Int,b:Int):Int   //unimplemeted method

def sub(a:Int,b:Int):Int={  //implemented method 
a-b
}


println("++++++++++++++++++++++++++++++++++++++++++++")
//calling singletonobject method printDummy1 from trait
println(objectnew1.printDummy2()+" ------calling from trait")
println("++++++++++++++++++++++++++++++++++++++++++++")
}

class childnew1 extends traitnew1{
def add(a:Int,b:Int):Int={
a+b
}

 

println("++++++++++++++++++++++++++++++++++++++++++++")
//calling the singleton object method from child class
println(objectnew1.printDummy()+"---------calling from child class")
println("++++++++++++++++++++++++++++++++++++++++++++")

}
//this is an singleton object	   
object objectnew1{
val childobj1 = new child


println("++++++++++++++++++++++++++++++++++++++++++++")
println("we are calling unimplemented method of trait implemeneted in childclass calling from singletoneobject:: "+" "+childobj1.add(12,34))
   
println("++++++++++++++++++++++++++++++++++++++++++++")

println("we are calling implemented method of trait calling from singletoneobject:: "+" "+childobj1.sub(12,34))

println("++++++++++++++++++++++++++++++++++++++++++++")

def printDummy():String={
return ("This is first print statements from singleTonObject")
}

def printDummy2():String={
  return "This is second print statemetns from singleTonObject"
}

def printDummy3():String={
  return "This is third print statemetns from singleTonObject"
}

val z1=2
val z2=3

   

println("++++++++++++++++++++++++++++++++++++++++++++")
println("value of z1,z2 present in singleton object and printing from singletoneObject itself:: "+" "+z1,z2)
println("++++++++++++++++++++++++++++++++++++++++++++")
  
   
println("++++++++++++++++++++++++++++++++++++++++++++")
//i want to access main2 variables x,y  ->x,y should be there out-side the main method
println("this is from main2 object where main method is there value of X:: "+main2.x)
println("++++++++++++++++++++++++++++++++++++++++++++") 

println()
println("++++++++++++++++++++++++++++++++++++++++++++")
 
println("this is from main2 object where main method is there value of Y:: "+main2.y)
println("++++++++++++++++++++++++++++++++++++++++++++")

//accessing companionobjectclass variables and method from companionobject i.e. objectnew1
val comobj1 = new objectnew1
println("++++++++++++++++++++++++++++++++++++++++++++")
println("accessing companionobject class variables i.e comapnionVariables1 from  companionobject i.e objectnew1"+" "+comobj1.comapnionVariables1)
println("++++++++++++++++++++++++++++++++++++++++++++")
println("accessing companionobject class method  companionjectClassMethod from  companionobject i.e objectnew1"+" "+comobj1.companionjectClassMethod())
println("++++++++++++++++++++++++++++++++++++++++++++")


//invoking abstract class method using child of abstract class object 
val childabstractobj = new childabstract() //automatically call child auxilary constructor with no parameter 
childabstractobj.operationMatch(10,20, "add")
childabstractobj.operationMatch(10,20, "sub")
childabstractobj.operationMatch(10,20, "mul")
childabstractobj.operationMatch(10,21, "div")
childabstractobj.operationMatch(10,21, "mod")
//to call the child method
childabstractobj.addOfString()

val childabstractobj1 = new childabstract("Muthu") //automatically call child auxilary constructor with one parameter 
//to call the child method
childabstractobj1.addOfString()

val childabstractobj2 = new childabstract(s1="David",s2="BeckHam") //automatically call primary constructor 
childabstractobj2.addOfString()

}

object objectnew2{
  
  //under this if i want to access variables/method of main-method object/other singleton object i.e. objectnew1
println("++++++++++++++++++++++++++++++++++++++++++++")
println("objectnew1 variables z1 accessed from objectnew2"+" "+objectnew1.z1)
println("++++++++++++++++++++++++++++++++++++++++++++")
println("main2 variables x accessed from objectnew2"+" "+main2.x)


//to call the companionobjctclass method or variables from any where we need create an object out of it 
val comobj = new objectnew1

println("++++++++++++++++++++++++++++++++++++++++++++")
println("accessing companionobject class variables i.e comapnionVariables1 from  objectnew2"+" "+comobj.comapnionVariables1)
println("++++++++++++++++++++++++++++++++++++++++++++")
println("accessing companionobject class method  companionjectClassMethod from  objectnew2"+" "+comobj.companionjectClassMethod())
println("++++++++++++++++++++++++++++++++++++++++++++")
}

//companion object -> where class and object name will be same 
//companion object class ->same as objectname which is objectnew1
class objectnew1{
def companionjectClassMethod():String={
 return "This is the method of companionobjectclass"
}

val comapnionVariables1=12312
val comapnionVariables2=12314

//accessing companion object i.e objectnew1 variables and method from companionobjectclass i.e objectnew1
println("++++++++++++++++++++++++++++++++++++++++++++")
println("accessing companionobject  variables i.e z1 from  companionobjectclass i.e objectnew1"+" "+objectnew1.z1)
println("++++++++++++++++++++++++++++++++++++++++++++")
println("accessing companionobject  method  printDummy() from  companionobject i.e objectnew1"+"::"+objectnew1.printDummy())
println("++++++++++++++++++++++++++++++++++++++++++++")
}

//accessing implicit class method from an object i.e. implictclassobject method 
//i.e. firstChar from an class name as dummyImplictMethodCallClass

// to access the implict class method we need to import the implict class object first
import com.scala.practice.implictclassobject._

class dummyImplictMethodCallClass{
  val a="Arindam"
  //acessing the implicit class method 
def dummyMethod()={
println("++++++++++++++++++++++++++++++++++++++++++++")  
println("By calling implicit class method"+"::"+a.firstChar())
println("++++++++++++++++++++++++++++++++++++++++++++")  
  }
  
}


//Finding all the number which is present in a  text and finding a particular word
// is present or not in a particular text 


import scala.util.matching.Regex
class regexexample{
  def findAllNumbersInAString(s:String):Unit={
    val regobj1 = ("\\d+").r 
println("++++++++++++++++++++++++++++++++++++++++++++") 
println("finding all number from a text i.e."+"::"+s+"numbers are::"+((regobj1 findAllIn s).mkString(",")))
println("++++++++++++++++++++++++++++++++++++++++++++")
  }
  
  def findParticularWordInAString(s1:String,word:String):Unit={
        val regobj2 = (word).r 
println("++++++++++++++++++++++++++++++++++++++++++++") 
println("finding all number from a text i.e."+"::"+s1+"Word is:: "+word+"::"+"word occurance happens are::"+((regobj2 findAllIn s1).mkString(",")))
println("++++++++++++++++++++++++++++++++++++++++++++")
  }  
}


//using absrtact class 
abstract class abstract12{

  def operationMatch(a:Int,b:Int,operation:String):Unit= operation match{
    case "add" => {
      println("++++++++++++++++++++++++++++++++++++++++++++") 
      println("abstract class method operationMatch->Using patternmatching if add:: "+" "+(a+b))
      println("++++++++++++++++++++++++++++++++++++++++++++")
    }
    case "sub" => {
      println("++++++++++++++++++++++++++++++++++++++++++++") 
      println("abstract class method operationMatch->Using patternmatching if sub:: "+" "+(a-b))
      println("++++++++++++++++++++++++++++++++++++++++++++")
    }
    case "div" => {
      println("++++++++++++++++++++++++++++++++++++++++++++") 
      println("abstract class method operationMatch->Using patternmatching if div:: "+" "+(a.toFloat/b.toFloat))
      println("++++++++++++++++++++++++++++++++++++++++++++")
    }
    case "mul" => {
      println("++++++++++++++++++++++++++++++++++++++++++++") 
      println("abstract class method operationMatch->Using patternmatching if mul:: "+" "+(a*b))
      println("++++++++++++++++++++++++++++++++++++++++++++")
    }
    case _     => {
      println("++++++++++++++++++++++++++++++++++++++++++++") 
      println("abstract class method operationMatch->Using patternmatching if default:: "+" "+("It's not add/mul/sub/div"))
      println("++++++++++++++++++++++++++++++++++++++++++++")
    }
      
     
  }

}

//to access abstract class method or variables we need to create child class out of it 
//with primary constructor and auxilary constructor

class childabstract(s1:String,s2:String) extends abstract12{
  println("++++++++++++++++++++++++++++++++++++++++++++") 
  println("This is an child class of abstract class")
  println("++++++++++++++++++++++++++++++++++++++++++++") 
  
  def addOfString():Unit={
    println("++++++++++++++++++++++++++++++++++++++++++++") 
    println("To print of Two String from childabstract class:: "+" "+(s1+s2))
    println("++++++++++++++++++++++++++++++++++++++++++++") 
  }
  //auxilary constructor with no parameter
  def this(){
    this("arindam","ghosh")
  }
  //auxilary constructor with one parameter
  def this(a:String){
    this(a,"Krishna")
  }

}

//defining a case class

//case class caseclassdemo(a:Int,b:Int,c:Int)




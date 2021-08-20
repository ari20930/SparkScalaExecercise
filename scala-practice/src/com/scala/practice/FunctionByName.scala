package com.scala.practice
import java.util.Date
object FunctionByName {
  def main(args:Array[String]):Unit={
    //name(concatName(name,"Arindam","Ghosh"))
    
    println("main function:: "+exec(time()))
    
    
  }
  
  //val name=(n:String)=>println("combination of firstName and lastName is:: "+" "+n)
  //val concatName=(name:(String)=>Unit,fname:String,lname:String)=>fname+lname
  
def time():Long={
  println("Inside the time function")
  return System.nanoTime()
}

def exec(t: => Long):Long={
  //time() =>Long
  println("Inside the exec function")
  println("the time is::"+" "+t)
  println("exiting from  exec function")
 return t
}
}


//Inside the exec function
//Inside the time function
//the time is:: 113562296474311
//exiting from  exec function
//Inside the time function
//main function:: 113562296844130
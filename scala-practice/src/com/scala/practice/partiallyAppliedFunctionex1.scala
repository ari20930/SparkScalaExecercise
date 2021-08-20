package com.scala.practice

import java.util.Date
object partiallyAppliedFunctionex1 {
  def main(args:Array[String]):Unit={
    val date = new Date
    
   /* log(date,"Sucess")
    
    Thread.sleep(2000)
    
    log(date,"Faliure")
    
     Thread.sleep(2000)
    
    log(date,"Sucess")*/
    
    val subFunction=log(date,_:String,_:String)  //lamdaFunction which is calling one more function with 
                                        //one static parameter and Dynamic parameter 
    
    subFunction("Sucess"," Job ran fine") 
     Thread.sleep(2000)
     
    subFunction("Faliure"," Job Failed") 
    Thread.sleep(2000)
    
    subFunction("Sucess"," Job ran fine") 
     

    
  }
  
  def log(date:Date,msg:String,msg1:String):Unit={
    
    println(msg+date+msg1)
  }
  
  
}
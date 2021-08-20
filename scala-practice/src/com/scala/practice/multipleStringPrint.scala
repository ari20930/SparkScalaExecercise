package com.scala.practice

object multipleStringPrint {
  def main(args:Array[String]):Unit={
    multipleTimes(4,str="Muthu","Krishna")
    multipleTimesInt(4,4,5,6,7)
    
  }
  
  def multipleTimes(n:Int,str:String*):Unit={
    for(i<-str){
      println(i*n)
      
    }
    
  }
  
    def multipleTimesInt(n:Int,number:Int*):Unit={
    for(i<-number){
      println(i.toString()*n)
      
    }
    
  }
  
  
}


//3,str="Arindam","Ghosh"
//Arindam*3 -> Arindam Arindam Arindam 
//Ghosh*3 ->Ghosh Ghosh Ghosh
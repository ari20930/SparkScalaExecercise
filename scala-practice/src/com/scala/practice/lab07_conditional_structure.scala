package com.scala.practice

object lab07_conditional_structure {
  
  def main(args:Array[String]):Unit={
    
   val x:Any = 2.45
   findDataType(x)
 
  }
      def findDataType(x: Any) = x match {
         case x : String => println("String identified")
         case x : Int => println("Integer identified")
         case x : Float => println("Float identified")
         case x : Double => println("Double identified")
         case _ => println("DataType not identified")
       }
  
}

/*
   x match{
     case _:Int => println("Integer")
     case _:Double => println("double")
     case _:String => println("string")
     case _:Float  => println("float")
     case _:Char   => println("charecter")
     case default  => println("others")
     
   }
    
 */

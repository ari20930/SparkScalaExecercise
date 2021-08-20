package com.scala.practice.secod


// requirement user will pass the opreation name and also two value  
//depends on the operation -> it will calculate

//add,1,2  => 3 
//mul,3,4 => 12
//div,2,3  =>1.6666

//creating an object/class/trait -> camel upper case -> ClassName,ObjectName
//creating mehtod/function/variable  -> methodName,variableName,functionName
object method3 {
  def main(abc:Array[String]):Unit={
    
    val resultOfAdd= calculator("add",1,2)  //3
   println("result of addition::"+" "+resultOfAdd)  //3
     val resultOfSub= calculator("sub",1,2)  //-1
   println("result of subtraction::"+" "+resultOfSub)//-1
     val resultOfMul= calculator("mul",4,2) //8
   println("result of multiplication::"+" "+resultOfMul)//8
     val resultOfDiv= calculator("div",2,3)//0
   println("result of division::"+" "+resultOfDiv) //0
    val resultOfOther= calculator("other",2,3) //Invalid Operation
    
    println("result of other::"+" "+resultOfOther)//Invalid Operation

  }
  
               //   add           1     2  
              //    sub           1     2
              //    mul           4     2
  def calculator(operation:String,a:Int,b:Int):Any={
    if(operation =="add")
      return (a+b)  
    else if(operation == "sub")
      return (a-b)  
    else if(operation=="mul") 
      return (a*b)
    else if(operation == "div")
      return a.toFloat/b.toFloat
    else 
      return "Invalid operation" 
      
      //AnyVal
      // Int  -> return type add
      // Int  -> return type sub
      // Int   ->return type mul 
      // Int   ->return type div
      //AnyRef  
      //String  ->return type of else
  }
}


//Int/Int =>Int
//Int(0.6666)=0


//if can work without else 
// if(conditon)
//{
//...
//}


//Any ->AnyVal,AnyRef 
//AnyVal ->Int,Float,Double,Char,Short,Byte,Unit,Long etc 

//AnyRef ->String,Object,Collection->List,Map,Set,Array,Seq etc 



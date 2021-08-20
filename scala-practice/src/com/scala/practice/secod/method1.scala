package com.scala.practice.secod

//def -> to create method/functio you need to use def 
//main -> function name as main 
//args ->argument which will pass from console ->run time
//Array[String] -> what type of argument it is passed from console 
//Array("args1","args2")
//Unit -> it's void return type that means it will not return anything 

            
//val a=Array(1,2)  a(0) = 1  a(1)=2

//args:Array[String] =Array("1","2")

object method1 {
 def main(args:Array[String]):Unit={
   
   if(args.length <5 )
   {
     println("Missing parameter")
   }   
   
  //val args:Array[String]=Arraay("1","2","3","4","5")
   val a1= args(0).toInt
    println("First Paraemeter from console"+" "+a1)
   
   
   val a2= args(1).toInt
   println("Second Paraemeter from console"+" "+a2)
   
   
   val a3= args(2).toInt
   println("third Paraemeter from console"+" "+a3)
   
   val a4= args(3).toInt
   println("fourth Paraemeter from console"+" "+a4)
   
   val a5= args(4).toInt
   println("fifth Paraemeter from console"+" "+a5)
   
   
  // addition(a1,a2)  //calling the method
   
   
 } 
 
 def addition(a:Int,b:Int):Unit={
   println("the addition is::"+" "+(a+b))
   
 }
}

//to call this function from main-method 
// val result=adbc(2,3)  //2 
//println("this is result")
//println(result) 


//val result1 =adbc1(3,4)  //12 
//println(result1)

//println(adbc1(3,4))

// def ->keyword
// abdc -> function name 
// a:Int -> 1st argument/parameter -> datatype is Int 
//b:Int -> 2nd argument/parameter ->datatype is Int 
//:Int -> Retrun datatype

// def abdc(a:Int,b:Int):Int={
// val e =a //2
// val f=b  //3
// e+f
//e-f 
//e*f 
//e/f
//e%f  //2
//}

//def abdc1(a:Int,b:Int):Int={
// val e =a   //3
// val f =b   //4
// return e*f  //12
// e/f
//retrun e*10
// e*123
//}

//def abdc2(a:Int,b:Int):Unit={
// val e =a   
// val f =b  
// val result =e+f
// not possible a+b   // it will throw me an error by stating that "Unit can't return a value please change return datatype or return type"
// println("addition: "+" "+result)
//}


// val result1 =adbc3(4,5)

//def adbc3(a:Int,b:Int)={
//val e =a
//val f =b
//e*f
//}

// val result1 =adbc4(4,5)/ this will not work/
// adbc4(4,5)  -> just call the function
//def adbc4(a:Int,b:Int)={  //return type is Unit
//val e =a
//val f =b
//println(e*f)  //20
//}


//val result2= adbc5(30,20) //50
//def adbc5(a:Int,b:Int)={ //retrun type or return data type is Int 
//val e =a
//val f =b
//println(e*f)  //600
//e-f
//e+f
//}





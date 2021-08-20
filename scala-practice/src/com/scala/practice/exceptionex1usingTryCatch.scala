package com.scala.practice

//In try-catch
//try{varibles/method/whatever the operation you want to perform}
//catch{}
//1.I know already know what is exception
//catch{
//case a:ExecptionClassName/Name=>{printstatements you want give,a}}
//}
//2. If i don't know the exception name 
//catch{
//case otherException:Throwable=>{printstaments  you want ,otherException}}
object exceptionex1usingTryCatch {
def main(args:Array[String]):Unit={

try{
val array=Array(1,2,3,4,5,6)
println(array(9))

println("pelase enter the first numeber which you want to divide")
val a=scala.io.StdIn.readInt()
println("pelase enter the second numeber which you want to divide by")
val b=scala.io.StdIn.readInt()
println(div(a,b))


}
catch{
  case a:NumberFormatException=>{
    println("This is an NumberFormatException that comes only if we don't provide proper value of the number")
  }
  case b:ArrayIndexOutOfBoundsException=>{
    println("This is cause beacuse someone is try access array index elements which is not defined")
  }
  case otherException:Throwable =>{
    println("This is others exception"+"Name Of the Exception which we didn't know:: "+" "+otherException)
    
  }
}
}
def div(a:Int,b:Int)={
a.toFloat/b.toFloat
}
}


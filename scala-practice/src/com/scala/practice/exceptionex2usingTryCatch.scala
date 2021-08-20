package com.scala.practice
import java.io.FileReader
import java.io.IOException
//import java.io.FileNotFoundException

object exceptionex2usingTryCatch {
  def main(args:Array[String]):Unit={
    //If i want to read file any location
    try{
    val f = new FileReader("file1.text")
    }
    catch{
      //case a:FileNotFoundException=>println("File is not present"+" "+a)
      case otherException:Throwable=>println("File is not present"+" "+otherException)
    }
    
  }
}
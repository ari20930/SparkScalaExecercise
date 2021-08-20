package com.scala.practice
//27.Write a program to create string list to store the values of Spark,Scala,Python,Java,Hadoop and 
//count the number of elements in the List

//28.Write a program to store (China,Beijing),(India,New Delhi),(USA,Washington),(UK,London) 
//using Map 

//29.Take only countries and store in an array and use foreach and println to print line by line of 
//element

//30.Take only countries and store in an set and use foreach and println to print line by line of 
//elements

//31. Take only countries and store in an set and use foreach and println to print line by line of 
//elements.

//32. Create a case class and apply the respective column name and 
//datatype for the tuple created in 
//step 22
// Create a tuple of 4 fields and access the 2nd and 4th fields and store in another tuple.

case class storeTupleResult(firstElement:Any,secondElement:Any,thirdElement:Any,fourthElement:Any,fifthElement:Any)
object excercise27 {
  def main(args:Array[String]):Unit={
    val listOfString=List("Spark","Scala","Python","Java","Hadoop")
    
    println("No. of elements  in list is:: "+listOfString.length)
    
    val mapex=Map("China"->"Beijing","India"->"New Delhi","USA"->"Washington","UK"->"London")
  
    println("captial of India is:: "+mapex("India"))
    
    val arrayOfCountry:Array[String]=mapex.keys.toArray
    println("printing country line by line using foreach using Array")
    arrayOfCountry.foreach(println)
    
    val setOfCountry=mapex.keys
    println("printing country line by line using foreach using set")
    setOfCountry.foreach(println)
    
    val tupleEx=("Arindam",25.0,"Muthu",27,"David","Irfan")
    //val obj = new storeTupleResult(tupleEx._1,tupleEx._2,tupleEx._3,tupleEx._4,tupleEx._5)
    //val resultTupleFromCaseClass=(obj.firstElement,obj.fourthElement)
      // println("resultOftuple")
    //resultTupleFromCaseClass.productIterator.foreach(println)
    
    
    
    
    
    
    
  }
}
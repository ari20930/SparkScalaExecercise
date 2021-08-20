package com.scala.practice
//Create student class and define 3 subject marks 
//and write a method to get the student totalmarks and the result
object excercise2 {
  def main(args:Array[String]):Unit={
    println("enter the subject one1 marks::")
    val sub1=scala.io.StdIn.readInt()
    println("enter the subject one2 marks::")
    val sub2=scala.io.StdIn.readInt()
    println("enter the subject one2 marks::")
    val sub3=scala.io.StdIn.readInt()
    
    val obj=new Student
    obj.totalMarks(sub1, sub2, sub3)
    
    
  }
}

class Student{
  var total=0
  def totalMarks(subj1_marks:Int,subj2_marks:Int,subj3_marks:Int):Unit={
    total=subj1_marks+subj2_marks+subj3_marks
    
    println("subject1 mark is:: "+subj1_marks+"\n"+"subject2 mark is:: "+subj2_marks+"\n"+"subject3 mark is:: "+subj3_marks+"\n"+"toatal marks:: "+total)
  }
  
  
}
package com.scala.practice

object constructor2 {
  def main(args:Array[String]):Unit={
    val obj = new name_p()
    val obj1 = new name_p("Sunil")
    val obj2 = new name_p("Muthu","Krishna")
    val obj3 = new name_p("Muthu","Krishna")    

    
  //  println(obj.concat_name("M"))  //Rahul M Dravid
  }
  
}

class name_p(var fname:String,val lname:String){
  val name1=fname
  val name2=lname
  
  println(s"the first-name is $name1,the last name is $name2, firstname in constructor argument $fname")
  
  def concat_name(mid_name:String):String={
    return (name1+mid_name+name2)
  }
  
  //this is auxilary constructor with out any parameter
  def this(){
    this("Rahul","Dravid")
  }
  
  //this is an auxilary constructor with single parameter
  def this(a:String){
    this(a,"Gavaskar")
  }
  

}


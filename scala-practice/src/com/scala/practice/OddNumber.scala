package com.scala.practice

object OddNumber {
  
  def main(args:Array[String]):Unit={
    val list1=List(1,2,3,4,5,6,7,8,9,12)
/*
 * In foreach if you want to use some conditonal statements /call a function 
 * You can do it with the below way
 */
   list1.foreach(num=>{
     if(oddNumber(num)) 
       println("The oddNumber is::"+ " "+num)
     else   
       println("The EvenNumber is::"+ " "+num)
   })

/*
 *  Using filter   
 */

   println("This is the function with filter")
   val oddNumber1 =list1.filter(a=>a%2!=0)
   
   oddNumber1.foreach(println)
   
  
   
   println("This is the function with filter for evenNumber")
   val evenNumber1 =list1.filter(a=>a%2==0)
   evenNumber1.foreach(println)
   
  }
  val oddNumber=(x:Int)=>x%2!=0 
  
  
 
}






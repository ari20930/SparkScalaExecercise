package com.scala.practice.secod

object armstronNumber {
  def main(args:Array[String]):Unit={
    val number =153
    
    var n=number
    var remainder=0
    var total=0
 
    
    while(n>0)
    {
      remainder=n%10  //3 5 1
      total=total+(remainder*remainder*remainder) //0+(3*3*3)=27  27+(5*5*5)=152 152+(1*1*1)=153
      n=n/10 //15 1 0
     
      
    }
    
     println("total is:: "+total)
     if(total==number)
     {
       println("this is armstrong number:: "+number)
       
     }
     else
     {
        println("this is not armstrong number:: "+number)
     }
       
    
  }
}


//163 =3 
//1664=4 ^4
//16665=5 ^5
// var numstring=number.toString
//val numberlength=numstring.length
// if(numberlength =1)
// total=total+pow(remainder,numberlength)










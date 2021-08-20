package com.inceptez.datasecurity
//Create a scala object namely singleobject, create a main method, create objects like 
//val objmask=new com.inceptez.datasecurity.mask;
//val objencode=new com.inceptez.datasecurity.endecode;

//Create an array with 3 names like Array(“arun”,”ram kumar”,”yoga murthy”), 
//loop the array 
//elements, apply hashMask(name) for all 3 elements and println of the masked values.


//Loop the array created in above step and apply the revEncode(name) for all 3 elements 
//and 
//println of the encoded values

object singleobject {
  def main(args:Array[String]):Unit={
    val objmask = new com.inceptez.datasecurity.Mask
    val objencode = new com.inceptez.datasecurity.Endecode
    
    val arrayOfName= Array("arun","ram kumar","yoga murthy")
    
    for(i<-arrayOfName)
    {
      println("the original Name is::"+" "+i+" "+"masked name is::"+" "+objmask.hashMask(i))
    }
    
    
  arrayOfName.foreach(i=>
  println("the original Name is::"+" "+i+" "+"encoded name is::"+" "+objencode.revEncode(i)))
  
  println("decode of orignal Name")
  
   arrayOfName.foreach(i=>
     {
       println(" encoded name is::"+" "+objencode.revEncode(i)+" "+"decoded name is::" +objencode.revDecode(objencode.revEncode(i)))
     })
 
  }
}
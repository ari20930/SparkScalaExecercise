package com.inceptez.datasecurity
//Inside the class mask create a private val as addhash=100 and a method 
//hashMask(str:String):Int={return the hashcode of str+addhash value}

//. Inside the class mask create a private val as prefixstr=”aix” and a method 
//revEncode(str:String):String={return the prefixstr+reverse of str value}

class Mask {
  private val addhash=100 
  
  def hashMask(str:String):Int={
    str.hashCode()+addhash
  }
 
}
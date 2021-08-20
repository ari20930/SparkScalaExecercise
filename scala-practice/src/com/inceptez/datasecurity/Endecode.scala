package com.inceptez.datasecurity

class Endecode {
  private val prefixstr="aix"  
  
   def revEncode(str:String):String={
    prefixstr+str.reverse
  }
  
  def  revDecode(str:String):String={
   str.substring(3).reverse
  }
}
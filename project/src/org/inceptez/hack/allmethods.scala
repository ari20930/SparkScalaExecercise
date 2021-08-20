package org.inceptez.hack

class allmethods extends java.io.Serializable{
   def remspecialchar(NetworkName:String):String={
     val str = NetworkName.replaceAll("[^a-zA-Z0-9]", " ")
     return str 
     
  }
}
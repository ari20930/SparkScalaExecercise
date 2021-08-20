package com.scala.practice

object traitclassexample2 {
    def main(args:Array[String]):Unit={
   val childobj = new MERCEDES
   childobj.breaks()
   childobj.wheels()
   childobj.engine()
   childobj.musicSystem()
   println(childobj.xyz)
   println(childobj.yzw)
   
   println(childobj.tyres())
   childobj.gearBox()
  }
  
}






trait car113{
  def engine():Unit={  //implemented method
   println("This is 500 cc car")
  }
  def wheels()  //unimplemented method
  def breaks() //unimplemented method
  
  def musicSystem():Unit={
    println("Dolby")
  }
  val xyz=1234
  val yzw=546
}

trait truck{
  def tyres():String //unimplemented method
  
  def gearBox():Unit={  //Implemented method
    println("Having a gearBox")
  }
}

class MERCEDES extends car113 with truck{
  def wheels():Unit={  //implemented method 
    println("4 wheels")
  }
  
  def breaks():Unit={  //implemented method
    println("2 breaks")
  }
  
  def tyres():String={
    ("tyres are from MRF company")
  }
}



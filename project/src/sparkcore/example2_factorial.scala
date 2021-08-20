package sparkcore
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object example2 {
  def main(args:Array[String])={
    
    //Factorial
    val sc = new SparkContext(new SparkConf().setAppName("Example2").setMaster("local"))
    val lst = List(4,2,1)
    
    val rdd = sc.parallelize(lst)
    
    val factrdd = rdd.map(x=>
      {
        var factorial = 1
        for (i <-2 to x)
          factorial = factorial*i 
        factorial
      })
   factrdd.foreach(println) 
   
   
   /*
    * using method
    */
   
   val frdd = rdd.map(fact)
   frdd.foreach(println)
    
  
  }
   def fact(a:Int):Int={
      var fact1 = 1
      for(i <- 2 to a)
        fact1 = fact1*i
      fact1  
    }
}
package sparkcore

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
object example1 {
  def main(args:Array[String])={
    println("Welcome to Spark...")
    
    /*
     * Step-1: 
     * Create sc object from SparkContext class
     * SparkContext take two parameters
     *   1. Application Name
     *   2. Master
     *   We can create conf object from sparkconf class and 
     *   set the 2 parameters(appname,master) and pass into SparkContext
     *   
     * Step-2:
     * Create RDD  by using SparkContext Object
     *  
     */
    
    val sc = new SparkContext(new SparkConf().setAppName("First-Spark").setMaster("local"))
    
    val lst = List(10,20,30)
     
    val rdd = sc.parallelize(lst)
    println("Total",rdd.sum())
  }
}
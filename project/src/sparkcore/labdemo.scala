package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
object labdemo {
  def main(args:Array[String])={
    val sc = new SparkContext(new SparkConf().setAppName("labdemo").setMaster("local"))
     sc.setLogLevel("ERROR")
   /*
    * single file data load from local 
    */
    val rdd =sc.textFile("file:/home/hduser/spark_demo1/file1.text")
    
    rdd.foreach(println)
    
   /*
    * multiple file data load from local 
    */
    val rdd1 =sc.textFile("file:/home/hduser/spark_demo1/file1.text,file:/home/hduser/file2.text")
    
   // rdd.foreach(println)
    
  //  rdd1.foreach(println)
    
     
   /*
    * multiple file data load from local and hdfs
    */
    val rdd2 =sc.textFile("file:/home/hduser/spark_demo1/file1.text,file:/home/hduser/file2.text,hdfs://localhost:54310/user/hduser/tstfile.txt")
  //  rdd2.foreach(println)
    
    
   /*
    * load data from a local file folder
    */
    
    val rdd3 =sc.textFile("file:/home/hduser/spark_demo1/*") 
    
  //  rdd3.foreach(println)
    
     /*
    * load data from a local file folder for a specific type
    */
    
    val rdd4 =sc.textFile("file:/home/hduser/spark_demo1/*.text") 
    
  //  rdd4.foreach(println)
    
    /*
     * wholeTextFile()  ->(filepath,corresponding-value)
     */
    
    val rdd5 = sc.wholeTextFiles("file:/home/hduser/spark_demo1/file1.text")
    rdd5.foreach(println)
  }
  
 
}
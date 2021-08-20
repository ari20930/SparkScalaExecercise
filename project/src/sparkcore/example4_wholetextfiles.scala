package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
object example4_holdtextfiles {
  def main(args:Array[String])={
    val sc = new SparkContext(new  SparkConf().setAppName("Example4").setMaster("local"))
    sc.setLogLevel("ERROR")
    
    /*
     * wholeTextFies() -> Return type of this transformation  -> Tuple() -> RDD[String,String]
     * -> (1st parameter contains:: filename with file path,2nd parameter contains:: whatever details/data file contains)
     */
    
    println("-------------get all the file names & content  from local ------------------")
    val rdd = sc.wholeTextFiles("file:/home/hduser/hdfstolocal")
    rdd.foreach(println)
    
    /*
     * get all the file names
     */
    
    println("-------------get all the file names from local ------------------")
    val rdd1 = rdd.map(x=> x._1)
    
    rdd1.foreach(println)
    
    /*
     * file from hdfs && local and get the file names
     */
    println("-------------get all the file names from local and hdfs------------------")
    val rdd3 = sc.wholeTextFiles("file:/home/hduser/hdfstolocal,hdfs://localhost:54310/user/hduser/hadoop")
    val rdd4 = rdd3.map(x=>x._1)
    rdd4.foreach(println)
    
    println("-------------get all the file contains from local and hdfs------------------")
    
    val rdd5 = rdd3.map(x=>x._2)
    rdd5.foreach(println)
    
    
    /*
     * Reformating the two files 
     * If  the file1 contains wrong format, second file is having correct format how can we achive it
     */
    
    println("-----------------------------reformating--------------------------")
   /*
    val cust = sc.wholeTextFiles("file:/home/hduser/customer1.text,file:/home/hduser/customer2.text")
    
    val cust1 = cust.map(x=> 
      {
        if (x._1 == "customer1.text")
         x._2.split(",")
       /* else
          x._2
          * 
          */
      })   
      
    cust1.foreach(println)
    */
    
  }
}
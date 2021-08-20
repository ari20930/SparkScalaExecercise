package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
/*
 * 9.Data for task
 *You have given the follwing data in a file coursefee.txt
 *CourseName,Price,TaxandOthersInPercen
 *Hadoop,3000,10
 *Spark,3500,14
 *AWS,2700,13
 *Azure,2800,11
 *Java,3000,16
 *HBase,3200,20
 * 
 * Accomplish the below Task
 * 1. Load this csv file in RDD
 * 2. Now calculate the final price using tax and add as 2 column
 * 3. Save the final data in HDFS in location "/sparkworkouts/coursefeewithtax" with one file
 * 
 * o/p:- Hadoop,3300,3000,10
 */
object example10_task09{
  def main(args:Array[String])={
   val sc = new SparkContext(new SparkConf().setAppName("example6").setMaster("local"))
   sc.setLogLevel("ERROR")
   val rdd = sc.textFile("file:/home/hduser/sparkFileExcercise1/coursefee.txt",2)
   
   val header = rdd.first()

   val actualdata = rdd.filter(x=> x != header)
   
   //val calrdd1 = actualdata.map(x=>x.split(",")).map(x=> (x(0),{x(1).toFloat + (x(1).toFloat*x(2).toFloat)/100.0f}.round,x(1),x(2)))
    //calrdd1.foreach(println)
    
   //to remove the braces () in o/p
   /*
    * 1st: don't use tuple instead of that use List
    * 2nd: use map(x=>x.mkString(","))
    */
   val calrdd = actualdata.map(x=>x.split(",")).map(x=> (List(x(0),{x(1).toFloat + (x(1).toFloat*x(2).toFloat)/100.0f}.round,x(1),x(2))))
    
    val outputrdd = calrdd.map(x=>x.mkString(","))
    outputrdd.foreach(println)
    
   //To decrease the number of partition used  coalesec() 
    /* we can increase /decrease -> repartition  -> we can use
     * For repartition -> shuffle will  be happen -> internaly it will use  coalesec()
     * Coalesec() => we can avoid shuffle
     */
     outputrdd.coalesce(1).saveAsTextFile("file:/home/hduser//sparkworkouts/coursefeewithtax")
   // outputrdd.saveAsTextFile("file:/home/hduser//sparkworkouts/coursefeewithtax")
    println("data stored in file")
   
   
   /*
    * adding header
    */
   
    val finalheader = "coursename,totalcoursefees,coursefees,taxamt"
    val rddheader = sc.parallelize(Seq(finalheader))
    
    val unionheader =rddheader.union(outputrdd)
    
    println("==============header added===================")
    unionheader.foreach(println)
  
   
    
  }
}
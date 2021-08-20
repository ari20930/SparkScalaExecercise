package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
/*
 * given a file name sample.csv
 * 
 * id,topics,hits
 * Rahul,Scala,40
 * Nikitha,Spark,80
 * Mithun,Spark,1
 * Myself,Scala,20
 * 
 * 
 * Accomplish the below Task
 * 
 * 1.write a spark code in scala which will remove the header part and create RDD values as of below for all rows
 * and also if id is 'Myself' then filter out the row
 */
object example10_task05 {
  def main(args:Array[String]){
    val sc = new SparkContext(new SparkConf().setAppName("example5.4").setMaster("local"))
    sc.setLogLevel("ERROR")
    val rdd = sc.textFile("file:/home/hduser/sparkFileExcercise1/sample.csv")
    val header = rdd.first() //it's an action , it will return only the first rows
    
    //it will give all the values except header
    val filterrdd = rdd.filter(x=> x!=header) 
    
    filterrdd.foreach(println)
    
    //It will return what are the rows contains Myself  
    val filterrdd1 = filterrdd.filter(x=> x.contains("Myself"))  
    filterrdd1.foreach(println)
    
    //It will return all the rows which does not contains Myself
    val filterrdd2 = filterrdd.filter(x=> !x.contains("Myself")) 
    filterrdd2.foreach(println)
    
    
        
    
  }
}
package sparksql
import org.apache.spark.sql.SparkSession

object rdd_to_df {
  def main(args:Array[String])={
    
    /*
     * To create spark-session
     */
    val spark = SparkSession.builder().appName("rdd_to_df").master("local").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("ERROR")
    val rdd = sc.textFile("file:/home/hduser/hive/data/custs")
    
    val rdd1 =rdd.map(x=>x.split(",")).filter(x=>x.length==5).map(x=>(x(0),x(1),x(2),x(3),x(4)))
    
    
    //We have to import spark-sql
    
    import spark.implicits._
    val df = rdd1.toDF("empid","fname","lname","age","profession")
    df.show()
   
    
    
    
    
  }
}
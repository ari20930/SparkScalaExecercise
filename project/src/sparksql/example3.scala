package sparksql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row
import org.apache.spark.sql.types._ 


object example3 {
  def main(args:Array[String])={
    val spark = SparkSession.builder().appName("example3").master("local").getOrCreate()
    val sc = spark.sparkContext
        sc.setLogLevel("ERROR")
    
      val custschema =StructType(
        List(
            StructField("custID",IntegerType,true),
            StructField("Fname",StringType,true),
            StructField("Lname",StringType,true),
            StructField("Age",IntegerType,true),
            StructField("Profession",StringType,true)         
        ))
    /*
     * explicit Schema     
     */
    val df =spark
            .read
            .format("csv")
            .schema(custschema)
            .load("file:/home/hduser/hive/data/custs")
         //   .toDF()
    
    println("===================explicit schema========================")
    df.show(100,false)
    
    
    /*
     * implicit schema 
     */
    
    val df1 =spark.
             read.
             format("csv").
             option("inferSchema",true).
             load("file:/home/hduser/hive/data/custs1")
             .toDF("custID","Fname","Lname","age","Profession")
             
   println("===========================implicit Schema=========================")   
      df1.show(false)

  /*
   * Different Modes
   * There are 3 typical read mode and default read mode is permissive
   * a.Permissive -> All fields are set to null and corrupted records are placed in a string column called _corrupt_record
   * b.dropMalFormed -> Drops all the rows which containing corrupt records
   * c.failFast-> Fails when corrupt records are encountered.
   * 
   */
      
      
  println("====================corrupt records-dropMalFormed=====================================")   
  
  val df2 = spark.read.format("csv").option("mode","dropMalFormed").schema(custschema).
            load("file:/home/hduser/hive/data/custs1")
  df2.show(200,false)
  
  
  println("====================corrupt records-dropMalFormed=====================================")   
  
  val df3 = spark.read.format("csv").option("mode","permissive").schema(custschema).
            load("file:/home/hduser/hive/data/custs1")
  df3.show(200,false)
  
  println("==========================limit==========================================================")
  
  df3.limit(10).show()
  
  
   println("==========================to print existing df schema====================================")
   println(df.schema)
  
  
            
  }
}
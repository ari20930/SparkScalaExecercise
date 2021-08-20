package sparksql
import org.apache.spark.sql.SparkSession

object write_file_format {
  def main(args:Array[String])={
    val spark = SparkSession.builder().appName("file_format").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    
    val df =spark.read.format("csv").option("inferSchema",true).option("delimeter",",")
                 .load("file:/home/hduser/hive/data/custs").toDF("custId","fname","lname","age","prof")
                 
    df.createOrReplaceTempView("customer")
    
    val df1 = spark.sql("select * from customer where age > 55 and prof is not null")
    
    //mode->append,overwrite,ErrorIfExists,Ignore
    df1.write.mode("overwrite").option("header",true)
   // .option("delimeter","$")  -> it didn't work
    .format("csv")
    .save("file:/home/hduser/custdata1")
    
    println("=====save into csv file=======")
    
    
     
    //mode->append,overwrite,ErrorIfExists,Ignore
    df1.write.mode("append").option("header",true)
    .format("json")
    .save("file:/home/hduser/custdata1")
    
    println("=====save into json file=======")
    
    
    //mode->append,overwrite,ErrorIfExists,Ignore
    df1.write.mode("append").option("header",true)
    .format("parquet")
    .save("file:/home/hduser/custdata1")
    
    println("=====save into parquet file=======")
    
       //mode->append,overwrite,ErrorIfExists,Ignore
    df1.write.mode("append").option("header",true)
    .format("orc")
    .save("file:/home/hduser/custdata1")
    
    println("=====save into orc file=======")
    
    
  }
  
}
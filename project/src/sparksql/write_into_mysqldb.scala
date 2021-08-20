package sparksql

import org.apache.spark.sql.SparkSession

object write_into_mysqldb {
  def main(args:Array[String])={
    val spark = SparkSession.builder().appName("write_into_mysql").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    
    val df = spark.read.format("csv").option("inferSchema",true).option("delimeter", ",")
                  .load("file:/home/hduser/hive/data/custs")
                  .toDF("custId","fname","lname","age","profession")
                  
                  
   df.write.format("jdbc")
           .option("url","jdbc:mysql://localhost/custdb")
           .option("dbtable","customer1")
           .option("user","root")
           .option("password","Root123$")
           .option("driver","com.mysql.cj.jdbc.Driver")
           .mode("append")
           .save()
           
   println("record saved into table")        
           
           
    
  }
}
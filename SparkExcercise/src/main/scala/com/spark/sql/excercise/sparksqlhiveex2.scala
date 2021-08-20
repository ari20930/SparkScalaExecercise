package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession

/*
 * read the data from hive and stores the data into new hive table
 */

object sparksqlhiveex2 {
  def main(args:Array[String]):Unit={
   val spark = SparkSession.builder().appName("sparksqlhiveex3").master("local")
                           .config("hive.metastore.uris","thrift://localhost:9083")
                           .enableHiveSupport()
                           .getOrCreate()
                           
      spark.sparkContext.setLogLevel("ERROR")
      
   val devloperDF = spark.sql("""select * from custdb.developer""")
  
       devloperDF.write.mode("append").format("orc").saveAsTable("custdb.developer2")
       println("created new table name as developer2 and stores the data from developer in format orc")
                           
  }
}
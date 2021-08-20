package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession
/*
 * read data mysql and stores into new hive table
 */
object sparksqlhiveex3 {
  def main(args:Array[String]):Unit={
    val spark = SparkSession.builder().appName("sparksqlhiveex3").master("local")
                            .config("hive.metastore.uris","thrift://localhost:9083")
                            .enableHiveSupport()
                            .getOrCreate()
         spark.sparkContext.setLogLevel("ERROR")                    
     val customerDF= spark.read.format("jdbc")
                               .option("url","jdbc:mysql://localhost/custdb")
                               .option("user", "root")
                               .option("password", "Root123$")
                               .option("dbtable","customer")
                               .option("driver", "com.mysql.cj.jdbc.Driver")
                               .load()
    customerDF.write.mode("append").format("orc").saveAsTable("custdb.customer0815")
    println("data has been written from customer-mysql table to customer0815 hive table")
                               
  }
  
}
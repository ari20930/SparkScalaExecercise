package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession
/*
 * Read from existing hive table and write into existing hive table
 */
object sparksqlhiveex1 {
  def main(args:Array[String]):Unit={
   val spark = SparkSession.builder().appName("sparksqlhiveex1").master("local")
                           .config("hive.metastore.uris","thrift://localhost:9083")
                           .enableHiveSupport()
                           .getOrCreate()
       spark.sparkContext.setLogLevel("ERROR") 
       
       spark.sql("""show databases""").show()
       
       /* to read from hive table*/
       spark.sql("""select * from custdb.developer""").show()    
       
       /* to write the data into existing hive table*/
       spark.sql("""insert into custdb.developer1 select * from custdb.developer""")
       println("data has been written into hive table")
       
  }
}
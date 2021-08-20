package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
/*
 * 1st: read from customer table under custdb from mysql and write it into a new hive table\
 * 2nd: read the data from hive table and write into mysql
 */
object hiveDummy2 {
  def main(args:Array[String]):Unit={
   val spark = SparkSession.builder().appName("sparksqlhiveex1").master("local")
                           .config("hive.metastore.uris","thrift://localhost:9083")
                           .enableHiveSupport()
                           .getOrCreate()
                           
       spark.sparkContext.setLogLevel("ERROR")   
       
   val customerDF = spark.read.format("jdbc")
                              .option("url","jdbc:mysql://localhost/custdb")
                              .option("user","root")
                              .option("password","Root123$")
                              .option("dbtable","(select * from customer where city='chennai') as t")
                              .option("drive","com.mysql.cj.jdbc.Driver")
                              .load()
                              
    //  customerDF.write.mode("append").format("orc").saveAsTable("customer0989") 
    //  println("data has been stored and successfully created customer0987")
   
   val customer0989DF = spark.sql("""select * from customer0989""")
       customer0989DF.write.mode("append")
                           .format("jdbc")
                           .option("url","jdbc:mysql://localhost/custdb")
                           .option("user","root")
                           .option("password","Root123$")
                           .option("dbtable","customer0989DF")
                           .option("driver", "com.mysql.cj.jdbc.Driver")
                           .save()
       println("data has been stored and successfully created customer0989DF")                           
   
   
                              
                              
       
 }
}
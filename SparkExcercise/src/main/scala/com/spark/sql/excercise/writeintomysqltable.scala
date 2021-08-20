package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession
object writeintomysqltable {
  def main(args:Array[String]):Unit={
    val spark = SparkSession.builder().appName("writeintomysqltable").master("local").getOrCreate()
        spark.sparkContext.setLogLevel("ERROR")
        
    val customerDF = spark.read.format("jdbc")
                               .option("url","jdbc:mysql://localhost/custdb")
                               .option("user","root")
                               .option("password","Root123$")
                               .option("dbtable","customer")
                               .option("driver","com.mysql.cj.jdbc.Driver")
                               .load()
                  
                               
   customerDF.write.mode("append").format("jdbc")
                    .option("url","jdbc:mysql://localhost/custdb")
                    .option("user","root")
                    .option("password","Root123$")
                    .option("dbtable","customer0805")
                    .option("driver","com.mysql.cj.jdbc.Driver")
                    .save()
println("written into mysql-customer0805 table")                            
                               
  }
}
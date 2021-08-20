package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession
object sparkSQLex1 {
 def main(args:Array[String]):Unit={
   val spark = SparkSession.builder().appName("sparkSQLex1").master("local")
                                     .config("spark.sql.warehouse.dir","file:/tmp/warehouse")
                                     .enableHiveSupport()
                                     .getOrCreate()
 
   spark.sparkContext.setLogLevel("ERROR")
   spark.sql("show databases").show()
   
     spark.sql("create database if not exists retail")
     spark.sql("create external table retail.customer(id int,name string) row format delimited fields terminated by ',' location 'hdfs://localhost:54310/user/hduser/cust_ext/'")
     spark.sql("select * from retail.customer").show()
   
                                     
                                   
 } 
}
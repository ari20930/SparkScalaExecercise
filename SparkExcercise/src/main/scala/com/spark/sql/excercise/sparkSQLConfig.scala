package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession
import java.io.FileInputStream
import java.util.Properties
/*
 * config.properties
 * conurl=jdbc:mysql://localhost/custdb
 * username=root
 * password=Root123$
 * table=customer
 * driver=com.mysql.cj.jdbc.Driver
 * 
 */

object sparkSQLConfig {
  def main(args:Array[String]):Unit={
    val spark = SparkSession.builder().appName("sparkSQLConfig").master("local").getOrCreate()
        spark.sparkContext.setLogLevel("ERROR")
    val file = org.apache.spark.SparkFiles.get("config.properties")
    val confdata = new FileInputStream("file")
    val prop = new Properties()
        prop.load(confdata)
    val df1 = spark.read.format("jdbc")
                        .option("url", prop.getProperty("conurl"))
                        .option("user",prop.getProperty("username"))
                        .option("password", prop.getProperty("password"))
                        .option("dbtable", prop.getProperty("table"))
                        .option("driver",prop.getProperty("driver"))
                        .load()

  df1.show()    
    
  }
}
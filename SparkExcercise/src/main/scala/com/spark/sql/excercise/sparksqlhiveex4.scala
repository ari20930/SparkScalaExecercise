package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession

/*
 * hive using jdbc driver 
 */
object sparksqlhiveex4 {
  def main(args:Array[String]):Unit={
  val spark = SparkSession.builder().appName("sparlsqlhiveex4").master("local").getOrCreate()
      spark.sparkContext.setLogLevel("ERROR")
      
  /*val hivecustomerDF = spark.read.format("jdbc") 
                                 .option("url","jdbc:hive2://localhost:10000/default")
                                 .option("user","hduser")
                                 .option("password","hduser")
                                 .option("dbtable","tblpro1")
                                 .option("driver","org.apache.hive.jdbc.HiveDriver") 
                                 .load()*/
        val df1 = spark.read.format("jdbc")
    .option("url","jdbc:hive2://localhost:10000/default")
    .option("user","hduser")
    .option("password","hduser")
    .option("dbtable","tblpro1")
    .option("driver","org.apache.hive.jdbc.HiveDriver")
    .load() 
   //  hivecustomerDF.show()  
    df1.show()
                                 
  
  }
}
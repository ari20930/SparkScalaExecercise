package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
//1.Read the txns file from /home/hduser/hive/data/txns & load it to DF using explict Schema
/*create table txn(txnid int null,txndate string null,custid string null,amount float,null,
  category string null,product string null,city string null,state string null,paymenttype string null) 
*/
//2.show the data for state = 'Texas' or state = 'California'
//3.select distinct city, state from txn
//4.select distinct city as uscity, state as usstate from txn

object example1 {
  def main(args:Array[String]):Unit={
    val spark = SparkSession.builder().appName("example1").master("local").getOrCreate()
        spark.sparkContext.setLogLevel("ERROR")
    
        
        
    val transactionSchema =StructType(
                           List(
                               StructField("txnid",IntegerType,true),
                               StructField("txndate",StringType,true),
                               StructField("custid",StringType,true),
                               StructField("amount",FloatType,true),
                               StructField("category",StringType,true),
                               StructField("product",StringType,true),
                               StructField("city",StringType,true),
                               StructField("State",StringType,true),
                               StructField("paymenttype",StringType,true)
                           ) )   
     /*
     There are 3 typical read modes and the default read mode is permissive.
     
			permissive — All fields are set to null and corrupted records are placed in a string column called _corrupt_record
			dropMalformed — Drops all rows containing corrupt records.
			failFast — Fails when corrupt records are encountered.
     */                          
   val transactionDF = spark.read.format("csv")
                                 .schema(transactionSchema)
                                // .option("mode","permssive")
                                // .option("mode","dropMalformed") 
                                // .option("mode","failFast") 
                                 .load("/home/hduser/hive/data/txns")
         transactionDF.show(5)                        
   val texasCaliforniaDF = transactionDF.filter(col("state")==="Texas" || col("state")==="California")
      // texasCaliforniaDF.show(5,false)
       
   val distinctCity= transactionDF.select(col("city").alias("uscity")).distinct()
       //distinctCity.show(300)
   val distinctState = transactionDF.select(col("state").alias("usstate")).distinct() 
       //distinctState.limit(10).show()
  }
}
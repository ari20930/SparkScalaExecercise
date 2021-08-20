package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object xmlread {
def main(args:Array[String]):Unit={  
      val spark = SparkSession.builder().appName("writeintomysqltable").master("local").getOrCreate()
        spark.sparkContext.setLogLevel("ERROR")
        val df = spark.read.format("xml").option("inferSchema","true")
                           .option("rootTag","persons")
                           .option("rowTag","person")
                           .load("/home/hduser/person.xml")
                          
val df1 = df.select(col("_id").alias("id"),(explode(col("addresses.address"))).alias("address"),col("dob_month"),col("dob_year"),col("firstname"),col("gender"),col("lastname"),col("middlename"),col("salary"))

   df1.show()

}
}

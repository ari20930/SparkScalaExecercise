package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession
object readfrommysql {
  def main(args:Array[String]):Unit={
    val spark = SparkSession.builder().appName("readfrommysql").master("local").getOrCreate()
        spark.sparkContext.setLogLevel("ERROR")
        
    val readCustomerDF = spark.read.format("jdbc")
                                   .option("url","jdbc:mysql://localhost/custdb")
                                   .option("user","root")
                                   .option("password","Root123$")
                                   .option("dbtable", "customer")
                                   .option("driver","com.mysql.cj.jdbc.Driver")
                                   .load()
                                   
         readCustomerDF.show()                          
    
    
    
  }

}
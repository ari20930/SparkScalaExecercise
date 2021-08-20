package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import scala.util.control._
import org.apache.spark.sql.functions._



object udfdfex3 {
  def main(args:Array[String]):Unit={
    
    val spark = SparkSession.builder().appName("udfdfex3").master("local").getOrCreate()
        spark.sparkContext.setLogLevel("ERROR")
    
    val custSchema = StructType(
                     Array(StructField("id",IntegerType,false),
                     StructField("fname",StringType,false),
                     StructField("lname",StringType,false),
                     StructField("age",IntegerType,false),
                     StructField("profession",StringType,false)
                           ))
    val custDF = spark.read.schema(custSchema).csv("file:/home/hduser/hive/data/custs1") 
        custDF.show()
        
    val custUdf = udf(isPrimeOrNot _)
    
    custDF.withColumn("isPrimeOrNot",custUdf(col("age"))).show()
        
    
  }
  def isPrimeOrNot(age:Int):String={
    var flag=0
    //val breakloop = new Breaks
    
   /* breakloop.breakable{
    for(i<-2 to age/2)
      {
      if(age%i==0)
      {
        flag =1
        breakloop.break
      }
      }
     if(flag==0)
       "Prime"
    else if(flag==1)
        "Not Prime"
    }*/
   return "prime"
  }
  
}
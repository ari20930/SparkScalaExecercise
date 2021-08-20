package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._


//1st: Depends on the age give discount percentage ->Using DF & SQL
//file:/home/hduser/hive/data/custs1
object udfdfex2 {
  def main(args:Array[String]):Unit={
    val spark = SparkSession.builder().appName("udfdfex2").master("local").getOrCreate()
        spark.sparkContext.setLogLevel("ERROR")
    
        
    val custSchema = StructType(
                     Array(StructField("custId",IntegerType,false),
                     StructField("fname",StringType,false),
                     StructField("lname",StringType,false),
                     StructField("age",IntegerType,false),
                     StructField("progession",StringType,false))
                                )    
    val custdf = spark.read.schema(custSchema).csv("file:/home/hduser/hive/data/custs1")
    custdf.createOrReplaceTempView("custdfview")
   // val discountUdf = udf(discount(_:Int):Double)
    val discountUdf = udf(discount _)
    
    custdf.withColumn("discountPercentage",discountUdf(col("age"))).show()
    println("+++++++++++++++++++++++++++++++++++++++++++")
     spark.udf.register("discountudfsql",discount _)
     
     spark.sql("""select *,discountudfsql(age) from custdfview """).show()
      }
  
  def discount(age:Int):Double={
    if(age <30)
      return 10.0
    else if(age>=30 && age<60)
      return 15.5 
    else
      return 20
      
  }
  
}





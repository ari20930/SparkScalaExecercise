package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
/*
 * 1st: we just created the function
 * 2nd: to register the function -> we have some inbuilt function i.e. udf 
 * val function123 = udf(userdefinedfunction _)
 * or 
 * val function123 = udf(userdefinedfunction(_:Int,_:Int):Int)
 * 
 * these two way will work only when we are creating function with out lambda or anonymous function
 * 
 * if we are creating lamda function
 * val function123 = udf(userdefinedfunction)
 * 
 * 
 * 3rd:
 * dfname.withColumn("newcolumnname",function123(col("columnanem for which we need pass the parameter to the function")))
 * 
 */

object example3_udf {
  def main(args:Array[String]):Unit={
    val spark = SparkSession.builder().appName("example3_udf").master("local").getOrCreate()
        spark.sparkContext.setLogLevel("ERROR")
    val custDF = spark.read.format("csv")
                           .option("inferSchema","true")   
                           .load("file:/home/hduser/hive/data/custs1")
                           .toDF("custId","firstName","lastName","age","profession")
                          
  // val custDF1 = spark.read.option("inferSchema","true").csv("file:/home/hduser/hive/data/custs1").toDF("custId","firstName","lastName","age","profession")                        
  
  //1st:
   //val ageCtageory1 = udf(ageCategory(_:Int):String)
 //2nd:                          
   val ageCtageory1 = udf(ageCategory _)                        
  
   /*
    * If we are using lamda function -> we no need to define function defination while registering udf
    */
   //3rd:: val ageCtageory2 = udf(ageCategory1)
   val custDFNew=custDF.withColumn("ageCatgory",ageCtageory1(col("age")))
   custDFNew.show(5)
  }
  
 def ageCategory(x:Int):String={
   if(x>18 && x<30)
     return  "Young"
   else if(x>30 && x<=60)
     return "middleAge"
   else
     return "Senior"
 } 
 
 val ageCategory1=(x:Int)=>{
    if(x>18 && x<30)
       "Young"
   else if(x>30 && x<=60)
      "middleAge"
   else
      "Senior"
 }
}
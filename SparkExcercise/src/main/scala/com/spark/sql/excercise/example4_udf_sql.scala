package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
/*
 * 1st: create the function
 * 2nd: regiseter the function
 * spark.udf.register("newfunctionname",actualfunctionname _)
 * 
 * 3rd:
 * spark.sql("""select *,newfunctionname(columnname for which you want to use the function) from dfview""").show()
 */

object example4_udf_sql {
   def main(args:Array[String]):Unit={
    val spark = SparkSession.builder().appName("example3_udf_sql").master("local").getOrCreate()
        spark.sparkContext.setLogLevel("ERROR")
    
    val custDF1 = spark.read.option("inferSchema","true").csv("file:/home/hduser/hive/data/custs1").toDF("custId","firstName","lastName","age","profession")  
    
    custDF1.createOrReplaceTempView("custDF1View")
    
    spark.udf.register("custAgeCategory",ageCategory(_:Int):String)
    
    /*
     * If it's lambda function
     * spark.udf.register("custAgeCategory",ageCategory)
     * 
     * If it's not an lambda function
     * a.spark.udf.register("custAgeCategory",ageCategory(_:Int):String)
     * b.spark.udf.register("custAgeCategory",ageCategory _)
     */
    
    spark.sql("""select *,custAgeCategory(age) from custDF1View""").show()

}
   
def ageCategory(x:Int):String={
   if(x>18 && x<30)
     return  "Young"
   else if(x>30 && x<=60)
     return "middleAge"
   else
     return "Senior"
 } 
}
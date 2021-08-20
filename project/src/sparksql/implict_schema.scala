package sparksql

import org.apache.spark.sql.SparkSession

object implict_schema {
 def main(args:Array[String])={
   val spark = SparkSession.builder().appName("implict_schema").master("local").getOrCreate()
   val sc = spark.sparkContext
   sc.setLogLevel("ERROR")
   val df = spark.read
           .option("inferSchema", true)   //implicitly it will give the datatype
           .option("header",true)
           .format("csv")
           .load("file:/home/hduser/sparkFileExcercise1/movies1.csv")
           
  df.printSchema()    
  
  df.show(50,true)
 }
}
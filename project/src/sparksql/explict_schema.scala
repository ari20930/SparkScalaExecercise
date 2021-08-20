package sparksql

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row
import org.apache.spark.sql.types._

object explict_schema {
  def main(args:Array[String])={
    val spark = SparkSession.builder().appName("explict_schema").master("local").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("ERROR")
    
    val rdd = sc.textFile("file:/home/hduser/sparkFileExcercise1/movies.csv")
    val rdd1 = rdd.map(x=>x.split(",")).map(x=>Row(x(0).toInt,x(1),x(2).toInt,x(3).toFloat,x(4).toInt))
    
 
     val schema =StructType(
        List(
            StructField("movieId",IntegerType,true),
            StructField("movieName",StringType,true),
            StructField("releaseYear",IntegerType,true),
            StructField("rating",FloatType,true),
            StructField("duration",IntegerType,true)         
        ))
        

    
    val df = spark.createDataFrame(rdd1,schema)
 
    df.printSchema()
    
    df.show(100,true) 
 
    
  }
}
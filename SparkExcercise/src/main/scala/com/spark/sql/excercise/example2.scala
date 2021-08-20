package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession
object example2 {
  def main(args:Array[String]):Unit={
   val spark = SparkSession.builder().appName("example2").master("local").getOrCreate()
   val sc = spark.sparkContext
       sc.setLogLevel("ERROR")
   val lstRDD = sc.parallelize(List(("Arindam",25),("Muthu",25)))
   import spark.implicits._
     val lstDF =lstRDD.toDF("name","age")
         lstDF.show()
  }
}

/*
 * i.How many ways we can create the schema in DF::
 * typed schema or explicit schema untyped schema or implicit schema
 * 
 * i.typed schema or implicit schema  -> Using .option("inferSchema","true")
 * 
 * ii. unstyped schema or explicitSchema
 * import org.apache.spark.sql.types._
 * val custSchema=
 *  StructType(
 *  StructField("fieldName",DataType,true/false),
 *  ...
 *  
 *  )
 *  .schema(custSchema)
 *  
 *ii. How to DF from a RDD 
 * a. toDF
 * case class className(col:Int,col2:Int)
 * val rd1= rd.map(_.split(",")).map(x=>className(x(0).toInt,x(1).toInt))
 * 
 * import sparkSessionObject.implicits._ 
 * val df = rd1.toDF()
 * b. createDataFrame 
 * val rd1= rd.map(_.split(",")).map(x=>(x(0).toInt,x(1).toInt))
 * val df= spark.createDataFrame(rd1,schema_explict) 
 */

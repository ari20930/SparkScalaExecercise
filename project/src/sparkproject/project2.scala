package sparkproject
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._


object project2 {
  def main(args:Array[String])={
    val spark = SparkSession.builder().appName("Project2").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    
    /*
     * Schema Defination
     */
    val schema=StructType(
        List(
           StructField("IssuerId",IntegerType,true),
           StructField("IssuerId2",IntegerType,true),
           StructField("BusinessDate",DateType,true),
           StructField("StateCode",StringType,true),
           StructField("SourceName",StringType,true),
           StructField("NetworkName",StringType,true),
           StructField("NetworkURL",StringType,true),
           StructField("custnum",IntegerType,true),
           StructField("MarketCoverage",StringType,true),
           StructField("DentalOnlyPlan",StringType,true)
           )
           )
   val paths = List("hdfs://localhost:54310/user/hduser/sparkproject/insuranceinfo1.csv", "hdfs://localhost:54310/user/hduser/sparkproject/insuranceinfo2.csv")      
   val insuranceDF= spark.read.format("csv")
                         .option("header",true)
                         .option("delimeter",",")  
                         .option("schema","schema")
                         .load(paths: _*)
                         .toDF("IssuerId","IssuerId2","BusinessDate","StateCode","SourceName","NetworkName","NetworkURL","custnum","MarketCoverage","DentalOnlyPlan")
  //.csv("C:spark\\sample_data\\tmp\\cars1.csv", "C:spark\\sample_data\\tmp\\cars2.csv")                       
    
  val DF2 = insuranceDF.withColumnRenamed("StateCode", "stcd").withColumnRenamed("SourceName","srcnm")
  
  val DF3 = DF2.withColumn("issueridcomposite",concat(col("IssuerId"),col("IssuerId2")))
  
  val DF4 = DF3.drop(col("DentalOnlyPlan"))
  
  val DF5 = DF4.withColumn("sysdate",current_date).withColumn("systs",current_timestamp())
   
  val DF6 = DF5.na.drop()
  
  println("No. Of rows which contains some values in fields: " + DF6.count)
 // DF6.show(false)
  
  //Instantiate the class
  val  allmethods_obj = new org.inceptez.hack.allmethods;
  
  //val custom_method = udf(remspecialchar _)
  val UDF1 = udf(allmethods_obj.remspecialchar _)
  
  //val DF7 = DF6.withColumn("NetworkName_with_out_special_char",custom_method(col("NetworkName")))
  val DF7 = DF6.withColumn("NetworkName_with_out_special_char",UDF1(col("NetworkName")))
  //DF7.show(false)
  
  DF7.write.format("json").mode("overwrite").save("hdfs://localhost:54310/user/hduser/project2/json")
  
  println("file saved in json format")
  
  DF7.write.format("csv").option("header",false).option("delimeter","~").mode("overwrite").save("hdfs://localhost:54310/user/hduser/project2/csv")
  println("file saved as csv format")
  
  }
   /*def remspecialchar(NetworkName:String)={
     var str = NetworkName.replaceAll("[^a-zA-Z0-9]", " ")
     str
     
  }*/
}
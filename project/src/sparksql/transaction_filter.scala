package sparksql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions.col


object transaction_filter {
  def main(args:Array[String])={
    val spark = SparkSession.builder().appName("transactions").master("local").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("ERROR")
    val txsnSchema = StructType(List(
    StructField("txnsid",IntegerType,true),
    StructField("txnsdate",StringType,true),
    StructField("custId",IntegerType,true),
    StructField("amount",FloatType,true),
    StructField("category",StringType,true),
    StructField("product",StringType,true),
    StructField("city",StringType,true),
    StructField("state",StringType,true),
    StructField("paymentType",StringType,true)
    )   
    )
    
    val df =spark.read.format("csv").option("delimeter", ",").schema(txsnSchema).load("file:/home/hduser/hive/data/txns")
   
    
   //select txnsid,amount,product,city,state from txns where state = texas
    //col type import from functions.col
    
    val df1 = df.select(col("txnsid"),col("amount"),col("product"),col("city"),col("state")).filter(col("state")==="Texas")

    df1.show(500,false)
    
    
    /*
     * and and or 
     */
    
    val df2 = df1.filter(col("state") ==="Texas" && col("state")=== "California")
    val df3 = df1.filter(col("state")==="Texas" || col("state")==="California")
    
    val df4 = df1.where("state = 'Texas' or state = 'California'")
    
    /*
     * Select distinct city,state from txns
     * 
     */
    
    println("==================================distinct===================================")
    df.select(col("state"),col("city")).distinct().show()
    
    
    /*
     * column name change
     * 
     * select distinct city as USCITY, state as USSTATE from txns
     */
    
    println("============column name change=================================================")
    
    val cldf = df.select(col("city").alias("USCITY"),col("state").alias("USSTATE"))
    cldf.show(false)
    
    /*
     * To convert DF to RDD
     */
    val clrdd = cldf.rdd
    
    clrdd.foreach(println)
    
  }
}
package sparksql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object example4_df_operations {
  def main(args:Array[String])={
   val spark = SparkSession.builder().appName("df_operations").master("local").getOrCreate()
   val sc = spark.sparkContext
   sc.setLogLevel("ERROR")
   //Achive 
   /*
    * select state,city,sum(amount),min(amount) from txns group by state,city 
    */
  
   val df = spark.read.format("csv").option("inferSchema",true).load("file:/home/hduser/hive/data/txns").toDF("txnsId","txnsDate","custId","amount","category","product","city","state","paymentType")
   val df1 = df.groupBy("city","state").agg(round(sum("amount"),2).alias("TotalSale"),max("amount").alias("Max Amount"),min("amount").alias("Min Amount"))
   
   
  df1.show()
  
  /*
   * No. Of Records
   */
  
  println("=====================count=====================")
  df.count()

  /*
   * To take the first record
   */
  println("=====================first record=================")
  val df2 = df1.first()
  println(df2)
  
  /*
   * To change the data Type
   */
  println("======================change the datatype===============")
  
  //val transactionId = df2.getInt(0)
  //println(transactionId)
  
  
  /*
   * Query2->select txnsId,txnsDate,amount,city,state from txns where state = "california" order by amount
   */
  
  println("================================query2=============================")
  
  val query2 = df.select(col("txnsId"),col("txnsDate"),col("amount"),col("city"),col("state")).orderBy("amount").where("state ='California'")
  
  query2.show()
  
   /*
   * Query3->select txnsId,txnsDate,amount,city,state from txns where state = "california" order by amount descending
   */
  
  println("================================query3->descending order=====================================")
  val query3 = df.select(col("txnsId"),col("txnsDate"),col("amount"),col("city"),col("state")).where("state = 'California'").orderBy(desc("amount"))
  query3.show()
  }
}
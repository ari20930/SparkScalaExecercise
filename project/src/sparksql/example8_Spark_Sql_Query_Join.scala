package sparksql
import org.apache.spark.sql.SparkSession
object example8_Spark_Sql_Query_Join {
  def main(args:Array[String])={
    val spark = SparkSession.builder.appName("join-query").master("local").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("ERROR")
    
    val df = spark.read.format("csv").option("inferSchema",true).option("delimeter",",")
                  .load("file:/home/hduser/hive/data/custs")
                  .toDF("custId","fname","lname","age","prof")
                  
    val df1 =spark.read.format("csv").option("delimeter", ",").option("inferSchem",true).load("file:/home/hduser/hive/data/txns")
                  .toDF("txnId","txnDate","custId","amount","category","product","city","state","paymentType")
                  
    
    df.createOrReplaceTempView("customer")
    df1.createOrReplaceTempView("transactions")
    
    //for multiline query """select * from abc"""
    spark.sql("select c.custId,c.fname || c.lname,t.txnId,t.product from customer c join transactions t on t.custId=c.custId").show()
    
  }
}
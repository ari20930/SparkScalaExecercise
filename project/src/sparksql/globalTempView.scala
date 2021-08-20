package sparksql
import org.apache.spark.sql.SparkSession

object globalTempView {
  def main(args:Array[String])={
    val spark = SparkSession.builder().appName("globalTempView").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    
      val df = spark.read.format("csv").option("inferSchema",true)
                  .option("delimeter",",").load("file:/home/hduser/hive/data/custs")
                  .toDF("custId","fname","lname","age","prof")
                  
    
     df.createOrReplaceGlobalTempView("customer_global")
     spark.sql("select * from global_temp.customer_global").show()
    
     
     val new_session = spark.newSession()
     
     new_session.sql("select * from global_temp.customer_global").show()
     
     spark.catalog.listDatabases().show(false)
     spark.catalog.listTables("global_temp").show()
  }
}
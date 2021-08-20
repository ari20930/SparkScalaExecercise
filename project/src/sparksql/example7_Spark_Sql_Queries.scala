package sparksql
import org.apache.spark.sql.SparkSession

object example7_Spark_Sql_Queries {
  def main(args:Array[String])={
    val spark = SparkSession.builder().appName("Queries").master("local").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("ERROR")
    
    val df = spark.read.format("csv").option("inferSchema",true)
                  .option("delimeter",",").load("file:/home/hduser/hive/data/custs")
                  .toDF("custId","fname","lname","age","prof")
                  
                  
   //select * from custs where prof = "Pilot"
                  
   df.createOrReplaceTempView("CustTemp")
   val sql1 = spark.sql("select * from CustTemp where prof = 'Pilot' or prof = 'Teacher'")
   sql1.show()
   
                  
  }
}
package sparksql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
object read_from_json1 {
  def main(args:Array[String])={
    val spark = SparkSession.builder().appName("read_from_json").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    
    val df =spark.read.format("json").option("inferSchema",true)
                 .load("file:/home/hduser/custdata1/*.json")
                 
    val df1 =spark.read.format("json").option("inferSchema",true) 
                   .option("multiline",true)
                  .load("file:/home/hduser/employee.json")
                
         df1.show(false)
         df1.printSchema()
         
         df1.select(col("Employees.emailAddress"),col("Employees.userId")).show(false)
         
         /* 
          * explode will convert into single rows
          */
         
         println("================explde==========================")
       val df2 =  df1.select(explode(col("Employees.emailAddress")).alias("email"),col("Employees.userId").alias("userId"))
           df2.show()
       //  df2.select(col("email"),explode(col("userID"))).show(false)
  }
}
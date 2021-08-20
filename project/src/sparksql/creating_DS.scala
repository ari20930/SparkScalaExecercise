package sparksql

import org.apache.spark.sql.SparkSession
case class customer(custid:Int,fname:String,lname:String,age:Int,profession:String)
object creating_DS {
  
  def main(args:Array[String])={
    val spark =SparkSession.builder().appName("creation_Of_DS").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    import spark.implicits._
    val ds = spark.read.format("csv")
                  .option("inferSchema",true)
                  .load("file:/home/hduser/hive/data/custs")
                  .toDF("custid","fname","lname","age","profession")
                  .as[customer]
    ds.show()
    
    val df = ds.toDF()
     df.show()      
    
  }
}
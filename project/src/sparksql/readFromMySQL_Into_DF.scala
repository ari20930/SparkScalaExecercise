package sparksql

import org.apache.spark.sql.SparkSession

object readFromMySQL_Into_DF {
  def main(args:Array[String])={
    val spark = SparkSession.builder().appName("loadFromMySQL").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    
    val df = spark.read.format("jdbc")
                       .option("url","jdbc:mysql://localhost/custdb")
                       .option("user","root")
                       .option("password","Root123$")
                       .option("dbtable","customer")
                       .option("driver","com.mysql.cj.jdbc.Driver")
                       .load()
        df.show()         
        
        
   val df1 =spark.read.format("jdbc")
                      .option("url","jdbc:mysql://localhost/custdb")
                      .option("user","root")
                      .option("password","Root123$")
                      .option("dbtable","(select * from customer where city= 'Chennai') as t")
                      .option("driver","com.mysql.cj.jdbc.Driver")
                      .load()

   df1.show()                   
    
    
  }
}
package sparksql
import org.apache.spark.sql.SparkSession
import java.io.FileInputStream
import java.util.Properties


object configuration {
  def main(args:Array[String]):Unit={
    val spark = SparkSession.builder().appName("config_properties").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    
    val file= org.apache.spark.SparkFiles.get("config.properties")
    val confdata = new FileInputStream(file)
    val prop = new Properties()
    prop.load(confdata)
    
    println(prop.getProperty("conurl"))
    
    val df =spark.read.format("jdbc")
                      .option("url",prop.getProperty("conurl"))
                      .option("user",prop.getProperty("username"))
                      .option("password",prop.getProperty("password"))
                      .option("driver",prop.getProperty("driver"))
                      .option("dbtable",prop.getProperty("table"))
                      .load()

                      
                      df.show()
    
    
  }
}
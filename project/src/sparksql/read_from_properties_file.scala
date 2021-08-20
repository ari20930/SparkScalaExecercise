package sparksql
import org.apache.spark.sql.SparkSession

object read_from_properties_file {
  def main(args:Array[String])={
    val spark = SparkSession.builder().appName("read_from_properties_file").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    
    
    //read from properties file
    val filepath = spark.sparkContext.getConf.get("spark.inputpath")
    
    val df = spark.read.format("csv").option("delimeter",true)
                                    .option("inferSchema",true)
                                    .load(filepath)
                                    .toDF("custID","fname","lname","age","profession")
                                    
                                    
           df.show()                         
                                    
    
  }
}
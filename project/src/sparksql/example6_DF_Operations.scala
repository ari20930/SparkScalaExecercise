package sparksql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.DoubleType

object example6_DF_Operations {
  def main(args:Array[String])={
    val spark = SparkSession.builder().appName("operations").master("local").getOrCreate()
    val sc    = spark.sparkContext
    sc.setLogLevel("ERROR")
    val df = spark.read.format("csv").option("delimeter",",").option("inferSchema",true).load("file:/home/hduser/hive/data/custs").toDF("custId","fname","lname","age","prof")
    
   //Add a new column to the DF
    
    val df_new_column = df.withColumn("country",lit("USA"))
    
    df_new_column.show(20,false)
    
    //concatinating two column and create a new column
    
    println("====================Concatinating two column into one======================")
    val df_concat_new_column = df_new_column.withColumn("fullname",concat(col("fname"),lit(" "),col("lname" )))
    
    df_concat_new_column.show(20,false)
    
    //condition column 
    println("=====================condition column=======================================")
    val df_condition_column = df_concat_new_column.withColumn("isEven", (col("age") % 2 ===0))
    df_condition_column.show(20,false)
    
    
    
    //case or mulitiple condition
    
    val mulitple_condition =df_condition_column.withColumn("ageCatgory",when(col("age") < 20,"child" )
                                                                       .when(col("age") <50,"middle-age")
                                                                       .when(col("age") === 60,"senior")
                                                                       .when(col("age") > 60,"old")
                                                                       .otherwise("very old"))
   println("======================multiple condition======================")
   mulitple_condition.show(10,false)
   
   
   //Sequnce 
   println("=====================sequence=================================")
   val sequence = mulitple_condition.withColumn("id",monotonically_increasing_id())
   sequence.show(10,false)
   
   //reName 
   val rename_Of_id = sequence.withColumnRenamed("id","seqId").withColumnRenamed("category","categoryOfPerson")
   println("====================rename=====================================")
   rename_Of_id.show(5,false)
  
   
   //Handling Null Values
    println("=================null value handling==================")
    rename_Of_id.where("prof is not null").show(5,false)
   //or
    rename_Of_id.filter("prof is  null").show(5,false)
   // or
    rename_Of_id.filter(col("prof").isNotNull).show(5,false)
   //or
    rename_Of_id.filter(col("prof").isNull).show(5,false)
    
    
    //replacing The Null Values of Integer column with 0
    println("===========replacing the null values for integer===================")
    rename_Of_id.na.fill(0).show(5,false)
    println("===========replacing the null values for char===================")
    rename_Of_id.na.fill("unknown").show(5,false)
    
    //replace the null value for a particular column
    println("==========replace the null value for a particular column=============")
    rename_Of_id.na.fill(0,Array("age")).show(false)    
    
    //replace the null value for a multiple column
    println("==========replace the null value for a multiple column=============")
    rename_Of_id.na.fill("Na",Array("fname","lname","prof")).show(false)
    
    //Delete row which contains  any column as null value
    rename_Of_id.na.drop().show()
    
    //Delete row which contains  particular column as null value
    rename_Of_id.na.drop(Array("prof")).show()
    
    
    //Describe will give all the max,min,mean,count,stdev value
    println("================describe===============")
    rename_Of_id.describe("age").show()
    import spark.implicits._
    val rdd = sc.parallelize(List(10,20,30))
    val df_rdd = rdd.toDF()
    df_rdd.describe().show()
    
    //TypeCasting
    println("============type casting==========")
    rename_Of_id.select(col("age").cast(DoubleType)).show()
    
    
 
   
  }
  
}
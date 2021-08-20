package com.spark.sql.excercise
import org.apache.spark.sql.SparkSession

/*
 * i want to read from an existing hive table and write to an existing hive table
 * i want to same requiremnt by creating new table
 * assignment
custdb
default
hiveday2
insure
retaildb

ext_loc_exists

ext_loc_exists_new1
 * 
 */
object hivedummy1 {
  def main(args:Array[String]):Unit={
    val spark = SparkSession.builder().appName("hivedummy1").master("local")
                            .config("hive.metastore.uris","thrift://localhost:9083")
                            .enableHiveSupport()  
                            .getOrCreate()
                            
                            
        spark.sparkContext.setLogLevel("ERROR")
       // spark.catalog.listDatabases().show()
      //   spark.catalog.listTables("hiveday2").show()
     // spark.sql("""create table hiveday2.ext_loc_exists_new1 stored as orc as select * from hiveday2.ext_loc_exists where 1=2 """)
    // spark.sql("""insert into hiveday2.ext_loc_exists_new1 select * from hiveday2.ext_loc_exists """)
       
     
     val ext_loc_exsts_new1DF = spark.sql("""select * from hiveday2.ext_loc_exists_new1""")
     ext_loc_exsts_new1DF.write.mode("append").format("orc").saveAsTable("hiveday2.ext_loc_exists_new3")
   //    ext_loc_exsts_new1DF.write.mode("append").saveAsTable("hiveday2.ext_loc_exists_new4") 
           
  //hive by default text 
 // spark to store the data into a particular table by default it will be parquet
      
      
  }
  
  
}
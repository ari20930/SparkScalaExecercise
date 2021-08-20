package sparksql
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions._
object UDF {
  def main(args:Array[String])={
   val spark = SparkSession.builder().appName("UDF").master("local").getOrCreate()
      spark.sparkContext.setLogLevel("ERROR")
      
      val df =spark.read.format("csv").option("inferSchema",true).load("file:/home/hduser/hive/data/custs")
                   .toDF("custId","fname","lname","age","profession")
                   
    
   
   val getdiscountper =udf(getDiscount _)
   val df1 = df.withColumn("discount",getdiscountper(col("age")))
   
   df1.show()
   
   spark.udf.register("getdiscountper",getDiscount _)
   
   spark.udf.register("prime",isPrime)
   
   df.createOrReplaceTempView("customer1")
   spark.catalog.listTables("default").show()
   spark.sql("""select
                custId,fname,lname,age,profession,getdiscountper(age) as discount
                from customer1 """).show()
  
    spark.sql("""select
                custId,fname,lname,age,profession,getdiscountper(age) as discount,prime(age) as Prime
                from customer1 """).show()              
                
                
                
  }
   def getDiscount(age:Int)={
     if(age<10)
       5
     else if(age <20)
       10 
     else if(age<30)
       15 
     else 
       20 
   }
   
   val isPrime=(a:Int)=>{
     var isPrime = true
     for(i<-2 to a-1)
     {
       if(a%i==0)
         isPrime = false
     }
     isPrime
   }
   
}
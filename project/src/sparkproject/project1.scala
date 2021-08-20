package sparkproject
import org.apache.spark.{SparkContext,SparkConf}
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.Row

object project1 {
  def main(args:Array[String]):Unit={
    val sc = new SparkContext(new SparkConf().setAppName("Projct1").setMaster("local"))
    sc.setLogLevel("ERROR")
     
    val file1 = sc.textFile("hdfs://localhost:54310/user/hduser/sparkproject/insuranceinfo1.csv")
    val header = file1.first()
    val data = file1.filter(x=> x!=header);
    println("total-records-count of Insurace1 is "+ data.count)
   
    /*
     * Fetching all the records which is having 10 columns and using case class
     */
    val insurance1_rdd2 =data.map(_.trim)
                  .filter(x=>x.length() !=0)
                  .map(_.split(",",-1))
                  .filter(x=>x.length ==10)
                  .map(x=>insureclass(x(0).toInt,x(1).toInt,x(2),x(3),x(4),x(5),x(6),x(7).toInt,x(8),x(9)))
               
      println("After Data Cleaning Count of Insurance1 File is "+ insurance1_rdd2.count)       
      
      println("Number of Rows removed after clean-up process for Insurance1 File " +(data.count - insurance1_rdd2.count))
      
      val insurance1_result=insurance1_rdd2.map(x=>(x.IssuerId,x.IssuerId2,x.BusinessDate,
                   x.StateCode,x.SourceName,x.NetworkName,
                   x.NetworkURL,x.custnum,x.MarketCoverage,
                   x.DentalOnlyPlan)) 
 
                  
   /*
    * No. Of Rows with does not contain 10 columns    from Insurance1 File
    */
      
      val rejectdata =data.map(_.trim)
                          .filter(x=>x.length() !=0)
                          .map(_.split(",",-1))
                          .filter(x=>x.length !=10)
                          .map(x=>x.toList.mkString(","))
                          

     

   /*
    * For InsuranceInfo2  
    */
     
     val insurance2 = sc.textFile("hdfs://localhost:54310/user/hduser/sparkproject/insuranceinfo2.csv")
     val header1 = insurance2.first()
     val insurance2_data =insurance2.filter(x=>(x != header1))
     
     println("Insurance2 , no. of records are: "+ insurance2_data.count)
     
     /*
      * From Insurance2 File
      * Removing those record which contains 10 columns and where Issuerid and IssuerId2 are spaces
      */
     val rdd_insurance2 = insurance2_data.map(_.trim())
                                         .filter(x=> x.length() != 0)
                                         .map(x=>x.split(",",-1))
                                         .filter(x=>x.length == 10)
                                         .filter(_(0).nonEmpty)
                                         .filter(_(1).nonEmpty)
                                         .map(x=>insureclass(x(0).toInt,x(1).toInt,x(2),x(3),x(4),x(5),x(6),x(7).toInt,x(8),x(9)))

     println("After Data Cleaning Count of Insurance2 File is "+ rdd_insurance2.count)
     
     println("Number of Rows removed after clean-up process for Insurance2 File " +(insurance2_data.count - rdd_insurance2.count))
     /*
      * Merge the both header removed RDDs derived in steps 7 and 11 into an RDD namely
      * insurance1_rdd2.count + rdd_insurance2.count
      */
     
     val insuredatamerged = insurance1_rdd2.union(rdd_insurance2)
  
     val persist_rdd = insuredatamerged.persist(org.apache.spark.storage.StorageLevel.MEMORY_ONLY)
     val unique_values =persist_rdd.distinct()
     println("No. Of Duplicate rows present in Insurance1 and Insurance2 File:  " + (persist_rdd.count() - unique_values.count() ))
    
     val insuredatarepart = unique_values.repartition(8)
     
     val rdd_20191001     = insuredatarepart.filter(x=> (x.BusinessDate =="2019-10-01"))
                                            .map(x=>List(x.IssuerId,x.IssuerId2,x.BusinessDate,x.StateCode,x.SourceName,x.NetworkName,x.NetworkURL,x.custnum,x.MarketCoverage,x.DentalOnlyPlan).mkString(","))
     val rdd_20191002     = insuredatarepart.filter(x=> (x.BusinessDate =="2019-10-02"))
                                            .map(x=>List(x.IssuerId,x.IssuerId2,x.BusinessDate,x.StateCode,x.SourceName,x.NetworkName,x.NetworkURL,x.custnum,x.MarketCoverage,x.DentalOnlyPlan).mkString(","))
                                            
                                         
  /*
   * Storing rdd_20191001,rdd_20191002,insuredatamerged ,rejectdata                                  
   */
  
   rdd_20191001.coalesce(1).saveAsTextFile("hdfs://localhost:54310/user/hduser/Insurance/rdd_20191001")
   rdd_20191002.coalesce(1).saveAsTextFile("hdfs://localhost:54310/user/hduser/Insurance/rdd_20191002")
   rejectdata.coalesce(1).saveAsTextFile("hdfs://localhost:54310/user/hduser/Insurance/rejectdata_insurance1")
   insuredatamerged.coalesce(1).saveAsTextFile("hdfs://localhost:54310/user/hduser/Insurance/insuredatamerged")
   println("all the expected file saved in HDFS")  
    
                                            
   val sparksql =new SQLContext(sc)
   val schema= StructType(
       List(
           StructField("IssuerId",IntegerType,true),
           StructField("IssuerId2",IntegerType,true),
           StructField("BusinessDate",StringType,true),
           StructField("StateCode",StringType,true),
           StructField("SourceName",StringType,true),
           StructField("NetworkName",StringType,true),
           StructField("NetworkURL",StringType,true),
           StructField("custnum",IntegerType,true),
           StructField("MarketCoverage",StringType,true),
           StructField("DentalOnlyPlan",StringType,true)
           )
       )
   import sparksql.implicits._    
   val insuredaterepartdf = sparksql.createDataFrame(insuredatarepart.map(x=>Row(x.IssuerId,x.IssuerId2,x.BusinessDate,
                   x.StateCode,x.SourceName,x.NetworkName,
                   x.NetworkURL,x.custnum,x.MarketCoverage,
                   x.DentalOnlyPlan)),schema)
                   
                   
                   
   insuredaterepartdf.coalesce(1).write.format("csv").save("hdfs://localhost:54310/user/hduser/project1_df")
   println("DataFrame saved sucessfully")                                    
  }
}
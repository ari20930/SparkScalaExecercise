package com.spark.core.hackathon
import org.apache.spark.{SparkContext,SparkConf}
import org.apache.spark.storage.StorageLevel
//import org.apache.spark.sql.SparkSession

/*
 * 
 * 1.Load the file1 (insuranceinfo1.csv) from HDFS using textFile API into an RDD insuredata 
 * 2.Remove the header line from the RDD contains column names.
 * 3.Display the count and show few rows and check whether header is removed.
 * 4.Remove the blank lines in the rdd. 
 * Hint: Before splitting, trim it, calculate the length and filter only row size is not = 0.
 * 5. Map and split using ‘,’ delimiter. 
 * Hint: To avoid getting incomplete rows truncated, use split(“,”,-1) instead of split(“,”)
 * 6. Filter number of fields are equal to 10 columns only - analyze why we are doing this and 
 * provide your view here..
 * 7. Add case class namely insureclass with the field names used as per the header record in 
 * the file and apply to the above data to create schemaed RDD.
 * 8. Take the count of the RDD created in step 7 and step 1 and print how many rows are 
 * removed in the cleanup process of removing fields does not equals 10.
 * 
 * 9. Create another RDD namely rejectdata and store the row that does not equals 10 columns.
 * 
 * 10. Load the file2 (insuranceinfo2.csv) from HDFS using textFile API into an RDD insuredata2
 * 
 * 11. Repeat from step 2 to 9 for this file also and create the final rdd including the filtering of 
 * the records that contains blank IssuerId,IssuerId2 for 
 * eg: remove the records with pattern given below.
 * ,,,,,,,13,Individual,Yes
 * 
 * 12. Merge the both header removed RDDs derived in steps 7 and 11 into an RDD namely 
 * insuredatamerged 
 * 
 * 13.Cache it either to memory or any other persistence levels you want, display only first 
 * few rows
 * 
 * 
 * 14.Calculate the count of rdds created in step 7+11 and rdd in step 12, check whether they 
 * are matching.
 * 
 * 15. Remove duplicates from this merged RDD created in step 12 and print how many 
 * duplicate rows are there.
 * 
 * 16. Increase the number of partitions to 8 and name it as insuredatarepart.
 * 
 * 17. Split the above RDD using the businessdate field into rdd_20191001 and 
 * rdd_20191002 based on the BusinessDate of 2019-10-01 and 2019-10-02 respectively
 * 
 * 18. Store the RDDs created in step 9, 12, 17 into HDFS locations.
 * 
 * 
 * 19. Convert the RDD created in step 16 above into Dataframe namely insuredaterepartdf 
 * applying the structtype created in the step 20 given in the next usecase.
 * Hint: Think of converting df to rdd then use createdataframe to apply schema some 
 * thing like this..
 * Eg: createDataframe(df19.rdd,structuretype
 * 
 */
case class insureclass(IssuerId:Int,IssuerId2:Int,BusinessDate:String,StateCode:String,SourceName:String,NetworkName:String,NetworkURL:String,custnum:String,MarketCoverage:String,DentalOnlyPlan:String)
object sparkCoreRddHeackathon {
  def main(args:Array[String]):Unit={
    val sc = new SparkContext(new SparkConf().setAppName("sparkCoreRddHackathon").setMaster("local").set("spark.hadoop.validateOutputSpecs","false"))
        sc.setLogLevel("ERROR")
    /*
     * 1.Load the file1 (insuranceinfo1.csv) from HDFS using textFile API into an RDD insuredata 
     * 2.Remove the header line from the RDD contains column names.
     *    
     */
    val insure1Rdd = sc.textFile("hdfs://localhost:54310/user/hduser/sparkproject/insuranceinfo1.csv")    
    val insure1Header = insure1Rdd.first 
    val insure1WithOutHeaderRdd = insure1Rdd.filter(!_.equals(insure1Header))
    
    /*
     * 3.Display the count and show few rows and check whether header is removed.
     */
    println("Display few rows form insrance1 data with out header")
         insure1WithOutHeaderRdd.take(5).foreach(println)
         
    /*
     * 4. Remove the blank lines in the rdd. 
     * Hint: Before splitting, trim it, calculate the length and filter only row size is not = 0. 
     * 5. Map and split using ‘,’ delimiter. 
     * Hint: To avoid getting incomplete rows truncated, use split(“,”,-1) instead of split(“,”)
     * 
     * 6. Filter number of fields are equal to 10 columns only - analyze why we are doing this and 
     * provide your view here..
     * => Because to get actual data or the data which will added value to business  i.e. nothing but to clean the data
     *     
     * 7. Add case class namely insureclass with the field names used as per the header record in 
     * the file and apply to the above data to create schemaed RDD.    
     *     
     *     
     */
     val inusre1SchemaRdd  =     insure1WithOutHeaderRdd.map(_.trim)
                                                        .filter(_.length!=0)
                                                        .map(_.split(",",-1))
                                                        .filter(_.length==10)
                                                        .filter(_(0).nonEmpty)
                                                        .filter(_(1).nonEmpty)
                                                        .filter(_(2).nonEmpty)
                                                        .filter(_(3).nonEmpty)
                                                        .filter(_(4).nonEmpty)
                                                        .filter(_(5).nonEmpty)
                                                        .filter(_(6).nonEmpty)
                                                        .filter(_(7).nonEmpty)
                                                        .filter(_(8).nonEmpty)
                                                        .filter(_(9).nonEmpty)
                                                        .map(x=>insureclass(x(0).toInt,x(1).toInt,x(2),x(3),x(4),x(5),x(6),x(7),x(8),x(9)))
                                                        
      /*
       *8. Take the count of the RDD created in step 7 and step 1 and print how many rows are 
       *removed in the cleanup process of removing fields does not equals 10.                                                                
       */
       println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++") 
       println("No. of Rows Has been cleaned from Insurace1 file is :: "+(insure1WithOutHeaderRdd.count - inusre1SchemaRdd.count))  
       
       /*
        * 9. Create another RDD namely rejectdata and store the row that does not equals 10 columns.
        */
       val rejectInsurance1RddData = insure1WithOutHeaderRdd.map(_.trim)
                                                           .map(_.split(","))
                                                           .filter(_.length!=10)
                                                           .map(_.toList)
      //To check the 8th step no. count and 9th step count matching or not.
       println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
       println("No. of count of reject data from Inurance1 File:: "+rejectInsurance1RddData.count)                                                     
       
       
       /*
        * 10. Load the file2 (insuranceinfo2.csv) from HDFS using textFile API into an RDD insuredata2
        * 
        */
       val insurance2Rdd = sc.textFile("hdfs://localhost:54310/user/hduser/sparkproject/insuranceinfo2.csv")
       val insurance2Header = insurance2Rdd.first 
       val insurance2DataWithOutHeader = insurance2Rdd.filter(!_.equals(insurance2Header))
       val insurance2SchemaRdd   = insurance2DataWithOutHeader.map(_.trim)
                                                              .map(_.split(",",-1))
						                                                  .filter(_.length!=0)
						                                                  .filter(_.length==10)
                                                              .filter(x=>x(0).nonEmpty)
						                                                  .filter(x=>x(1).nonEmpty)
						                                                  .filter(x=>x(2).nonEmpty)
						                                                  .filter(x=>x(3).nonEmpty)
						                                                  .filter(x=>x(4).nonEmpty)
						                                                  .filter(x=>x(5).nonEmpty)
						                                                  .filter(x=>x(6).nonEmpty)
						                                                  .filter(x=>x(7).nonEmpty)
						                                                  .filter(x=>x(8).nonEmpty)
						                                                  .filter(x=>x(9).nonEmpty)
						                                                  .map(x=>insureclass(x(0).toInt,x(1).toInt,x(2),x(3),x(4),x(5),x(6),x(7),x(8),x(9))) 

                                         
       /*
       *Take the count of the RDD created in step 7 and step 1 and print how many rows are 
       *removed in the cleanup process of removing fields does not equals 10.                                                                
       */
    
       
       /*
        * Create another RDD namely rejectdata and store the row that does not equals 10 columns.
        */
       val rejectInsurance2RddData = insurance2DataWithOutHeader.map(_.trim)
                                                                .map(_.split(","))
                                                                .filter(_.length!=10)          
                                                                .map(_.toList)
     
      //To check the 8th step no. count and 9th step count matching or not.
       println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
       println("No. of count of reject data from Inurance2 File:: "+rejectInsurance2RddData.count)
      //Note we might get count difference b/w  rejectInsurance2RddData.count & (insurance2DataWithOutHeader.count-insurance2SchemaRdd.count)
      // sine we have bad data like ,,,,,,,13,Individual,Yes   
       
       
       
       /*
        * 12. Merge the both header removed RDDs derived in steps 7 and 11 into an RDD namely 
        * insuredatamerged
        * 
        * 13. Cache it either to memory or any other persistence levels you want, display only first 
        * few rows
        * 
        * 14. Calculate the count of rdds created in step 7+11 and rdd in step 12, check whether they 
        * are matching.
        * 
        */
       val insuredatamerged = insure1WithOutHeaderRdd.union(insurance2DataWithOutHeader).persist(StorageLevel.MEMORY_AND_DISK_2)
       println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
       println("Displaying few rows after persisting both insurance1 and insurance2 data")
           insuredatamerged.take(5).foreach(println)
       println("-::Calculating total count of rdds created in step7 and step11 i.e. for insurance1 and insurance2 data with out header & checking is it matching the count with mergeRdd insuremergerdd::- ")
       println("TotalCount of Insurance1 & Insurance2 rdd:: "+(insure1WithOutHeaderRdd.count+insurance2DataWithOutHeader.count))
       println("Count of insuredatamerged: "+insuredatamerged.count)  
       
       
       /*
        * 15. Remove duplicates from this merged RDD created in step 12 and print how many 
        * duplicate rows are there.
        */
       val nonDuplicateDataInsureMergeRdd = insuredatamerged.distinct 
       println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
       println("No. of duplicte rows present in insuredatamerged is:: "+(insuredatamerged.count-nonDuplicateDataInsureMergeRdd.count))
           
       /*
        * 16. Increase the number of partitions to 8 and name it as insuredatarepart. 
        */
       val insuredatarepart = nonDuplicateDataInsureMergeRdd.repartition(8)
       
        /*
         * 17. Split the above RDD using the businessdate field into rdd_20191001 and 
         *     rdd_20191002 based on the BusinessDate of 01-10-2019 and 02-10-2019 respectively
         *     
         *18. Store the RDDs created in step 9, 12, 17 into HDFS locations.     
         */
       
       val rdd_20191001 = insuredatarepart.map(_.split(","))
                                          .map(_.toList.mkString(","))
                                          .filter(_(2)=="01-10-2019")
       val rdd_20191002 = insuredatarepart.map(_.split(","))
                                          .map(_.toList.mkString(","))
                                          .filter(_(2)=="02-10-2019")
                                          
       rdd_20191001.saveAsTextFile("hdfs://localhost:54310/user/hduser/rdd_20191001") 
       println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
       println("rdd_20191001 file has been stored sucessfully in hdfs with path:-/user/hduser/rdd_20191001")
       
       rdd_20191002.saveAsTextFile("hdfs://localhost:54310/user/hduser/rdd_20191002") 
       println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
       println("rdd_20191002 file has been stored sucessfully in hdfs with path:-/user/hduser/rdd_20191002")
       
       rejectInsurance1RddData.saveAsTextFile("hdfs://localhost:54310/user/hduser/rejectInsurance1RddData") 
       println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
       println("rejectInsurance1RddData file has been stored sucessfully in hdfs with path:-/user/hduser/rejectInsurance1RddData")
       
       rejectInsurance2RddData.saveAsTextFile("hdfs://localhost:54310/user/hduser/rejectInsurance2RddData") 
       println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
       println("rejectInsurance2RddData file has been stored sucessfully in hdfs with path:-/user/hduser/rejectInsurance2RddData")
       
       
       /*
        * 19. Convert the RDD created in step 16 above into Dataframe namely insuredaterepartdf 
				* applying the structtype created in the step 20 given in the next usecase.
				* Hint: Think of converting df to rdd then use createdataframe to apply schema some 
				* thing like this..
				* Eg: createDataframe(df19.rdd,structuretype
        */
       
       /*  
        *  To convert RDD into DF
        *  
        * 1st:Creating SparkSession Object to create DF or we can create  DF using org.apache.spark.sql.SQLContext(sc) object
        * 2nd: import spark.implicits._
        */
     // val spark = SparkSession.builder().appName("example3").master("local").getOrCreate()
       /*
        * Using case class
        * 
        */
      println("this is df excercise")  
   //   insuredatarepart.take(5).foreach(println)
   //   import spark.implicits._
   /*   val insuredaterepartdf_case = insuredatarepart.map(x=>x.split(",",-1))
                                                    .filter(_.length==10)
                                                    .filter(_(0).nonEmpty)
                                                    .filter(_(1).nonEmpty)
                                                    .filter(_(2).nonEmpty)
                                                    .filter(_(3).nonEmpty)
                                                    .filter(_(4).nonEmpty)
                                                    .filter(_(5).nonEmpty)
                                                    .filter(_(6).nonEmpty)
                                                    .filter(_(7).nonEmpty)
                                                    .filter(_(8).nonEmpty)
                                                    .filter(_(9).nonEmpty)
                                                    .map(x=>insureclass(x(0).toInt,x(1).toInt,x(2),x(3),x(4),x(5),x(6),x(7),x(8),x(9)))
                                                    
                                                    
          insuredaterepartdf_case.take(5).foreach(println)
          //IssuerId:Int,IssuerId2:Int,BusinessDate:String,StateCode:String,SourceName:String,NetworkName:String,NetworkURL:String,custnum:String,MarketCoverage:String,DentalOnlyPlan:String
          val insuredaterepartdf  =insuredaterepartdf_case.map(x=>(x.IssuerId,x.IssuerId2,x.BusinessDate,x.StateCode,x.SourceName,x.NetworkName,x.NetworkURL,x.custnum,x.MarketCoverage,x.DentalOnlyPlan))toDF()                                             
                                                     
       println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
       println("To show the DF few record with full column value from df using case class:- ")
         insuredaterepartdf.show()*/
  }
  
}
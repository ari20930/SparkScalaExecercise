package sparkproject
import org.apache.spark.{SparkContext,SparkConf}

case class insureclass(IssuerId:Int,IssuerId2:Int,BusinessDate:String,StateCode:String,SourceName:String,NetworkName:String,NetworkURL:String,custnum:Int,MarketCoverage:String,DentalOnlyPlan:String)
object sparkrdd {
  def main(args:Array[String])={
    val sc = new SparkContext(new SparkConf().setAppName("master").setMaster("local"))
    sc.setLogLevel("ERROR")
    
    val file1 = sc.textFile("hdfs://localhost:54310/user/hduser/sparkproject/insuranceinfo1.csv")
    val header = file1.first()
    val data = file1.filter(x=> x!=header);
    println("total-records-count is "+ data.count)
   
   // data.foreach(println)
    
    val rdd2 =data.map(_.trim)
                  .filter(x=>x.length() !=0)
                  .map(_.split(",",-1))
                  .filter(_.length ==10)
                  .filter(_(0).nonEmpty)
                  .filter(_(1).nonEmpty)
                  .filter(_(2).nonEmpty)
                  .filter(_(3).nonEmpty)
                  .filter(_(4).nonEmpty)
                  .filter(_(5).nonEmpty)
                  .filter(_(2).nonEmpty)
                  .filter(_(3).nonEmpty)
                  .filter(_(4).nonEmpty)
                  .filter(_(5).nonEmpty)
                  .map(x=>insureclass(x(0).toInt,x(1).toInt,x(2),x(3),x(4),x(5),x(6),x(7).toInt,x(8),x(9)))
                
                  //.map(x=>(x(0),x(1),x(2),x(3),x(4),x(5),x(6),x(7),x(8),x(9)))
                 //   .map(x=>x.toList.mkString(","))
      println("After Data Cleaning Count is "+ rdd2.count)       
      
      println("Number of Rows removed after clean-up process " +(data.count - rdd2.count))
   /*
    * Cleaning to Data
    */
      val headerrdd = sc.parallelize(Seq(header))
      headerrdd.union(rdd2.map(x=>List(x.IssuerId,x.IssuerId2,x.BusinessDate,
                   x.StateCode,x.SourceName,x.NetworkName,
                   x.NetworkURL,x.custnum,x.MarketCoverage,
                   x.DentalOnlyPlan).mkString(","))).coalesce(1).saveAsTextFile("hdfs://localhost:54310/user/hduser//insurance1/clean_data_insurance_info1")
     
      println("cleaning of data stored in HDFS")             
                  
   /*
    * No. Of Rows with does not contain 10 columns    
    */
      
      val rejectdata =data.map(_.trim)
                          .map(_.split(","))
                          .filter(_.length !=10)
                          .map(_.toList.mkString(","))
     
                          
    
     val rejectDataWithUnion = headerrdd.union(rejectdata) 
     rejectDataWithUnion.coalesce(1).saveAsTextFile("hdfs://localhost:54310/user/hduser//insurance1/reject_insurance_info1")
     println("rejected data stored in HDFS")
     
   /*
    * For InsuranceInfo2  
    */
     
     val insurance2 = sc.textFile("hdfs://localhost:54310/user/hduser/sparkproject/insuranceinfo2.csv")
     val header1 = insurance2.first()
     val insurance2_data =insurance2.filter(x=>(x != header1))
     
     println("Insurance2 , no. of records are: "+ insurance2_data.count)
     
     val rdd_insurance2 = insurance2_data.map(_.trim())
                                         .filter(x=> x.length() != 0)
                                         .map(x=>x.split(",",-1))
                                         .filter(x=>x.length == 10)
                                         .filter(_(0).nonEmpty)
                                         .filter(_(1).nonEmpty)
                                         .map(x=>List(x(0),x(1),x(2),x(3),x(4),x(5),x(6),x(7),x(8),x(9)).mkString(","))
    val header1_rdd =sc.parallelize(Seq(header1))  
    
    val insurance2_final_data = header1_rdd.union(rdd_insurance2)
    
    insurance2_final_data.coalesce(1).saveAsTextFile("hdfs://localhost:54310/user/hduser/insrance2/finaldata")
    
    println("Insurance2 final data is saved")
     
    
  }
  
}
package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
import org.apache.spark.rdd.RDD

/*
 * 6.Data for task
 *  Load txns file from  /home/hduser/user/hive/data location into RDD
 * txnsid,date,custID,saleAmt,categoryOfProduct,ProdcutName,city,state,paymentType
 * 
 * 00091358,07-25-2011,4002712,133.24,Indoor Games,Ping Pong,Midland,Texas,credit
 * 
 * Accomplish the below Task
 * 1. Sum sales of for texas State
 *  -> select sum(sales) from txns where state = "Texas"
 *  
 *  
 * 2. Max number of product sales in Texas
 *  -> Select count(txnsid),ProductName from txns
 *     where state= "Texas"
 *     group by txnsid,ProductName
 *     order by count(txnsid)
 *     limit 1
 *     
 *     
 *  
 *  
 * 3. Sales by payment Type in Texas
  *  -> Select paymentType,Sum(salesAmt) from txns
 *     where state= "Texas"
 *     group by paymentType
 * 
 */
object example10_task06 {
  def main(args:Array[String])=
  {
    val sc = new SparkContext(new SparkConf().setAppName("example5.5").setMaster("local"))
    sc.setLogLevel("ERROR")
    
   
  
   // getSalesRespectToPaymentType()
    
   val rdd = sc.textFile("file:/home/hduser/hive/data/txns")
   val rdd1 = rdd.map(x=> x.split(","))
   val rdd2 = rdd1.filter(x=> x(7)=="Texas")
     
     println("===========Total sales result===============")
     getTotalSales(rdd2)
     println("===========Total sales occured for which prodcut===============")
     getMaxProductSales(rdd2)
     
     println("===========Total sales occured with which payment type and what is the sales amount===============")
     getSalesRespectToPaymentType(rdd2)
    
  }
  
  def getTotalSales(rdd:RDD[Array[String]])={
    
    val rdd1 = rdd.map(x=> x(3).toFloat)
    println("sum of sales amount of texas state" +" "+rdd1.sum().round)
    
    
  }
  
  def getMaxProductSales(rdd:RDD[Array[String]])={
    
    //select productname,1 as count from texas
    val rdd1 = rdd.map(x=> (x(5),1))
    //select productname,sum(count) from texas
    val rdd2 = rdd1.reduceByKey((x,y)=> x+y)
    
    //select prodcutname,sum(count) as descending order on the basis of count
    val rdd3 = rdd2.sortBy(x=> x._2,false)
    
    val rdd4 = rdd3.first()

    println("Max. Sale happened for the Item is" +"   "+rdd4._1+"  " +"\n"+"Total num of sales happend is" +"  "+rdd4._2)

    
  }
  
  def getSalesRespectToPaymentType(rdd:RDD[Array[String]])={
   /* //select paymenttype, 1 as count from txns
    val rdd1 = rdd.map(x=> (x(8),1))
    
    //paymenttype,sum(count)
    val rdd2 = rdd1.reduceByKey((x,y)=> x+y)
    
    //sort the payment-type,sum(count) with respect to count
    val rdd3 = rdd2.sortBy(x=> x._2,false)
    
    val rdd4 = rdd3.first()
    println("Max. Sale happened with the Payment Type is" +"   "+rdd4._1+"  " +"\n"+"Total num of sales happend is" +"  "+rdd4._2)
  */
    
    val rdd1 = rdd.map(x=> (x(8),x(3).toFloat))
    
    val rdd2 = rdd1.reduceByKey((x,y)=> x+y)
    
    val rdd3 = rdd2.sortBy(x=> x._2,false)
    
    val rdd4 = rdd3.first()
    
    println("Max. Sale happened with the Payment Type is" +"   "+rdd4._1+"  " +"\n"+"Total sales happend is" +"  "+rdd4._2.round)
   
    
    
        
  }
}
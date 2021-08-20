package com.spark.core.practice
import org.apache.spark.{SparkContext,SparkConf}
/*Load txns file from /home/hduser/hive/data location into RDD Accomplish the followings:-
*1.	Sum of sales for texas state
*2.	Max number of product sales in texas   -> max sales for which product
*3.	Sales by payment type in texas 
*
*credit  20
*cash    40 
*debit   100
*
*  txnno    txndate   custno amount  category        product               city    state  spendby
*00000111,03-05-2011,4000401,173.56,Gymnastics,Gymnastics Protective Gear,Portland,Oregon,credit
*00000112,07-03-2011,4007626,194.49,Outdoor Recreation,Cycling,Flint,Michigan,credit
*00000113,03-07-2011,4005597,011.88,Dancing,Ballet Bars,Denton,Texas,credit
*00000114,02-01-2011,4004525,173.51,Puzzles,Jigsaw Puzzles,Dallas,Texas,credit
*00000115,08-29-2011,4002190,045.53,Outdoor Recreation,Tetherball,Jackson,Mississippi,credit
*/

object excercise8 {
  def main(args:Array[String]):Unit={
    val sc=  new SparkContext(new SparkConf().setAppName("excercise8").setMaster("local"))
        sc.setLogLevel("ERROR")
   
        
   println("++++++++++++++++++++++Solution1++++++++++++++++++++++++++++++++")
    val txnsData = sc.textFile("file:/home/hduser/hive/data/txns")

    val rdd1= txnsData.map(x=>x.split(",")).map(x=>(x(0),x(1),x(2),x(3),x(4),x(5),x(6),x(7),x(8)))
    val rdd2= rdd1.filter(x=>x._8.equals("Texas"))
    val StateSaleAmtRdd = rdd2.map(x=>(x._8,x._4.toFloat))
    val sumOfSaleAmtForTexas=StateSaleAmtRdd.reduceByKey(_+_)
    
    println("Sum of sales for texas state")
    sumOfSaleAmtForTexas.foreach(println)
   
   println("++++++++++++++++++++++Solution2++++++++++++++++++++++++++++++++") 
    val productTxns=rdd2.map(x=>(x._6,x._1)).groupBy(x=>x._1).mapValues(x=>x.size).sortBy(x=>x._2,false)
    println("Max number of product sales in texas" +" "+productTxns.first())
    
   println("++++++++++++++++++++++Solution3++++++++++++++++++++++++++++++++")
    val salesByPayment = rdd2.map(x=>(x._9,x._1)).countByKey()
    println("Sales by payment type in texas")
    salesByPayment.foreach(println)
   
    
    
    
    
  }
}
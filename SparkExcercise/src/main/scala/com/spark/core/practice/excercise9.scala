package com.spark.core.practice
import org.apache.spark.{SparkContext,SparkConf}
/*
*Load the txns file into RDD Accomplish the followings:-
*1.	Get totalsales by state wise and sort by state
*2.	Get transactioncount by date and sort by transactioncount
*3.	Get the date having maximum transactioncount
*
*  txnno    txndate   custno amount  category        product               city    state  spendby
*00000111,03-05-2011,4000401,173.56,Gymnastics,Gymnastics Protective Gear,Portland,Oregon,credit
*00000112,07-03-2011,4007626,194.49,Outdoor Recreation,Cycling,Flint,Michigan,credit
*00000113,03-07-2011,4005597,011.88,Dancing,Ballet Bars,Denton,Texas,credit
*00000114,02-01-2011,4004525,173.51,Puzzles,Jigsaw Puzzles,Dallas,Texas,credit
*00000115,08-29-2011,4002190,045.53,Outdoor Recreation,Tetherball,Jackson,Mississippi,credit
*/

object excercise9 {
  def main(args:Array[String]):Unit={
    val sc = new SparkContext(new SparkConf().setAppName("excercise9").setMaster("local"))
        sc.setLogLevel("ERROR")
    val txnsFile=sc.textFile("file:/home/hduser/hive/data/txns")
    val txnsdata=txnsFile.map(_.split(",")).map(x=>(x(0),x(1),x(2),x(3),x(4),x(5),x(6),x(7),x(8)))    
    println("++++++++++++++++++++++solution1++++++++++++++++++++++++++++++++++")   
    val totalsalesByState=txnsdata.map(x=>(x._7,x._4.toFloat)).reduceByKey(_+_).sortBy(x=>x._1,false)
    println("Get totalsales by state wise and sort by state")
    totalsalesByState.foreach(println)
    
    println("++++++++++++++++++++++solution2++++++++++++++++++++++++++++++++++") 
    val txnCountByDate = txnsdata.map(x=>(x._2,x._1)).groupByKey().mapValues(x=>x.size).sortBy(x=>x._2,false)
    //or 
    //val txnCountByDate = txnsdata.map(x=>(x._2,x._1)).groupBy(x=>x._1).mapValues(x=>x.size).sortBy(x=>x._2,false)
    
    println("Get transactioncount by date and sort by transactioncount")
    txnCountByDate.foreach(println)
    
    println("++++++++++++++++++++++solution3++++++++++++++++++++++++++++++++++") 
    println("Get the date having maximum transactioncount")
    println("maximum transactioncount:: "+" "+txnCountByDate.first)

    
  }
}
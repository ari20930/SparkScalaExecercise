package com.spark.core.practice
import org.apache.spark.{SparkConf,SparkContext}
/*
*sparkl0/sales.txt 
*Department,Designation,costToCompany,State 
*Sales,Trainee,12000,UP
*Sales,Lead,32000,AP
*Sales,Lead,32000,AP
*Sales,Lead,32000,TN
*Sales,Lead,32000,MH
*Sales,Lead,32000,MH
*Marketing,Associate,18000,TN
*Marketing,Associate,18000,TN
*HR,Manager,58000,TN
*
*Accomplish the following:-
*
*Produce the output as csv with group by department,designation,state and additional column with sum(costToCompany) and
*TotalEmployeeCount Should get results like
*Dept,Desg,State,empcount,totalcost
*Sales,Lead,AP,2,64000
*Sales,Lead,MH,3,96000
*Sales,Lead,TN,2,64000
*/
object excercise18 {
  def main(args:Array[String]):Unit={
        val sc = new SparkContext(new SparkConf().setAppName("excercise18").setMaster("local").set("spark.hadoop.validateOutputSpecs","false"))
            sc.setLogLevel("ERROR")
        val salesRdd=sc.textFile("file:/home/hduser/sparkl0/sales.txt")
        val header = salesRdd.first 
        val salesDataRdd = salesRdd.filter(!_.equals(header)).map(x=>x.split(",")).map(x=>(x(0),x(1),x(3),x(2).toFloat))
        val totalcostRdd = salesDataRdd.map(x=>((x._1,x._2,x._3),x._4)).reduceByKey(_+_)
        val countRdd    = salesDataRdd.groupBy(x=>(x._1,x._2,x._3)).mapValues(x=>x.size)
        val resultRdd = countRdd.join(totalcostRdd).map(x=>(x._1._1,x._1._2,x._1._3,x._2._1.toString,x._2._2.toString))
        val finalheader = ("Dept","Desg","State","empcount","totalcost")
        val headerRdd = sc.parallelize(Seq(finalheader))
        val finalResult = headerRdd.union(resultRdd)
        println("TotalEmployeeCount and TotalSales:: ")
            finalResult.foreach(println)
  }
}
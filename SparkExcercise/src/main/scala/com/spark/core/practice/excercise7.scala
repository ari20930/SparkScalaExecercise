package com.spark.core.practice
import org.apache.spark.{SparkContext,SparkConf}
/*Given a file name spark6/user.csv user.csv
*id,topic,hits
*Rahul,scala,120 
*Nikita,spark,80 
*Mithun,spark,1 
*myself,cca175,180
*Accomplish the followings:-
*Write spark code in scala which will remove the header part and create RDD of values as below,for all rows.
*And also if id is "myself" than filter out row.
*/
object excercise7 {
  def main(args:Array[String]):Unit={
    val sc = new SparkContext(new SparkConf().setAppName("excercise7").setMaster("local"))
    sc.setLogLevel("ERROR")
    
    val rdd1=sc.textFile("file:/home/hduser/spark6/user.csv")
    val header=rdd1.first 
    val dataWithOutHeader=rdd1.filter(!_.equals(header))  
    val rdd2=dataWithOutHeader.map(x=>x.split(",")).map(x=>(x(0),x(1),x(2)))
    val filterMyself = rdd2.filter(x=>x._1.equals("myself"))
        filterMyself.foreach(println)

  }
}
package com.spark.sql.excercise
import org.apache.spark.{SparkContext,SparkConf}
import org.apache.spark.sql.SQLContext
object UsingSQLContextExampe1 {
  def main(args:Array[String]):Unit={
   val conf = new SparkConf().setAppName("UsingSQLContextExample1").setMaster("local")
   val sc = new SparkContext(conf)
       sc.setLogLevel("ERROR")
       
   val sqlc = new SQLContext(sc)
   
   val df1=sqlc.read.format("csv")
                 .option("header","true").option("inferSchema","true").load("file:/home/hduser/movies.csv")
   
       df1.show()
   
  }
}
package com.spark.core.practice
import org.apache.spark.{SparkContext,SparkConf}
/*
*Given a filename EmployeeName.csv 
*EOl,Lokesh
*E02,Bhupesh 
*E03,Amit
*E04,Ratan 
*E05,Dinesh 
*E06,Pavan
*E07,Tejas 
*E08,Sheela 
*E09,Kumar
*ElO,Venkat
*
*Accomplish the followings:-
*Load the file from hdfs and sort it by name and save it back as (id,name) in results directory.
*However make sure while saving it should be able to write in a single file
*/

object excercise17 {
def main(args:Array[String]):Unit={
  val sc = new SparkContext(new SparkConf().setAppName("excercise17").setMaster("local").set("spark.hadoop.validateOutputSpecs","false"))
      sc.setLogLevel("ERROR")
  val employeeFileRdd = sc.textFile("file:/home/hduser/EmployeeName.csv")
  val employeeFieldsRdd = employeeFileRdd.map(x=>x.split(",")).map(x=>(x(0),x(1))).sortBy(x=>x._2,false)
    employeeFieldsRdd.coalesce(1).saveAsTextFile("hdfs://localhost:54310/user/hduser/sortByNameForEmployee")	
  println("file has been saved sucessfully")
  println("EmployeeName in sorted order:: ")
    employeeFieldsRdd.foreach(println)
  
  
  
}  
}
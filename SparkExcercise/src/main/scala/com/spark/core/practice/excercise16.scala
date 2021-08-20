package com.spark.core.practice
import org.apache.spark.{SparkContext,SparkConf}
/*
*You have given 3 csv files hdfs as below:­ EmployeeManager.csv
*E0l,Vishnu
*E02,Satyam
*E03,Shiv
*E04,Sundar
*E05,John
*E06,Pallavi
*E07,Tanvir
*E08,Shekhar
*E09,Vinod 
*El0,Jitendra
*
*EmployeeName.csv 
*E0l,Lokesh 
*E02,Bhupesh
*E03,Amit
*E04,Ratan
*E05,Dinesh
*E06,Pavan
*E09,Kumar
*ElO,Venkat
*
*EmployeeSalary.csv 
*E0l,50000
*E02,50000
*E03,45000
*E04,45000
*E05,50000
*E06,45000
*E07,50000
*E08,10000
*E09,10000
*El0,10000
*
*
*Accomplish the following:-
*
*Using spark and its API you have to generate a joined output as below and save as text file (Separated by comma)
*for final distribution and output must be sorted by id 
*id,name,salary,managerName
*/
object excercise16 {
  def main(args:Array[String]):Unit={
    val sc = new SparkContext(new SparkConf().setAppName("excercise16").setMaster("local").set("spark.hadoop.validateOuputSpecs","false"))
        sc.setLogLevel("ERROR")
        val employeeManagerRdd = sc.textFile("file:/home/hduser/EmployeeManager.csv")
        val empManagerFieldsRdd  = employeeManagerRdd.map(x=>x.split(",")).map(x=>(x(0),x(1)))
        val employeeNameRdd    = sc.textFile("file:/home/hduser/EmployeeName.csv")
        val empNameFieldsRdd   = employeeNameRdd.map(x=>x.split(",")).map(x=>(x(0),x(1)))
        val employeeSalaryRdd  = sc.textFile("file:/home/hduser/EmployeeSalary.csv")
        val empSalaryFieldsRdd   = employeeSalaryRdd.map(x=>x.split(",")).map(x=>(x(0),x(1)))
        val joinRdd = empNameFieldsRdd.join(empSalaryFieldsRdd).join(empManagerFieldsRdd)

        val finalResult = joinRdd.map(x=>(x._1,x._2._1._1,x._2._1._2,x._2._2)).sortBy(x=>x._1,false)
        val header      = ("id","name","salary","managerName")
        val headerRdd   = sc.parallelize(Seq(header))
            headerRdd.union(finalResult).saveAsTextFile("hdfs://localhost:54310/user/hduser/excercise15")
        println("file has been saved successfully")	
        println("employee details:: ")
            headerRdd.union(finalResult).foreach(println)
        
    
  }
}
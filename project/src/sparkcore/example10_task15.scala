package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
/*
 * You have given 3 csv files hdfs as below:-
 *EmployeeManager.csv
 *E01,Vishnu
 * 
 *EmployeeName.csv
 *E01,Lokesh
 * 
 *EmployeeSalary.csv
 *E01,50000
 * 
 *Accomplish the following:-
 *Using spark and its API you have to generate a joined output as below 
 *and save as text file (Separated by comma)
 *for final distribution and output must be sorted by id
 *id,name,salary,managerName
 *E01,Lokesh,50000,Vishnu 
 */
object exmpale10_task15 {
  def main(args:Array[String])={
    val sc = new SparkContext(new SparkConf().setAppName("task15").setMaster("local"))
    sc.setLogLevel("ERROR")
    val manager =sc.textFile("file:/home/hduser/sparkFileExcercise1/EmployeeManager.csv").map(x=>x.split(",")).map(x=>(x(0),x(1)))
    val name    =sc.textFile("file:/home/hduser/sparkFileExcercise1/EmployeeName.csv").map(x=>x.split(",")).map(x=>(x(0),x(1)))
    val salary  =sc.textFile("file:/home/hduser/sparkFileExcercise1/EmployeeSalary.csv").map(x=>x.split(",")).map(x=>(x(0),x(1)))
    
    val rdd     =name.join(salary.join(manager)).sortBy(x=>x._1, true).map(x=>List(x._1,x._2._1,x._2._2._1,x._2._2._2)).map(x=>x.mkString(","))
    
    val header  = ("id","Name","Salary","ManagerName")
    val rdd1 = sc.parallelize(Seq(header)).map(x=>List(x._1,x._2,x._3,x._4)).map(x=>x.mkString(","))
    val rdd2 = rdd1.union(rdd)
    rdd2.coalesce(1).saveAsTextFile("file:/home/hduser/user//taskresult//task15")
    println("=================task15 result save sucessfully in file===============")
  }
}
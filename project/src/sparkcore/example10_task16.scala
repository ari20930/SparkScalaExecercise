package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
/*
 * 16.DATATASK
 * ::DATA FOR TASK::
 * 
 *EmployeeName.csv
 *E01,Lokesh
 *E02,Bhupesh
 *E03,Amit
 *E04,Ratan
 *E05,Dinesh
 *E06,Pavan
 *E07,Tejas
 *E08,Sheela
 *E09,Kumar
 *E10,Venkat
 * 
 * Accomplish the followings:-
 * Load the file from hdfs and sort it by name and save it back as (id,name) in results directory.
 * However make sure while saving it should be able to write in a single file
 */
object example10_task16 {
  def main(args:Array[String])={
    val sc = new SparkContext(new SparkConf().setAppName("task16").setMaster("local"))
    sc.setLogLevel("ERROR")
    val rdd = sc.textFile("file:/home/hduser/sparkFileExcercise1/EmployeeName.csv",2)
    val rdd1 = rdd.map(x=>x.split(",")).map(x=>(x(0),x(1))).sortBy(x=>x._2,true)
    
    rdd1.coalesce(1).saveAsTextFile("file:/home/hduser//taskresult/task17")
    println("==============result in save file==================")
    
    //rdd1.foreach(println)
  }
}
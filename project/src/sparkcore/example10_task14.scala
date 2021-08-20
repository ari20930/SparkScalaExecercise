package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
/*
 * 14-DATATASK
 * 
 *data.csv
 *1,Lokesh
 *2,Bhupesh
 *3,Amit
 *4,Ratan
 *5,Dinesh
 *
 *sparkworkouts/marks.csv
 *1~90~80~95
 *2~88~90~89
 *3~78~76~70
 *4~92~69~89
 *5~88~70~86
 * 
 * Accomplish the followings:-
 * 1. Load the files into RDD and get the studentid,students,mark1,mark2,marks3,totalmarks
 * 2. Get the highest mark scored studentinfo 
 */
object example10_task14 {
  def main(args:Array[String])={
    val sc = new SparkContext(new SparkConf().setAppName("task14").setMaster("local"))
    sc.setLogLevel("ERROR")
    
    val emp  = sc.textFile("file:/home/hduser/sparkFileExcercise1/data.csv").map(x=>x.split(",")).map(x=>(x(0),x(1)))
    val mark = sc.textFile("file:/home/hduser/sparkFileExcercise1/marks.csv").map(x=>x.split("~")).map(x=>(x(0),(x(1),x(2),x(3),x(1).toInt + x(2).toInt + x(3).toInt)))
    val rdd1 = emp.join(mark).map(x=>(x._1,x._2._1,x._2._2._1,x._2._2._1,x._2._2._2,x._2._2._3,x._2._2._4)).sortBy(x=>x._1,true)
    
    val rdd2 =rdd1.map(x=>List(x._1,x._2,x._3,x._4,x._5,x._6,x._7)).map(x=>x.mkString(","))
    val header = List("studentid","students","mark1","mark2","marks3","totalmarks")
    val headerrdd = sc.parallelize(Seq(header))
    val unionrdd = headerrdd.map(x=>x.mkString(",")).union(rdd2)
    
    /*
     * studentid,students,mark1,mark2,marks3,totalmarks
     */
    unionrdd.foreach(println)
    
    /*
     * highest mark scored studentinfo 
     */
    
     println("================highest mark scored==================")
     println(rdd1.sortBy(x=>x._7,false).first())
    
    
    
  }
}
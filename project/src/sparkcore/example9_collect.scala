package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
/*
 * 14-DATA FOR TASK
 * Given FileName :-
 * student.csv
 * 1,Lokesh
 * 2,Bhupesh
 * 3,Amit
 * 4,Ratan
 * 5,Dinesh
 * 
 * marks.csv
 * 1~90~80~95
 * 2~88~90~89
 * 3~78~76~70
 * 4~92~69~89
 * 5~88~70~86
 * 
 * Accomplish the followings:-
 *1. Load the files into RDD and get the studentid,students,mark1,mark2,marks3,totalmarks
 *2. Get the highest mark scored studentinfo 
 * 
 */
object example9_collect {
  def main(args:Array[String])={
    val sc = new SparkContext(new SparkConf().setAppName("example9").setMaster("local"))
    sc.setLogLevel("ERROR")
    val studrdd =sc.textFile("file:/home/hduser/sparkFileExcercise1/student.csv")
    val marksrdd = sc.textFile("file:/home/hduser/sparkFileExcercise1/marks.csv")
    
    //Array("1","Lokesh")
    val rdd1 = studrdd.map(x=>x.split(","))
    
    //("1","Lokesh")
    val rdd2 = rdd1.map(x=>(x(0),x(1)))
    
    //Array("2","88","90","89")
    val rdd3 = marksrdd.map(x=>x.split("~"))

    //("2",("88',"90","89"))
    val rdd4 = rdd3.map(x=>(x(0),(x(1).toInt ,x(2).toInt ,x(3).toInt )))
    
    //(1,(Lokesh,(90,80,95))
    val rdd5 = rdd2.join(rdd4)
   
    val maprdd = rdd5.map(x=>(x._1,x._2._1,x._2._2._1,x._2._2._2,x._2._2._3))
    
    /*
     * Get the studentid,students,mark1,mark2,marks3,totalmarks
     */
    //(1,Lokesh,90,80,95)
    val totalrdd = maprdd.map(x=>(x._1,x._2,x._3,x._4,x._5, x._3+x._4+x._5))
    
 
    
    /*
     * Student with lowest marks
     */
    println("=======lowestMarks==================")
    val stdarr = totalrdd.collect()
    val stdlst = stdarr.toList
    val sort1 = stdlst.sortBy(x=>x._6)  //return as an Array
   
    println(sort1(0))

    /*
     * Student with highest marks
     */
    println("=======HighestMarks==================")
    println(sort1(sort1.length-1))
    //or
    //println(sort1.last)
   
  
  }
}
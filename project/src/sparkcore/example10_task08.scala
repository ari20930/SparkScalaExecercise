package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
/*
 * 
 *---------------------------------
 *8. Data For Task
 *---------------------------------
 *Create and copy file cricket.txt in hdfs location with the data below:
 *Rajiv,21
 *Create and copy file hockey.txt in hdfs location with the data below:
 *Ramesh,25
 *Create and copy file football.txt in hdfs location with the data below:
 *Ravinder,21
 *
 *Accomplish the followings:-
 *
 *1. Find the players who are in cricket and football
 *2. Find the players who are in all 3 sports
 *3. Get all the distinct players
 *4. Get all the distinct players with sports
 */
object example10_task08 {
  def main(args:Array[String])={
    val sc = new SparkContext(new SparkConf().setAppName("task08").setMaster("local"))
    sc.setLogLevel("ERROR")
    val cricket  =sc.textFile("hdfs://localhost:54310/user/hduser/hadoop/cricket.txt").map(x=>x.split(",")).map(x=>(x(0),x(1)))
    val hockey   =sc.textFile("hdfs://localhost:54310/user/hduser/hadoop/hockey.txt").map(x=>x.split(",")).map(x=>(x(0),x(1)))
    val football =sc.textFile("hdfs://localhost:54310/user/hduser/hadoop/football.txt").map(x=>x.split(",")).map(x=>(x(0),x(1)))

    val first = cricket.join(football).map(x=>List(x._1,x._2._1).mkString(","))
    println("=============Find the players who are in cricket and football==================")
    first.foreach(println)
    
    println("=============Find the players who are in all 3 sports==================")
    val second = cricket.join(football.join(hockey)).map(x=>List(x._1,x._2._1).mkString(","))
    second.foreach(println)

    println("=============Get all the distinct players==================")
    val third =cricket.union(hockey.union(football))
    val four = third.map(x=>x._1).distinct()
    four.foreach(println)
  }
}
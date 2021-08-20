package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
/*
 * 11. Data For Task=movies.csv
 * 1,The Nightmare Before Christmas,1993,3.9,4568
 * 
 *Accomplish the followings:-
 *
 *1. Load the movies data into the RDD. 
 *2. List the movies that having a rating greater than 3.5
 *3. List the movies that are released after 1980
 *4. List the movies by release year
 *5. Save the final data in HDFS in location "/sparkworkouts/movierelease" into 2 files 
 * 
 */
object example10_task11 {
  def main(args:Array[String])={
    val sc = new SparkContext(new SparkConf().setAppName("example7").setMaster("local"))
    sc.setLogLevel("ERROR")
    
    val filerdd = sc.textFile("file:/home/hduser/sparkFileExcercise1/movies.csv")
    val rdd2 = filerdd.map(x=>x.split(","))
    
   /*
    * List the movies that having a rating greater than 3.5
    */
    val rdd3 = rdd2.filter(x=> x(3).toFloat > 3)
    val rdd4 = rdd3.map(x=> List(x(1),x(3)))
    rdd4.map(x=>x.mkString(",")).foreach(println) 
  
    
  
    /*
     * List the movies that are released after 1980
     */
     println("================list of movies released after 1980======================")
     val rdd5 = rdd2.filter(x=> x(2).toInt > 1980)
     val rdd6 = rdd5.map(x=>List(x(1),x(2)))
     rdd6.map(x=>x.mkString(",")).foreach(println)
     
     
      
     /*
      * List the movies by release year
      * To remove the CompactBuffer 
      * x._2.toList.sortBy(x=>x)
      * 
      */
      println("================List the movies by release year======================")
      val rdd7 = rdd2.map(x=>(x(2),x(1))).groupByKey()
      val rdd8 = rdd7.map(x => List(x._1, (x._2.toList.sortBy(x => x).mkString(";"))))

    //  rdd8.map(x=>x.mkString(":")).foreach(println)
     rdd8.map(x=>x.mkString(":")).saveAsTextFile("file:/home/hduser//sparkworkouts/movierelease")
      println("================data has been stored into file======================")
      
      /*
       * Year wise movie count
       */
      
      println("================Year wise movie count======================")
      val rdd9 = rdd7.sortByKey(true,1).map(x=> List(x._1,x._2.toList.length)).map(x=>x.mkString(","))
       
      rdd9.foreach(println)
      
      
      
      
          
   
    
  }
}
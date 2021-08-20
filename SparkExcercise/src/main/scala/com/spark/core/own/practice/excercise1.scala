package com.spark.core.own.practice
import org.apache.spark.{SparkContext,SparkConf}
import scala.io.Source
object excercise1 {
  
  def loadMoviesNames():Map[Int,String]={
    var moviesName:Map[Int,String]=Map()
    /*
     * To read file from scala
     */
    
    val lines=Source.fromFile("file:/home/hduser/moviesfile.csv").getLines().drop(1)
    for(line<-lines){
      val fls=line.split(",")
      moviesName+= (fls(0).toInt -> fls(1))
    }
    return moviesName
  }
  def mapTotuple(line:String):(Int,(Float,Int))={
    val fields=line.split(",")
    return (fields(1).toInt,(fields(2).toFloat,1))
    
  }
  def main(args:Array[String]):Unit={
    val sc = new SparkContext(new SparkConf().setAppName("excercise1").setMaster("local").set("spark.hadoop.validateOutputSpecs","false"))
        sc.setLogLevel("ERROR")
        
    val moviesRdd=sc.textFile("file:/home/hduser/movies.csv")
    val header =moviesRdd.first
    val nonHeader= moviesRdd.filter(!_.equals(header))
   
 
    //extract the rating as float and count no. of occurance in reverses order of rating 
    //5.0,1223
    //4.5,12321
    //4,23
    
    println("************Solution1***************************")
    //val rsult1Rdd= nonHeader.map(_.split(",")).map(x=>(x(2).toFloat)).map((_,1)).reduceByKey(_+_).sortByKey(false)
    //rsult1Rdd.foreach(println)
    val rsult1Rdd= nonHeader.map(_.split(",")(2).toFloat).countByValue().toSeq.sortBy(x=>x).reverse
    rsult1Rdd.foreach(println)
    
    println("************Solution2***************************")
    /*
     *create a function mapToTuple and map String rows and selected attributes 
     * mapToTuple function converts a String row into key-value pair movieId->(rating,count)
     * where the initial value of the count is 1 
     * 
     * Find the sum of ratings and number of ratings of each movie(movieId,(totalRatings,count))
     * 
     * o/p:
     * (4,(9.0,2))
     * (6,(6.0,2))
     * (2,(4.0,1))
     * (1,(4.5,1))
     * (3,(3.0,1))
     * (5,(10.0,2))
     * 
     */
    
     val solution2Rdd=nonHeader.map(mapTotuple).reduceByKey((x,y)=>(x._1+y._1,x._2+y._2))
     solution2Rdd.foreach(println)
     
     
    println("************Solution3***************************")
    /*
     * Given the totalRating and count(number of ratings), we can find the average rating
     * by dividing the totalRating by the count
     *
     * o/p:
     * (4,4.5)
     * (6,3.0)
     * (2,4.0)
     * (1,4.5)
     * (3,3.0)
     * (5,5.0)
     */
    
     val solution3Rdd=solution2Rdd.map(x=>(x._1,x._2._1/x._2._2 ))
     solution3Rdd.foreach(println)
     
     println("************Solution4***************************")
     /*
      * From the above movieIds mapped to the average ratings.sort the result
      * by average ratings in descending order
      * o/p:
      * (5,5.0)
      * (4,4.5)
      * (1,4.5)
      * (2,4.0)
      * (6,3.0)
      * (3,3.0)
      * 
      */
     val solution4Rdd=solution3Rdd.sortBy(_._2,false)
     solution4Rdd.foreach(println)
     
     println("************Solution5***************************")
     /*
      * From the movies file display 1st and 2nd column & split the 2nd column
      * value by ('|') and repeat on every row
      * o/p:
      * (ToyStory(1995),Adventure)
			* (ToyStory(1995),Animation)
      * (ToyStory(1995),Children)
      * (ToyStory(1995),Comedy)
			*	(ToyStory(1995),Fantasy)
      * 
      */
     
     val moviesFileRdd=sc.textFile("file:/home/hduser/moviesfile.csv")
     val movieHeader = moviesFileRdd.first()
     val moviesActualData = moviesFileRdd.filter(!_.equals(movieHeader)) 
     val solution5Rdd=moviesActualData.map(_.split(",")).map(x=>(x(1),x(2))).flatMapValues(x=>x.split('|'))
     solution5Rdd.foreach(println)
     
     println("************Solution6***************************")
     /*
      * From movies file split the data based on 2nd column and display only action data
      * & remove the tuple
      * 
      * 
      * 
      */
     
     val actionDataRdd=solution5Rdd.filter(x=>x._2==("Action")).map(x=>x._1+","+x._2)
     actionDataRdd.foreach(println)
     
      println("************Solution7***************************")
     /*
      * From movies file split the data based on 2nd column and display only comedy data
      * & sort it
      * 
      * 
      * 
      */
         
      val comedyRdd=solution5Rdd.filter(x=>x._2.equals("Comedy")).map(x=>x._1).sortBy(x=>x,false)
      comedyRdd.foreach(println)
      
       println("************Solution8***************************")
     /*
      * Create a function loadMoviesNames() to read  the movies.csv and to create key-value
      * pairs of moviesId and titles. Find the average ratings on movieId and sort  in reverse
      * of average ratings and then call the loadMovieName() to fetch the below o/p.
      * (villian(1971),5.0)
      * (Hype!(1996),5.0)
      * (Little Murders(1971),5.0)
      * 
      * DataVerfication:
      * Output before calling function
      * (13680,5.0)
      * (1310,5.0)
      * 
      * Movies-file:
      * 13680 Villian (1971)
      * 
      */
     val movieName=loadMoviesNames()
     val movieRatings=nonHeader.map(mapTotuple)
     
     
     
      
     
     
  }
}
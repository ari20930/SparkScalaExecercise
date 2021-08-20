package sparksql
import org.apache.spark.{SparkContext,SparkConf}
import org.apache.spark.sql.SQLContext

object example1 {
 def main(args:Array[String])={
   val sc  = new SparkContext(new SparkConf().setAppName("example1").setMaster("local"))
   sc.setLogLevel("ERROR")
   val sqlc = new SQLContext(sc)
   val df   = sqlc.read.format("csv")
   .option("inferSchema" , "true")
   .load("file:/home/hduser/sparkFileExcercise1/movies.csv")
   .toDF("movieid","movie-name","released-year","rating","duration")
   
   /*
    * By Default - 2o record ,truncate = true
    */
   df.show(50,false)

   /*
    * To get the schema information
    */
   println("===================this is schema information============")
   df.printSchema()
   /*
    * To filter the data
    */
   println("=================this is filter records================")
   
   val df1 = df.filter(df("rating")> 3.5)
   
   df1.show(50,false)
 }
}
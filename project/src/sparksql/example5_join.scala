package sparksql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.plans.LeftOuter

object example5_join {
  def main(args:Array[String])={
    val spark = SparkSession.builder().appName("example5_join").master("local").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("ERROR")
    val df1 =spark.read.format("csv").option("delimeter",",").option("inferSchema",true).load("file:/home/hduser/sparkworkouts/students.csv")
             .toDF("studentId","studentName")
    val df2 =spark.read.format("csv").option("inferSchema",true).option("delimeter",",").load("file:/home/hduser/sparkworkouts/marks.csv")
             .toDF("studentId","sub1Mark","sub2Mark","sub2Mark")
    //val df3 = df1.join(df2,df1("studentId") === df2("studentId"),"inner")
    //OR
    
    /*
     * Inner Join         
     */
    println("=================================Inner Join===================================")         
    val df4 = df1.join(df2,"studentId")
    df4.show()
  
    println("=================================left==========================================")
    
    /*
     * keyword ->left_outer,leftouter,left
     */
    val df5 = df1.join(df2,df1("studentId") === df2("studentId"),"leftouter")
    df5.show()
    
    println("=================================right==========================================")
    
    /*
     * keyword ->right_outer,rightouter,right
     */
    val df6 = df1.join(df2,df1("studentId") === df2("studentId"),"right")
    df6.show()
    
    
    println("=================================full==========================================")
    
    /*
     * keyword ->full_outer,fullouter,full
     */
    val df7 = df1.join(df2,df1("studentId") === df2("studentId"),"fullouter")
    df7.show()
    
    
    
    
  
  }
}
package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
/*
 *---------------------------------
 *4. Data For Task
 *---------------------------------
 *hdpcd/Inceptez4A.txt
 *Inceptez.com techcert.com Incepeztchcert.com
 *
 *
 *hdpcd/Inceptez4B.txt
 *Hadoop Spark Scala Python Java Cloud DataScience
 *
 *hdpcd/Inceptez4C.txt
 *India USA UK Canada Australia
 *
 *Accomplish the followings:-
 *
 *1. Load all 3 files in different RDDS
 *2. Concatnate all the data in single RDDS
 *3. Count all the words in of all 3 files
 */
object example10_task04 {
  def main(args:Array[String])={
    val sc = new SparkContext(new SparkConf().setAppName("master").setMaster("local"))
    sc.setLogLevel("ERROR")
    
    val file1 = sc.textFile("file:/home/hduser/hdpcd/Inceptez4A.txt")
    val file2 = sc.textFile("file:/home/hduser/hdpcd/Inceptez4B.txt")
    val file3 = sc.textFile("file:/home/hduser/hdpcd/Inceptez4C.txt")
    
    val file = file1.union(file2.union(file3)).flatMap(x=> x.split(" "))

    
    println("Total Number Of Words:- " + file.count())
    
    
    
  }
}
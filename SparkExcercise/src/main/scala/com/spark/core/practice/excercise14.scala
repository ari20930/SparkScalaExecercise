package com.spark.core.practice
import org.apache.spark.{SparkContext,SparkConf}
import scala.util.matching.Regex

/*
*sparkworkouts/sparkdirl/filel.txt
*Apache Hadoop is an open-source software framework written in Java for distributed storage and distributed processing of very large data sets on computer clusters built from commodity hardware. All the modules in Hadoop are designed with a fundamental assumption that hardware failures are common and should be automatically handled by the framework
*
*sparkworkouts/sparkdir2/file2.txt
*The core of Apache Hadoop consists of a storage part known as Hadoop Distributed File System (HDFS) and a processing part called MapReduce. Hadoop splits files into large blocks and distributes them across nodes in a cluster. To process data, Hadoop transfers packaged code for nodes to process in parallel based on the data that needs to be processed.
*
*sparkworkouts/sparkdir3/file3.txt
*his approach takes advantage of data locality nodes manipulating the data they have access to to allow the dataset to be processed faster and more efficiently than it would be in a more conventional supercomputer architecture that relies on a parallel file system where computation and data are distributed via high-speed networking
*
*Accomplish the following:-
*
*1.write the spark program which loads the all 3 file from hdfs.
*2.Do the word count by filtering the following words
*And result should be sorted by word count in reverse order and save it hdfs 
* (or","to","and","The","of")
*Note:Also please make sure you load all 3 files as Single RDD(All 3 files must be loaded using single API call)
*/

object excercise14 {
  
def matchWord(x:String):Boolean={
val lst1=List("or","to","and","The","of")
//val regObj =lst1.mkString(",").r 
//val f=(regObj findAllIn x).toString 

//!f.isEmpty()
//x.contains(lst1.mkString(","))
x==lst1(0) || x==lst1(1) || x==lst1(2)|| x==lst1(3) || x==lst1(4)

}
  def main(args:Array[String]):Unit={
    val sc = new SparkContext(new SparkConf().setAppName("excercise14").setMaster("local").set("spark.hadoop.validateOutputSpecs","false"))
        sc.setLogLevel("ERROR")
        
    val fileRdd = sc.textFile("hdfs://localhost:54310/sparkworkouts/sparkdir*")
    //or
   // val fileRdd=sc.textFile("hdfs://localhost:54310/sparkworkouts/sparkdirl/filel_1.txt,hdfs://localhost:54310/sparkworkouts/sparkdir2/file2_2.txt,hdfs://localhost:54310/sparkworkouts/sparkdir2/file3_3.txt")
   
    val wordCount =  fileRdd.flatMap(_.split(" ")).filter(matchWord).map(x=>(x,1)).reduceByKey(_+_).sortBy(x=>x._2,false)
        wordCount.foreach(println)  
        
        wordCount.saveAsTextFile("hdfs://localhost:54310/user/hduser/wordcount")
    println("file has been sucessfully")
  }
}
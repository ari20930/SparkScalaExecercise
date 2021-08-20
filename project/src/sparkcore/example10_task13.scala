package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
/*
 * 
 *--------------------------------
 *13.	Data For Task
 *---------------------------------
 *You have given following 3 files as below:-
 *
 *sparkworkouts/sparkdir1/file1.txt
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
 *write the spark program which loads the all 3 file from hdfs and do the word count by filtering the following words
 *And result should be sorted by word count in reverse order
 *
 *Filter words("a","the","an","as","a","with","this","these","is","are","in","for","to","and","The","of") 
 *
 *Also please make sure you load all 3 files as Single RDD(All 3 files must be loaded using single API call)
 */
object example10_task13 {
  def main(args:Array[String])={
    val sc = new SparkContext(new SparkConf().setAppName("task13").setMaster("local"))
    sc.setLogLevel("ERROR")
    
    val files = sc.textFile("hdfs://localhost:54310/user/hduser/sparkworkouts/sparkdir1/file1.txt,hdfs://localhost:54310/user/hduser/sparkworkouts/sparkdir2/file2.txt,hdfs://localhost:54310/user/hduser/sparkworkouts/sparkdir3/file3.txt",2)
    
    val y = List("a","the","an","as","a","with","this","these","is","are","in","for","to","and","The","of")
    val file1 = files.flatMap(x=>x.split(" ").toList)
    
    val file2 = file1.map(x=>{
      var flag=0
      var cout = 0
      for(i<-y)
      {
        
        if(x.contains(i))
        flag=1
      }
      if(flag==1)
       x
    })
file2.foreach(println)
    
    

    
    //filter(x=>x.contains("a","the","an","as","a","with","this","these","is","are","in","for","to","and","The","of")).map(x=>(x,1))
    
    
  }
}
package sparkcore

import org.apache.spark.{SparkContext,SparkConf}


object example3_readfies {
  def main(args:Array[String])={
    
    val sc = new SparkContext(new SparkConf().setAppName("example3").setMaster("local"))
    sc.setLogLevel("ERROR")
    
    println("----------------------this is read a file------------------------")
    val filerdd = sc.textFile("file:/home/hduser/hive/data/txns").map(x => x.split(",")).map(x=>(x(7),x(3))).map(x=>(x._1,x._2.toFloat)).filter(x=>x._2 > 100)
    filerdd.foreach(println)
    
    /*
     * Read more than one file from local
     */
    println("----------------------this is read  multiple file------------------------")
    val rdd1 = sc.textFile("file:/home/hduser/file1.text,file:/home/hduser/file2.text,file:/home/hduser/file3.text")
    
    rdd1.foreach(println)
    
    
    /*
     * Read from Floder or sub-directories  ,we need to specify only the folder-name path , it will automatically copy all folder - file  into one rdd
     */
    
    println("----------------------this is read from folder------------------------")
    val rdd2 = sc.textFile("file:/home/hduser/hdfstolocal")
    rdd2.foreach(println)
    
      
    /*
     * Read only particular type of file(e.g. text) from Folder or sub-directories  ,we need to specify only the folder-name path , it will automatically copy all folder - file  into one rdd
     */
    
    println("----------------------this is read particular type of file from folder------------------------")
    
    val rdd3 = sc.textFile("file:/home/hduser/hdfstolocal/*text")
    
    rdd3.foreach(println)
    
    
    /*
     *  Read from HDFS -> It will be same way only instead of file: , we need to give hdfs:
     */
    
     println("----------------------this is read file from hdfs------------------------")
     
     val rdd4 = sc.textFile("hdfs://localhost:54310/user/hduser/file1.text")
     rdd4.foreach(println)
     
     
    /*
     * Read from HDFS-Floder or sub-directories  ,we need to specify only the folder-name path , it will automatically copy all folder - file  into one rdd
     */
    
     println("----------------------this is read file from hdfs-folder------------------------")
     
     val rdd5 = sc.textFile("hdfs://localhost:54310/user/hduser/hadoop")
     rdd5.foreach(println)
     
     
    /*
     * Read only particular type of file(e.g. text) from HDFS-Folder or sub-directories  ,we need to specify only the folder-name path , it will automatically copy all folder - file  into one rdd
     */
    
     println("----------------------this is read particular type of file from hdfs-folder------------------------")
     
     val rdd6 = sc.textFile("hdfs://localhost:54310/user/hduser/hadoop/*text")
     rdd6.foreach(println)
     
    /*
     *  Read from Local and HDFS
     */
    
     println("----------------------this is read from both locl && hdfs------------------------")
     val rdd7 = sc.textFile("file:/home/hduser/local.text,hdfs://localhost:54310/user/hduser/file1.text")
     rdd7.foreach(println)
     
    
     
     
     
  }
  
      
  
}
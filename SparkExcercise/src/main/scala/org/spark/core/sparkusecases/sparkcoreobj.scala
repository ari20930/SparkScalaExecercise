package org.spark.core.sparkusecases
import org.apache.spark.{SparkContext,SparkConf}
import org.apache.spark.storage.StorageLevel

/*
*1. Create a scala object sparkcoreobj
*2. Create main method
*3. Define Sparkconf object with appname as ur name and cluster manager as local with 2 cores of processor.
*4. Define sparkcontext as izsc passing the above sparkconf object as argument.
* Excute the below usecases:
* i.load the data from /home/hduser/sparkdata/youtube_videos.tsv
* e.g.
* id	duration	bitrate	bitrate(video)	height	width	frame rate	frame rate(est.)	codec	category	url
*uDNj-_5ty48	267	373	274	568	320	29.97	0	h264	Music	http://r2---sn-ovgq0oxu-5goe.c.youtube.com/videoplayback?algorithm=throttle-factor&burst=40&ipbits=8&sparams=algorithm%2Cburst%2Ccp%2Cfactor%2Cid%2Cip%2Cipbits%2Citag%2Csource%2Cupn%2Cexpire&mv=m&source=youtube&ip=86.50.94.176&ms=au&fexp=931311%2C916903%2C916713%2C916612%2C919515%2C913818%2C923434%2C916914%2C929117%2C929121%2C929906%2C929907%2C929922%2C929127%2C929129%2C929131%2C929930%2C936403%2C925726%2C925720%2C925722%2C925718%2C929917%2C906945%2C929933%2C920302%2C906842%2C913428%2C920605%2C919811%2C913563%2C904830%2C919373%2C930803%2C904122%2C932211%2C938701%2C936308%2C909549%2C900816%2C912711%2C904494%2C904497%2C900375%2C906001&mt=1377888632&sver=3&itag=34&id=b83363fbfe6dcb8f&cp=U0hWTFlMUF9ITENONl9RRlRDOkd1MHNTdkJ0bmJX&upn=NcwR8nokhFc&expire=1377912232&key=yt1&factor=1.25&signature=7FFB8DF0BFB451937740F4C5F8C3EFF502C46CFE.A6F49E3816C0D9385EAC7D9A313A79C0E1B489A6&ratebypass=yes
*uDNj-_5ty48	267	512	396	480	270	29.97	29.97	h264	Music	http://r2---sn-ovgq0oxu-5goe.c.youtube.com/videoplayback?ipbits=8&sparams=cp%2Cid%2Cip%2Cipbits%2Citag%2Cratebypass%2Csource%2Cupn%2Cexpire&mv=m&ip=86.50.94.176&source=youtube&ms=au&fexp=931311%2C916903%2C916713%2C916612%2C919515%2C913818%2C923434%2C916914%2C929117%2C929121%2C929906%2C929907%2C929922%2C929127%2C929129%2C929131%2C929930%2C936403%2C925726%2C925720%2C925722%2C925718%2C929917%2C906945%2C929933%2C920302%2C906842%2C913428%2C920605%2C919811%2C913563%2C904830%2C919373%2C930803%2C904122%2C932211%2C938701%2C936308%2C909549%2C900816%2C912711%2C904494%2C904497%2C900375%2C906001&ratebypass=yes&mt=1377888632&sver=3&itag=18&id=b83363fbfe6dcb8f&expire=1377912232&upn=NcwR8nokhFc&key=yt1&cp=U0hWTFlMUF9ITENONl9RRlRDOkd1MHNTdkJ0bmJX&signature=187482B3F497A03D2FA9E03FF0D540C9801DF2E5.88F8505D8378874858DE9712197A6E7876F2E708
* 
* ii.split the rows using tab ("\t") delimiter
* 
* iii.Remove the header record by filtering the first column value does not contains "id" into an rdd splitrdd
*
* iv.display only first 10 rows in the screen from splitrdd.
* 
* v.filter only Music category data from splitrdd into an rdd called music
* 
* 
* vi.filter only duration>100 data from splitrdd into an rdd called longdur
* 
* 
* vii.Union music and longdur rdd and find only distinct records into an rdd music_longdur
* 
* 
* viii.Select only id, duration, codec and category by re ordering the fields like 
*id,category,codec,duration into an rdd mapcolsrdd
* 
* ix.Select only duration from mapcolsrdd and find max duration by using max fuction.
* 
* x.Select only codec from mapcolsrdd, convert to upper case and print distinct of it in the screen.
* 
* 
* xi.Create an rdd called filerdd4part from filerdd created in step1 by increasing the number of 
* partitions to 4 (Execute this step anywhere in the code where ever appropriate)
* 
* xii.Persist the filerdd4part data into memory and disk with replica of 2, (Execute this step anywhere 
* in the code where ever appropriate)
* 
* xiii.Calculate and print the overall total, max, min duration for Comedy category
* 
* 
* xiv.Print the codec wise count and minimum duration not by using min function **need to see with out min function**
* 
* 
* xv.Print the distinct category of videos
* 
* xvi.Print only the id, duration, height and width sorted by duration.
* 
* xvii.Merge the rdds generated in step5 and step13.
* 
* 
* xviii.Store the step 17 result in a hdfs location in a single file with data delimited as |
* 
* 
* xix.
*Using the split rdd created in the step 2 below, create another rdd called hashmaskrdd should 
*return (id,maskedcategory) by passing id,hashMask(category) in the map method and print only 
*first 20 tuples using take.
*For Eg like this: map(x=>(x(0),hashMask(x(11))))
* 
*/
object sparkcoreobj {
  def main(args:Array[String]):Unit={
    val conf = new SparkConf().setAppName("arindam").setMaster("local[2]").set("spark.hadoop.validateOutputSpecs","false")
    val izsc = new SparkContext(conf)
        izsc.setLogLevel("ERROR")
    val youtubeRawData = izsc.textFile("file:/home/hduser/sparkdata/youtube_videos.tsv") 
    val youtubeSplitDataRdd = youtubeRawData.map(x=>x.split("\t")).map(x=>(x(0),x(1),x(2),x(3),x(4),x(5),x(6),x(7),x(8),x(9),x(10)))
    val header = youtubeSplitDataRdd.first
    //Added persist for optimization 
    val dataWithOutHeaderRdd = youtubeSplitDataRdd.filter(!_.equals(header)).filter(x=>x._1!=" ").persist(StorageLevel.MEMORY_AND_DISK_2)
    
    
    println("+++++++++++++++++++++++Solution1+++++++++++++++++++++++++++++++++")
    println("display only first 10 rows from splitrdd:: ")
        dataWithOutHeaderRdd.take(10).foreach(println)
        
      
    println("+++++++++++++++++++++++Solution2+++++++++++++++++++++++++++++++++")  
    val musicRdd = dataWithOutHeaderRdd.filter(x=>x._10.equals("Music"))
    println("Music data:: ")
        musicRdd.take(10).foreach(println)
        
    println("+++++++++++++++++++++++Solution3+++++++++++++++++++++++++++++++++")  
    val longdurRdd = dataWithOutHeaderRdd.filter(x=>x._2.toFloat > 100.00)
    println("Movies which duration is greater than 100:: ")
        musicRdd.take(10).foreach(println)
    
    println("+++++++++++++++++++++++Solution4+++++++++++++++++++++++++++++++++")    
    val music_longdurRdd = musicRdd.union(longdurRdd).distinct 
    println("Union music and longdur rdd and find only distinct records into an rdd music_longdur")
        music_longdurRdd.take(10).foreach(println)
        
        
   //Select only id, duration, codec and category by re ordering the fields like  
   //*id,category,codec,duration into an rdd mapcolsrdd   
    println("+++++++++++++++++++++++Solution5+++++++++++++++++++++++++++++++++")  
    val mapColsRdd = dataWithOutHeaderRdd.map(x=>(x._1,x._10,x._9,x._2)).repartition(4).persist(StorageLevel.MEMORY_AND_DISK_2)
    println("Select only id,category,codec,duration by re ordering the fields:: ")
        mapColsRdd.take(10).foreach(println)
        
   //Select only duration from mapcolsrdd and find max duration by using max fuction.
    println("+++++++++++++++++++++++Solution6+++++++++++++++++++++++++++++++++")  
    val maxDuration = mapColsRdd.map(x=>x._4)
    println("find max duration is:: "+" "+maxDuration.max)
    
   //Select only codec from mapcolsrdd, convert to upper case and print distinct of it in the screen.   
    println("+++++++++++++++++++++++Solution7+++++++++++++++++++++++++++++++++")  
    val codecUpperDistinct = mapColsRdd.map(x=>x._3.toUpperCase()).distinct() 
    println("Distinct of codec in upperCase:: ")
        codecUpperDistinct.take(20).foreach(println)
    
        
   //Create an rdd called filerdd4part from filerdd created in step1 by increasing the number of 
   //partitions to 4 (Execute this step anywhere in the code where ever appropriate)
   println("+++++++++++++++++++++++Solution8+++++++++++++++++++++++++++++++++")      
   val filerdd4part = youtubeRawData.repartition(4)
   println("filerdd4part o/p with no. partition 4:: ")
   
   
   //Persist the filerdd4part data into memory and disk with replica of 2, (Execute this step anywhere 
   // in the code where ever appropriate)
   
   println("+++++++++++++++++++++++Solution9+++++++++++++++++++++++++++++++++")      
   val persistRdd = filerdd4part.persist(StorageLevel.MEMORY_AND_DISK_2)
   println("persistRdd o/p:: ")
       persistRdd.take(10).foreach(println)
   
   //Calculate and print the overall total, max, min duration for Comedy category
   println("+++++++++++++++++++++++Solution10+++++++++++++++++++++++++++++++++") 
   val comedyRdd = dataWithOutHeaderRdd.filter(x=>x._10.equals("Comedy"))
   val totalDurationComedy = comedyRdd.map(x=>(x._10,x._2.toFloat)).reduceByKey(_+_)
   println("totalDuration for Comedy category:: ")
       totalDurationComedy.repartition(4).foreach(println)
   val maxDurationComedy = comedyRdd.map(x=>(x._10,x._2.toFloat)).reduceByKey((x,y)=>x.max(y))
   println("maxDuration for Comedy category:: ")
       maxDurationComedy.repartition(4).foreach(println)
   val minDurationComedy = comedyRdd.map(x=>(x._10,x._2.toFloat)).reduceByKey((x,y)=>x.min(y))
   println("minDuration for Comedy category:: ")
       minDurationComedy.repartition(4).foreach(println)
       
       
  //Print the codec wise count and minimum duration not by using min function
   println("+++++++++++++++++++++++Solution11+++++++++++++++++++++++++++++++++") 
  //  val mapColsRdd = dataWithOutHeaderRdd.map(x=>(x._1,x._10,x._9,x._2))
   //id,category,codec,duration 
   val codecCountRdd = mapColsRdd.map(x=>(x._3,x._1)).groupBy(x=>x._2).mapValues(x=>x.size)
   println("the codec wise count:: ")
        codecCountRdd.take(5).foreach(println)
        
     val minDurationCodec = mapColsRdd.map(x=>(x._3,x._4.toFloat)).reduceByKey((x,y)=>x.min(y))   
     val minDurationCodec1 = mapColsRdd.map(x=>(x._3,x._4.toFloat)).reduceByKey(minimum)   
     println("the codec wise minimum duration with default min function:: ")   
       minDurationCodec.take(5).foreach(println)
     println("the codec wise minimum duration with customized min function:: ")   
       minDurationCodec1.take(5).foreach(println)  
    
   //Print the distinct category of videos    
    println("+++++++++++++++++++++++Solution12+++++++++++++++++++++++++++++++++") 
    val distinctCategory = mapColsRdd.map(x=>x._2).distinct 
    println("the distinct category of videos:: ")
        distinctCategory.take(5).foreach(println)
        
   //Print only the id, duration, height and width sorted by duration. 
    println("+++++++++++++++++++++++Solution13+++++++++++++++++++++++++++++++++")     
    val idDurationHeightWidthSortedByDuration = dataWithOutHeaderRdd.map(x=>(x._1,x._2.toFloat,x._5,x._6)).sortBy(x=>x._2)
    println("print only the id, duration, height and width sorted by duration")
        idDurationHeightWidthSortedByDuration.take(5).foreach(println)
        
    
    //    musicRdd + comedyRdd
    //Merge the rdds generated in step5 and step13.    
    println("+++++++++++++++++++++++Solution14+++++++++++++++++++++++++++++++++")  
    val mergeRdd = musicRdd.union(comedyRdd)
    println("mergeRdd 10 rows op:: ")
        mergeRdd.take(10).foreach(println)
 
    //Store the step 17 result in a hdfs location in a single file with data delimited as |    
    println("+++++++++++++++++++++++Solution15+++++++++++++++++++++++++++++++++")  
    mergeRdd.map(x=>List(x._1,x._2,x._3,x._4,x._5,x._6,x._7,x._8,x._9,x._10).mkString("|")).saveAsTextFile("hdfs://localhost:54310/user/hduser/sparkUsecase")
    
   
    
    
 /*
*Using the split rdd created in the step 2 below, create another rdd called hashmaskrdd should 
*return (id,maskedcategory) by passing id,hashMask(category) in the map method and print only 
*first 20 tuples using take.
*For Eg like this: map(x=>(x(0),hashMask(x(11))))
*/
    println("+++++++++++++++++++++++Solution16+++++++++++++++++++++++++++++++++")   
    val hashmaskrdd=youtubeSplitDataRdd.map(x=>(x._1,hashMask(x._10)))
        hashmaskrdd.take(20).foreach(println)
    /*
     * unpersist all the rdd othewise it might create some problem
     */
     dataWithOutHeaderRdd.unpersist()
     persistRdd.unpersist()
     mapColsRdd.unpersist()
        
  }
  
  def minimum(x:Float,y:Float):Float={
    if(x<y)
    x
    else
    y  
    
  }
  
  def hashMask(category:String):String={
    return category.hashCode().toString()
  }
  
}
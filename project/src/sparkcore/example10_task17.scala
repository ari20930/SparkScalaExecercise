package sparkcore
import org.apache.spark.{SparkContext,SparkConf}
/*
 * DATATASK-17
 * You have given file spark10/sales.txt below:-
 *spark10/sales.txt
 *Department,Designation,costToCompany,State
 *Sales,Trainee,12000,UP
 *Sales,Lead,32000,AP
 *Sales,Lead,32000,MH
 *Sales,Lead,32000,TN
 *Sales,Lead,32000,AP
 *Sales,Lead,32000,TN 
 *Sales,Lead,32000,MH
 *Sales,Lead,32000,MH
 *Marketing,Associate,18000,TN
 *Marketing,Associate,18000,TN
 *HR,Manager,58000,TN
 * 
 *Accomplish the following:-
 *
 *Produce the output as csv with group by department,designation,state and additional column with sum(costToCompany) and 
 *TotalEmployeeCount
 *
 *Should get results like
 *
 *Dept,Desg,State,empcount,totalcost
 *Sales,Lead,AP,2,64000
 *Sales,Lead,MH,3,96000
 *Sales,Lead,TN,2,64000
 * 
 */
object example10_task17 {
  def main(args:Array[String])={
    val sc = new SparkContext(new SparkConf().setAppName("task17").setMaster("local"))
    sc.setLogLevel("ERROR")
    val filerdd = sc.textFile("file:/home/hduser/sparkFileExcercise1/sales.txt")
    val header = filerdd.first()
    val values = filerdd.filter(x=> x != header)
    
    //getGroupBySales()
    //getGroupBy
    
   
  }
}
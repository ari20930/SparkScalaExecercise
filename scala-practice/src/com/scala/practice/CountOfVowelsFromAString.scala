package com.scala.practice

object CountOfVowelsFromAString {
  def main(args:Array[String]):Unit={
val str="This is a string"
val charElement=str.toArray
var count =0
for(i<-charElement)
{
if(i=='a'||i=='e'||i=='i'||i=='o'||i=='u'||i=='A'||i=='E'||i=='I'||i=='O'||i=='U')
{
count+=1
println("elements which are vowels are:: "+i)
}
}


println("total no. of vowels in a string is:: "+ count)
    
  }
}
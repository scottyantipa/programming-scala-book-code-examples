// src/extra/scala/progscala3/bigdata/SparkWordCount.scala
package bigdata
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object SparkWordCount {
  def main(args: Array[String]) = {
    val sc = new SparkContext("local", "Word Count (2)")             // <1>
    val input = sc.textFile(args(0)).map(_.toLowerCase)              // <2>
    input
      .flatMap(line => line.split("""\W+"""))                        // <3>
      .map(word => (word, 1))                                        // <4>
      .reduceByKey((count1, count2) => count1 + count2)              // <5>
      .saveAsTextFile(args(1))                                       // <6>
    sc.stop()                                                        // <7>
  }
}

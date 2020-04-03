package KPIOperation

import org.apache.spark.sql.SparkSession


object QueryMain {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
                .builder()
                .master("local[*]")
                .config("spark.cassandra.connection.host", "localhost")
                .config("spark.executor.memory", "871859200")
                .config("spark.executor.cores", "3")
                .appName("cassandra_query")
                .getOrCreate()

    val cassandraDf = spark
                .read
                .format("org.apache.spark.sql.cassandra")
                .option("keyspace", "zambia")
                .option("table", "two_cssr")
                .load()
//                .filter("siteacceptancestatus='ACCEPTED'")

    cassandraDf.createTempView("two_cssr")
    val filterDf = spark.sql("select * from two_cssr")
    println(filterDf.count())

    spark.close()
  }

}

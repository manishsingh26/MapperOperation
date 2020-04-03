package KPIOperation

import java.io.File

import com.typesafe.config.Config
import org.apache.spark.sql.SparkSession
import KPIOperation.SchemaMapping
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.types.StructType

class DataPush(appConfig: Config) {

//  val rootPath = appConfig.getString("root_path")
//  val getInputDirPath = rootPath + File.separator + appConfig.getConfig("input").getString("input_path")

  def pushCSV(): Unit ={

//    val fileObj = new File(getInputDirPath)
//    val pathArray = fileObj.listFiles.filter(_.isFile).filter(_.getName.endsWith(".csv")).map(_.getPath).toList
    val customFile = "C:\\Users\\m4singh\\IdeaProjects\\CassendraOperation\\DataFlow\\input\\ZM_2G_WCL_v2.06_%_CSSR.csv"
//    val schemaMapper : StructType = new SchemaMapping("ZM", "2G").schemaMatchFunction()

    val spark = SparkSession
                .builder()
                .master("local[*]")
                .config("spark.cassandra.connection.host", "localhost")
                .appName("csv_to_cassandra")
                .getOrCreate()

    val conf = new SparkConf()
    val sc = new SparkContext(conf)
    val df = spark
              .read
              .format("com.databricks.spark.csv")
              .option("header", "true")
//              .schema(schemaMapper)
              .option("inferSchema", "true")
              .load(customFile)
    val df_new = df.filter("dateindex is not null")
//    df_new.persist()
//    sc.broadcast(df_new)

    df_new.write
      .format("org.apache.spark.sql.cassandra")
      .mode("overwrite")
      .option("confirm.truncate","true")
      .option("spark.cassandra.connection.host","localhost")
      .option("spark.cassandra.connection.port","9042")
      .option("keyspace","zambia")
      .option("table","two_cssr")
      .save()

    spark.close()
  }

}

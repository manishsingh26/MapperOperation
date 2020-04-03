package KPIOperation

import org.apache.spark.sql.SparkSession

object ParsingMain {

  def main(args: Array[String]): Unit = {

    val excelFilePath = "C:\\Users\\m4singh\\IdeaProjects\\CassendraOperation\\DataFlow\\raw_input\\ZM_2G_WCL_v2.06.xlsb"

    val spark = SparkSession.builder()
                            .master("local[*]")
                            .appName("excel_parsing")
                            .getOrCreate()
    val df = spark.read
      .format("com.crealytics.spark.excel")
      .option("dataAddress", "'CSSR'!A5:BP3964") // Optional, default: "A1"
      .option("useHeader", "true") // Required
      .option("treatEmptyValuesAsNulls", "false") // Optional, default: true
      .option("inferSchema", "false") // Optional, default: false
      .option("addColorColumns", "false") // Optional, default: false
      .option("timestampFormat", "MM-dd-yyyy HH:mm:ss") // Optional, default: yyyy-mm-dd hh:mm:ss[.fffffffff]
      .option("maxRowsInMemory", 20) // Optional, default None. If set, uses a streaming reader which can help with big files
      .option("excerptSize", 10) // Optional, default: 10. If set and if schema inferred, number of rows to infer schema from
      .option("workbookPassword", "pass") // Optional, default None. Requires unlimited strength JCE for older JVMs
//      .schema(myCustomSchema) // Optional, default: Either inferred schema, or all columns are Strings
      .load(excelFilePath)
    df.show()

    spark.close()
  }

}

package KPIOperation

import KPIOperation.MapperFunction.IndexMapper
import org.apache.spark.sql.types.StructType

class SchemaMapping(customer: String, technology: String) {

  def schemaMatchFunction(): StructType ={
    val schemaObj = new IndexMapper()
    val mapperConcat = customer + technology

    val schema = mapperConcat match {
      case "ZM2G" => schemaObj.zambia4G()
    }
    schema
  }
}

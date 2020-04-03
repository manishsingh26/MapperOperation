package KPIOperation

import java.io.File

import com.typesafe.config.ConfigFactory

import KPIOperation.DataPush

object PushMain {

  def main(args: Array[String]): Unit = {

    val appConfigPath = new File("C:\\Users\\m4singh\\IdeaProjects\\CassendraOperation\\src\\main\\scala\\resources\\app.conf")
    val appConfig = ConfigFactory.parseFile(appConfigPath)

    val obj = new DataPush(appConfig)
    obj.pushCSV()
  }

}

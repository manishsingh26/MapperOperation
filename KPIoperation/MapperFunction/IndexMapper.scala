package KPIOperation.MapperFunction

import org.apache.spark.sql.types.{StringType, StructField, StructType}

class IndexMapper {

  def zambia4G(): StructType ={
    val schema = StructType(Array(StructField("cellid", StringType, nullable = true),
                                  StructField("cellname", StringType, nullable = true),
                                  StructField("superplatinum", StringType, nullable = true),
                                  StructField("bsc", StringType, nullable = true),
                                  StructField("rfengineer", StringType, nullable = true),
                                  StructField("showcase", StringType, nullable = true),
                                  StructField("leavethiscolumnblank", StringType, nullable = true),
                                  StructField("neededduringhqautomationleaveblank", StringType, nullable = true),
                                  StructField("occurrence14days", StringType, nullable = true),
                                  StructField("avg142", StringType, nullable = true),
                                  StructField("absnoofassignmentfailures", StringType, nullable = true),
                                  StructField("occurrence3days", StringType, nullable = true),
                                  StructField("analysis", StringType, nullable = true),
                                  StructField("additionalobservation", StringType, nullable = true),
                                  StructField("actionplanned", StringType, nullable = true),
                                  StructField("issueanalysisbucket", StringType, nullable = true),
                                  StructField("responsibility", StringType, nullable = true),
                                  StructField("status", StringType, nullable = true),
                                  StructField("previousanalysisandactiondone", StringType, nullable = true),
                                  StructField("targetdatetoclose", StringType, nullable = true),
                                  StructField("actualclosureddate", StringType, nullable = true),
                                  StructField("incomingwclallcellsptr", StringType, nullable = true),
                                  StructField("incomingwclallcells", StringType, nullable = true),
                                  StructField("outgoingwclallcells", StringType, nullable = true),
                                  StructField("lastdatekpinotmetautomated", StringType, nullable = true),
                                  StructField("occurrence31days", StringType, nullable = true),
                                  StructField("incomingwclcell", StringType, nullable = true),
                                  StructField("outgoingwclwclcell", StringType, nullable = true),
                                  StructField("occurrence31daysallcells", StringType, nullable = true),
                                  StructField("occurrence31daysallcellsptr", StringType, nullable = true),
                                  StructField("date1absnoofassignmentfailures", StringType, nullable = true),
                                  StructField("actualclosedcomment", StringType, nullable = true),
                                  StructField("siteacceptancestatus", StringType, nullable = true),
                                  StructField("modernizedstatus", StringType, nullable = true),
                                  StructField("tttaskid", StringType, nullable = true),
                                  StructField("zictacells", StringType, nullable = true),
                                  StructField("dateindex", StringType, nullable = false),
                                  StructField("kpivalue", StringType, nullable = true)))
    schema
  }

}

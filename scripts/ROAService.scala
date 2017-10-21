val configuration = new Configuration()
val sqlContext = new SQLContext(sc)
import sqlContext.implicits._

//Condition setting
val startTM = args(0).toString()
val entTM = args(1).toString()
val fab = args(2).toString()
val lotCd = args(3).toString()
val oper = "'" + args(4).toString().replace(",", "','") + "'"
val paramDirection = args(5).toString()
val paramMethod = args(6).toStirng()
val paramWindowSize = args(7).toString().toInt
val paramCorrMethod = args(8).toString()
val paramCorrMinMeasureCount = args(9).toString().toInt
val paramCorrMinCorrValue = args(10).toString()
val paramGroup = args(11).toString()
val numPartition = args(12).toString().toInt
val targetOper = args(4).toString().split(",")(0)
val nameOfResCol = Seq("FAB","LOT_CD","AREA_CD","MAIN_OPER","OPER","OPER_DESC","PRMT_NM","CORR","TYPE","KEYS","CODE")
val totalCol = Seq("DATA","RAWKEY")

val df = sqlContext.poenixTableAsDataFrame("QDW.ROA_REPWFSITE_HIS",
                                           Array("TM_KEY",
                                                 "FAB",
                                                 "LOT_CD",
                                                 "OPER",
                                                 "MAIN_OPER",
                                                 "PRMT_NM",
                                                 "ALIAS_LOT_ID",
                                                 "WF_ID",
                                                 "SITE_SEQ",
                                                 "CHMBR_NM",
                                                 "UNIT_ID",
                                                 "MSURE_VAL",
                                                 "REAL_MSURE_YN",
                                                 "LOT_ID",
                                                 "AREA_CD",
                                                 "OPER_DESC"),
                                           predicate = Some("TM_KEY BETWWEN '%s' and '%s' and LOT_CD = '%s' and OPER IN (%s)".format(starTM,endTM,fab,lotCd,Oper)),
                                           conf = configuration)



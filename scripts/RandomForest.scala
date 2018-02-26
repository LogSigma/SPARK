class RandomForestAnalysis extends Serializable with ModelService{
  def evaluate(sc: SparkContext, df: DataFrame, args: Array[(Object)]): DataFrame = {
  
    val sqlContext - new SQLContet(sc)
    import sqlContext.implicits._
    val configuration - new Configuration()
    
    configuration.set("hbase.zookeeper.quorum",args(0).toString())
    configuration.set("hbase.zookeeper.property.clientPort","2181")
    
    val jsonString = args(3).toString()
    
    val lot = sc.parallelize(jsonString :: Nil)
    val schema = (new StructType).add("ALIAS_LOT_WF_ID",StringType).add("LABEL",StringType)
    val lotdf = sqlContext.read.schema(schema).json(lot)
    
    
  }
}

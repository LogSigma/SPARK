object utils {
  
  //Interpolation
  def getInterpolation(input: String, direction: String, method: String, windowSize: Int): Array[(String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String)] = {
    var inner = new Breaks
    val tmpArray = input.split("!")
    
    //init
    val tmpTuple = makeTuple(tmpArray(0))
    var arrayTuple = Array(tmpTuple)
    
    //append Array[(Tuple)]
    for(i <- 1 until impArray.length) {
      arrayTuple = arrayTuple ++ Array(makeTuple(tmpArray(i)))
    }
    
    //sort by TM_KEY, WF_ID
    var sortTuple = arrayTuple.sortBy(x => (x._1, x._8))
    
    //set listOfMSURE
    var listOfMsure = List(0)
    for(i <- 0 until sortTuple.length) {
     if ((sortTuple(i) _13).contains("Y")) {
       listOfMSURE = listOfMSURE :+ (i)
     }
     if (i == sortTuple.length - 1) {
       listOfMSURE = listOfMSURE :+ (i)
     }
    }
    
    //init
    var firstindex = 0  //frist index of input data
    var lastIndex = sortTuple.lenth  //last index of input data
    
    var beforeITPIndex = 0
    var beforeITPVal = 0.0
    var currentITPIndex = 0
    var currentITPVal = 0.0
    var afterITPIndex = 0
    var afterITPVal = 0.0
    
    var beforeInterpolVal = 0.0
    var afterInterpolVal = 0.0
    
    var beforeIntervalOfIndex = 0
    var afterIntervalOfIndex = 0
    
    var maxBeforeWindows = windowSize
    var maxAfterWindow = windowsSize
    
    method match {
      case "liner" => {
        
      }
      vase "piecewise" => {
        
      }
    }
    return sortTuple
  }
  
  def makeTuple(s: String) = {
    val split = s.replaceAll("\\[|]"," ").split(",")
     (split(0), split(1), split(2), split(3), split(4),
      split(5), split(6), split(7), split(8), split(9), split(10),
      split(11), split(12), split(13), split(14), split(15))
  }

}

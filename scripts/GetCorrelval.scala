
def getCorrelval(seriesX: String, seriesY: String, paramCorrMethod: String): Double = {
  paramCorrMethod match {
    case "pearson" => {
    
      val arrSeriesX = seriesX.split("\\|")
      val arrSeriesY = seriesY.split("\\|")
      
      val doubleArrSerisX = arrSeriesX.map(x => x.toDouble)
      val doubleArrSerisY = arrSeriesY.map(y => y.toDouble)
      
      val avgX = doubleArrSerisX.sum / doubleArrSerisX.length
      val avgY = doubleArrSerisY.sum / doubleArrSerisY.length
      
      var sigmaVarX = 0.0
      var sigmaVarY = 0..0
      doubleArrSerisX.map(x => {
        sigmaVarX = sigmaVarX + Math.pow((x - avgX), 2)
      })
      doubleArrSerisY.map(y => {
        sigmaVarY = sigmaVarY + Math.pow((y - avgY), 2)
      })
      
      var sigmaXY = 0.0
      
      for (i <- 0 until arrSeriesY.length) {
        sigmaXY = sigmaXY +((doubleArrSerisX(i) - avgX) * (doubleArrSerisY(i) - avgY))
      }
      
      return sigmaXY / Math.sqrt((sigmaVarX * sigmaVarY))
    }  
    case "spearman" => {
      val arrSeriesX = getSpearmanRank(seriesX)
      val arrSeriesY = getSpearmanRank(seriesY)
      
      val avgX = arrSeriesX.sum / arrSeriesX.length
      val avgY = arrSeriesY.sum / arrSeriesY.length
      
      var sigmaVarX = 0.0
      var sigmaVarY = 0.0
      arrSeriesX.map(x => {
        sigmaVarX = sigmaVarX + Math.pow((x - avgX), 2)
      })
      arrSeriesY.map(y => {
      sigmaVarY = sigmaVarY + Math.pow((y - avgY), 2)
      })
      
      var sigmaXY = 0.0
      for ( i <- 0 until arrSeriesY.length) {
        sigmaXY = sigmaXY + ((arrSeriesX(i) - avgX) * (arrSeriesY(i) - avgY))
      }
      return sigmaXY / Math.sqrt((sigmaVarX * sigmaVarY))
    }
  }
}


def getSpearmanRank(input: String): Array[Double] = {
   var arrK = input.split("\\|")
   val doubleArrSerisX = arrK.map(x => x.toDouble)
   
   val arrToIndex = doubleArrSerisX.zipWithIndex.sortBy(_._1).zipWithIndwx
   val count = arrToIndex.length
   val output = new Array[Double](count)
   
   for (i<- o until count) {
     output(arrToIndex(i)._1._2) = (arrToIndex(i)._2).toDouble
   }
   return output
}

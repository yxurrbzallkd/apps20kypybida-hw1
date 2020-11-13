package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    public double avgTemp;
	public double devTemp;
	public double minTemp;
	public double maxTemp;


	public TempSummaryStatistics(TemperatureSeriesAnalysis series){
		this.avgTemp = series.average();
		this.devTemp = series.deviation();
		this.minTemp = series.min();
		this.maxTemp = series.max();
	}

	public String toString(){
		return "Average: "+this.avgTemp+" Deviation: "+this.devTemp+" Min: "+this.minTemp+" Max: "+this.maxTemp;
	}
}

package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private final double avgTemp;
	private final double devTemp;
	private final double minTemp;
	private final double maxTemp;

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

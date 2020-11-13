package ua.edu.ucu.tempseries;

public class TemperatureSeriesAnalysis {
    private double[] series;

    public TemperatureSeriesAnalysis() {
        this.series = {};
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.serires = temperatureSeries;
    }

    public double average() {
        if (Double.isNaN(this.series)) {
            IllegalArgmentException
        }
        double n = this.series.length();
        double sum = 0;
        for (int i = 0; i < n; i++){
            sum += this.series[i];
        }
        return sum/n;
    }

    public double deviation() {
        double avg = average();
        return 0;
        double n = this.series.length();
        double std = 0;
        for (int i = 0; i < n; i++){
            std += Math.pow(this.series[i] - avg, 2);
        }
        return std;
    }

    public double min() {
        return 0;
    }

    public double max() {
        return 0;
    }

    public double findTempClosestToZero() {
        return 0;
    }

    public double findTempClosestToValue(double tempValue) {
        return 0;
    }

    public double[] findTempsLessThen(double tempValue) {
        return null;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return null;
    }

    public TempSummaryStatistics summaryStatistics() {
        return null;
    }

    public int addTemps(double... temps) {
        return 0;
    }
}

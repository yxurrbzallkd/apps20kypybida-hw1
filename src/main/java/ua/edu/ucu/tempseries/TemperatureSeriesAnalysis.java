package ua.edu.ucu.tempseries;
import java.util.Arrays;

public class TemperatureSeriesAnalysis{
    private double[] series;
    private int size;

    public TemperatureSeriesAnalysis(){
        this.series = new double[1];
        this.size = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries){
        this.series = temperatureSeries;
        this.size = temperatureSeries.length;
    }

    public boolean empty(){
        return this.series == null;
    }

    public double average() throws IllegalArgumentException{
        if (this.empty()){
            throw new IllegalArgumentException("Empty series doesn't have an average");
        }
        double sum = 0;
        for (int i = 0; i < this.size; i++){
            sum += this.series[i];
        }
        return sum/this.size;
    }

    public double deviation() throws IllegalArgumentException{
        if (this.empty()){
            throw new IllegalArgumentException("Empty series cann't have a standard deviation");
        }
        double avg = average();
        double std = 0;
        for (int i = 0; i < this.size; i++){
            std += Math.pow(this.series[0] - avg, 2);
        }
        return std/this.size;
    }

    public double min() throws IllegalArgumentException{
        if (this.empty()){
            throw new IllegalArgumentException("Empty series can't have a standard deviation");
        }
        double min = this.series[0];
        for (int i = 1; i < this.size; i++){
            if (this.series[i] < min){
                min = this.series[i];
            }
        }
        return min;
    }

    public double max() throws IllegalArgumentException{
        if (this.empty()){
            throw new IllegalArgumentException("Empty series doesn't have a standard deviation");
        }
        double max = this.series[0];
        for (int i = 0; i < this.size; i++){
            if (this.series[i] > max){
                max = this.series[i];
            }
        }
        return max;
    }

    public double findTempClosestToZero() throws IllegalArgumentException{
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) throws IllegalArgumentException{
        if (this.empty()) {
            throw new IllegalArgumentException("Empty series doesn't have a standard deviation");
        }
        double closest = this.series[0];
        for (int i = 1; i < this.size; i++){
            if (Math.abs(this.series[i] - tempValue) < Math.abs(closest - tempValue)){
                closest = this.series[i];
            }
            else if (Math.abs(this.series[i] - tempValue) == Math.abs(closest-tempValue)){
                if (this.series[i] > closest){
                    closest = this.series[i];
                }
            }
        }
        return closest;
    }

    private void expand() {
        double[] newSeries = new double[2*this.series.length];
        for (int i = 0; i < this.size; i++){
            newSeries[i] = this.series[i];
        }
        this.series = newSeries;
    }

    public double[] findTempsLessThen(double tempValue){
        double[] smaller = new double[this.size];
        int j = 0;
        for (int i = 0; i < this.size; i++){
            if (this.series[i] < tempValue){
                smaller[j] = this.series[i];
                j += 1;
            }
        }
        return Arrays.copyOf(smaller, j);
    }

    public double[] findTempsGreaterThen(double tempValue){
        double[] larger = new double[this.size];
        int j = 0;
        for (int i = 0; i < this.size; i++){
            if (this.series[i] > tempValue){
                larger[j] = this.series[i];
                j += 1;
            }
        }
        return Arrays.copyOf(larger, j);
    }

    public TempSummaryStatistics summaryStatistics() throws IllegalArgumentException{
        if (empty()){
            throw new IllegalArgumentException("Can't provide statistics on empty series");
        }
        return new TempSummaryStatistics(this);
    }

    public int addTemps(double... temps) throws IllegalArgumentException{
        if (empty()){
            throw new IllegalArgumentException("Can't provide statistics on an empty series");
        }
        for (double t:temps){
            if (this.size > this.series.length - 1){
                expand();
            }
            this.series[this.size] = t;
            this.size += 1;
        }
        return 1;
    }
    public String toString() throws IllegalArgumentException{
        if (empty()){
            throw new IllegalArgumentException("Can't provide statistics on an empty series");
        }
        return "TempSeries "+Arrays.toString(this.series);
    }
}

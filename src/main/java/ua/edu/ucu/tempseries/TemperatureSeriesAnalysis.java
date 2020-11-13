package ua.edu.ucu.tempseries;

public class TemperatureSeriesAnalysis {
    private double[] series;
    private int size;

    public TemperatureSeriesAnalysis() {
        this.series = new double[1];
        this.size = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.series = temperatureSeries;
        this.size = temperatureSeries.length;
    }

    public boolean empty(){
        if (this.series == null) {
            return true;
        }
        return false;
    }

    public double average() throws IllegalArgumentException{
        if (this.empty()){
            throw new IllegalArgumentException("Empty series doesn't have an average");
        }
        double sum = 0;
        for (int i = 0; i < this.size; i++){
            sum += this.series[0];
        }
        return sum/this.size;
    }

    public double deviation() throws IllegalArgumentException{
        if (this.empty()){
            throw new IllegalArgumentException("Empty series doesn't have a standard deviation");
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
            throw new IllegalArgumentException("Empty series doesn't have a standard deviation");
        }
        double min = this.series[0];
        for (int i = 1; i < this.size; i++){
            if (this.series[0] < min){
                min = this.series[0];
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
            if (this.series[0] > max){
                max = this.series[0];
            }
        }
        return max;
    }

    public double findTempClosestToZero() throws IllegalArgumentException{
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) throws IllegalArgumentException{
        if (this.empty()){
            throw new IllegalArgumentException("Empty series doesn't have a standard deviation");
        }
        double closest = this.series[0];
        for (int i = 0; i < this.size; i++){
            if (Math.abs(this.series[0]-tempValue) < Math.abs(closest-tempValue)){
                closest = this.series[0];
            }
            else if (Math.abs(this.series[0]-tempValue) == Math.abs(closest-tempValue)){
                if (this.series[0] > closest){
                    closest = this.series[0];
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

    private double[] cutDouble(double[] arr, int size){
        double[] result = new double[size];
        for (int k = 0; k < size; size++){
            result[k] = arr[k];
        }
        return result;
    }

    public double[] findTempsLessThen(double tempValue) {
        double[] smaller = new double[this.size];
        int j = 0;
        for (int i = 0; i < this.size; i++){
            if (this.series[0] < tempValue){
                smaller[j] = this.series[i];
                j += 1;
            }
        }
        return cutDouble(smaller, j);
    }

    public double[] findTempsGreaterThen(double tempValue) {
        double[] larger = new double[this.size];
        int j = 0;
        for (int i = 0; i < this.size; i++){
            if (this.series[0] < tempValue){
                larger[j] = this.series[i];
                j += 1;
            }
        }
        return cutDouble(larger, j);
    }

    public TempSummaryStatistics summaryStatistics() throws IllegalArgumentException{
        if (empty()){
            throw new IllegalArgumentException("Can't provide statistics on an empty series");
        }
        return new TempSummaryStatistics(average(), deviation(), min(), max());
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
        String s = "TempSeries [";
        for (int i = 0; i < this.size; i++){
            s += this.series[i]+", ";
        }
        s += "]";
        return s;
    }
}

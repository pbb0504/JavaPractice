import java.util.ArrayList;
import java.util.List;

/**
 * @author: pbb
 * @date: 2020/8/25 21:14
 */
public class StatisticsDisplay implements Observer,DisplayElement{
    private List<Float> temperature = new ArrayList<>();
    private List<Float> humidity = new ArrayList<>();
    private List<Float> pressure = new ArrayList<>();
    private Subject weatherData;

    StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("statistic \n"
                + "temperatureMax: " + statisticAnalysisForMax(temperature) +"\n"
                + "temperatureMin: " + statisticAnalysisForMin(temperature) +"\n"
                + "humidityMax: " + statisticAnalysisForMax(humidity) + "\n"
                + "humidityMin: " + statisticAnalysisForMin(humidity) + "\n"
                + "pressureMax: " + statisticAnalysisForMax(pressure) + "\n"
                + "pressureMin: " + statisticAnalysisForMin(pressure) + "\n");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature.add(temp);
        this.humidity.add(humidity);
        this.pressure.add(pressure);
        display();
    }

    public float statisticAnalysisForMax(List<Float> data) {
        float max = data.get(0);
        for (Float datum : data) {
            if(max < datum){
                max = datum;
            }
        }
        return max;
    }

    public float statisticAnalysisForMin(List<Float> data) {
        float min = data.get(0);
        for (Float datum : data) {
            if(min > datum){
                min = datum;
            }
        }
        return min;
    }
}

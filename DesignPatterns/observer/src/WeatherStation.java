
/**
 * @author: pbb
 * @date: 2020/8/25 21:55
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay ccd = new CurrentConditionDisplay(weatherData);
        StatisticsDisplay sd = new StatisticsDisplay(weatherData);
        weatherData.setMeasurements(37,50,1.2f);
        weatherData.setMeasurements(38,51,1.4f);
        weatherData.setMeasurements(39,52,1.5f);
    }
}

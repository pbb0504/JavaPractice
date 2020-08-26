/**
 * @author: pbb
 * @date: 2020/8/26 10:32
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        GeneralDisplay gd = new GeneralDisplay(weatherData);
        weatherData.setMeasurement(13F,24F,2F);
    }
}

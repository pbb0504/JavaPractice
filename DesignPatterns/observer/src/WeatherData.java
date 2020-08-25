import java.util.ArrayList;
import java.util.List;

/**
 * @author: pbb
 * @date: 2020/8/24 22:55
 */
public class WeatherData implements Subject{
    private List<Observer> observers;
    private Float temperature;
    private Float humidity;
    private Float pressure;
    WeatherData(){
        observers = new ArrayList<>();
    }
    /**
     * 获取温度
     */
    float getTemperature() {
        return temperature;
    }

    /**
     * 获取湿度
     */
    float getHumidity() {
        return humidity;
    }

    /**
     * 获取气压
     */
    float getPressure() {
        return pressure;
    }

    public void measurementChanged() {
        notifyObserver();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(temperature,humidity,pressure);
        }
    }
}

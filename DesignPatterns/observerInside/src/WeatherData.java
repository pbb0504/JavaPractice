import java.util.Observable;

import java.util.Observer;

/**
 * @author: pbb
 * @date: 2020/8/26 9:59
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    // 父类中已经有Observer列表了  实际上是vector
    void setMeasurement(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }

    void measurementChanged(){
        setChanged();
        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}

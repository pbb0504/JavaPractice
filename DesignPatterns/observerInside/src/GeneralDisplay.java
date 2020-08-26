import java.util.Observable;
import java.util.Observer;

/**
 * @author: pbb
 * @date: 2020/8/26 9:59
 */
public class GeneralDisplay implements Observer,DisplayElement {
    private Observable observable;
    private float temperature;
    private float humidity;
    private float pressure;

    GeneralDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println(temperature+humidity+pressure);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();
        }
    }
}

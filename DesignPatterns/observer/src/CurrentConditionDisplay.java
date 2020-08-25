/**
 * @author: pbb
 * @date: 2020/8/25 21:13
 */
public class CurrentConditionDisplay implements Observer,DisplayElement{
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    CurrentConditionDisplay(Subject weatherData) {
        // 构造器的使用方法
        // 在对象创建的时候就对成员变量（不局限于此）进行操作
        // 重要：初始化
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("current conditions: \n"
                + "temperature: " + temperature +"\n"
                + "humidity: " + humidity + "\n"
                + "pressure: " + pressure + "\n");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}

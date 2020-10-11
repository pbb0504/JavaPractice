/**
 * @author: pbb
 * @date: 2020/10/5 10:46
 */
public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    int speed;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    public void high() {
        speed = HIGH;
        System.out.println("now speed is high");
    }

    public void medium() {
        speed = MEDIUM;
        System.out.println("now speed is medium");
    }

    public void low() {
        speed = LOW;
        System.out.println("now speed is low");
    }

    public void off() {
        speed = OFF;
        System.out.println("now speed is off");
    }

    public int getSpeed() {
        return speed;
    }
}

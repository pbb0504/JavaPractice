/**
 * @author: pbb
 * @date: 2020/8/16 18:55
 */
public class SingleResponsibility3 {
    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.run("bicycle");

        vehicle2.fly("plane");


    }
}
/*
 * 虽然没有在类级别上做到单一职责原则，但是在方法级别上做到了
 */
class Vehicle2 {
    void run(String vehicle) {
        System.out.println(vehicle + " run");
    }

    void fly(String vehicle) {
        System.out.println(vehicle + " fly");
    }
}

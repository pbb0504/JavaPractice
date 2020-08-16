/**
 * @author: pbb
 * @date: 2020/8/16 17:27
 */
public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("car");
        vehicle.run("bicycle");
    }
}

class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " run");
    }
}

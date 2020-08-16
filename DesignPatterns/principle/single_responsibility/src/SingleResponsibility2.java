/**
 * @author: pbb
 * @date: 2020/8/16 17:27
 */
public class SingleResponsibility2 {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("bicycle");

        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("plane");


    }
}


class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " run on the road");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " fly in the sky");
    }
}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " running in the water");
    }
}
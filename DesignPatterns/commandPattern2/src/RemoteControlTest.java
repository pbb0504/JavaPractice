/**
 * @author: pbb
 * @date: 2020/10/4 12:34
 */
public class RemoteControlTest {
    public static void main(String[] args) {
        Light light = new Light();
        LightOnCommand onCommand = new LightOnCommand(light);
        LightOffCommand offCommand = new LightOffCommand(light);
        RemoteControl control = new RemoteControl();
        control.setCommands(0,onCommand,offCommand);
        control.onButtonWasPushed(0);
        control.offButtonWasPushed(0);
        control.undoButtonWasPushed();
        System.out.println(control);
    }
}

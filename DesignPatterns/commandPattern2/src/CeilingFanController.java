/**
 * @author: pbb
 * @date: 2020/10/11 19:34
 */
public class CeilingFanController {
    public static void main(String[] args) {
        RemoteControl control = new RemoteControl(2);
        CeilingFan ceilingFan = new CeilingFan("111");
        Command ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        Command ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        Command ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
        control.setCommands(0,ceilingFanHigh,ceilingFanOff);
        control.setCommands(1,ceilingFanMedium,ceilingFanOff);
        control.onButtonWasPushed(0);
        control.offButtonWasPushed(0);
        control.onButtonWasPushed(1);
        control.undoButtonWasPushed();
    }
}

/**
 * @author: pbb
 * @date: 2020/10/4 10:54
 */
public class SimpleRemoteControllerTest {
    public static void main(String[] args) {
        Command command = new LightOnCommand(new Light());
        SimpleRemoteControl control = new SimpleRemoteControl(command);
        control.buttonWasPressed();
    }
}

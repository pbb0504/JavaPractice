/**
 * @author: pbb
 * @date: 2020/10/4 10:44
 */
public class SimpleRemoteControl {
    Command command;
    SimpleRemoteControl(Command command){
        this.command = command;
    }
    public void buttonWasPressed(){
        command.execute();
    }
}

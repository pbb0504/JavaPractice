/**
 * @author: pbb
 * @date: 2020/10/4 11:00
 */
public class GarageDoorOpenCommand implements Command {
    GarageDoor garageDoor;

    GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.open();
    }
}

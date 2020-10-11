/**
 * @author: pbb
 * @date: 2020/10/5 10:51
 */
public class CeilingFanLowCommand implements Command{
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    CeilingFan ceilingFan;
    int preSpeed;

    CeilingFanLowCommand(CeilingFan ceilingFan){
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.low();
        preSpeed = ceilingFan.getSpeed();
    }

    @Override
    public void undo() {
        switch (preSpeed){
            case HIGH: ceilingFan.high();
            break;
            case MEDIUM: ceilingFan.medium();
            break;
            case LOW: ceilingFan.low();
            break;
            case OFF: ceilingFan.off();
            break;
            default: break;
        }
    }
}

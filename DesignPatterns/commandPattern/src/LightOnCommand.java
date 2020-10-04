/**
 * @author: pbb
 * @date: 2020/10/4 10:43
 */
public class LightOnCommand implements Command {
    Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

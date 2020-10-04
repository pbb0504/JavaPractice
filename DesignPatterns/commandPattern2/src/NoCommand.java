/**
 * @author: pbb
 * @date: 2020/10/4 11:54
 */
public class NoCommand implements Command{

    @Override
    public void execute() {
        System.out.println("no command");
    }

    @Override
    public void undo() {
        System.out.println("no command");
    }
}

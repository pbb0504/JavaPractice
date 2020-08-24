package duck;

/**
 * @author: pbb
 * @date: 2020/8/24 22:22
 */
public class MuteQuack implements QuackBehavir{
    @Override
    public void quack() {
        System.out.println("mute");
    }
}

package duck;

/**
 * @author: pbb
 * @date: 2020/8/24 22:20
 */
public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("i can't fly");
    }
}

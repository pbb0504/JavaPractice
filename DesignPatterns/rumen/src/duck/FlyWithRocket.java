package duck;

/**
 * @author: pbb
 * @date: 2020/8/24 22:30
 */
public class FlyWithRocket implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("fly with rocket");
    }
}

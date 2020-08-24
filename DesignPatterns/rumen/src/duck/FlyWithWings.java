package duck;

/**
 * @author: pbb
 * @date: 2020/8/24 22:20
 */
public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("i'm flying");
    }
}

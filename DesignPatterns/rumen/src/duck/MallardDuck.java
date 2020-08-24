package duck;

/**
 * @author: pbb
 * @date: 2020/8/24 22:07
 */
public class MallardDuck extends Duck{
    MallardDuck(){
        quackBehavir = new Quack();
        flyBehavior = new FlyWithWings();
    }
}

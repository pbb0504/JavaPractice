package duck;

/**
 * @author: pbb
 * @date: 2020/8/24 22:27
 */
public class ModelDuck extends Duck{
    // 这是初始的模型鸭
    ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavir = new Quack();
    }
}

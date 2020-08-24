package duck;

/**
 * @author: pbb
 * @date: 2020/8/24 22:25
 */
public class DuckSimulator {
    public static void main(String[] args) {
        /*MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.performQuack();
        mallardDuck.performFly();*/

        ModelDuck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.performQuack();
        // 现在对模型鸭进行改造，通过duck中的set方法
        modelDuck.setFlyBehavior(new FlyWithRocket());
        System.out.println("改造完成");
        modelDuck.performFly();
    }
}


/**
 * @author: pbb
 * @date: 2020/8/27 21:37
 */
public class Mocha extends CondimentDecorator{
    Beverage beverage;

    // 用一个新的引用指向原来的对象，浅拷贝
    Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }
}

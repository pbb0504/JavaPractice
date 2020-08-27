/**
 * @author: pbb
 * @date: 2020/8/27 21:42
 */
public class Whip extends CondimentDecorator {
    Beverage beverage;
    Whip(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.9;
    }
}

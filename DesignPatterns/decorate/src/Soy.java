/**
 * @author: pbb
 * @date: 2020/8/27 21:40
 */
public class Soy extends CondimentDecorator {
    Beverage beverage;

    Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.5;
    }
}

/**
 * @author: pbb
 * @date: 2020/9/5 22:22
 */
public class PizzaDian {
    SimplePizzaFactory factory;

    PizzaDian(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = factory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}

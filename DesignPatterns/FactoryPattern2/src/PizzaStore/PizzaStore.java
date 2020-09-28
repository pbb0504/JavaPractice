package PizzaStore;

/**
 * @author: pbb
 * @date: 2020/9/5 22:22
 */
public abstract class PizzaStore {

    /**
     * 制作pizza
     * @param type pizza类型
     * @return pizza
     */
    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /**
     * 创建pizza
     * @param type pizza类型
     * @return pizza
     */
    abstract Pizza createPizza(String type);
}

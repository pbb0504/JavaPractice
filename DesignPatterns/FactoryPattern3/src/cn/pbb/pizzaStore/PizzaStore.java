package cn.pbb.pizzaStore;

import cn.pbb.PizzaIngredientFactory;
import cn.pbb.abstractPizza.Pizza;

/**
 * @author: pbb
 * @date: 2020/9/30 15:52
 */
public abstract class PizzaStore {
    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza = createPizza(type);
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /**
     * create
     * @param type
     * @return
     */
    public abstract Pizza createPizza(String type);
}

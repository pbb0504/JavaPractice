package cn.pbb.pizzaStore;

import cn.pbb.PizzaIngredientFactory;
import cn.pbb.abstractPizza.Pizza;
import cn.pbb.factory.NYPizzaIngredientFactory;
import cn.pbb.pizza.CheesePizza;
import cn.pbb.pizza.ClamPizza;

/**
 * @author: pbb
 * @date: 2020/9/30 15:53
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();
        if(type.equals("cheese")){
            pizza = new CheesePizza(pizzaIngredientFactory);
            pizza.setName("cheesePizza");
            pizza.prepare();
        }else if(type.equals("clam")){
            pizza = new ClamPizza(pizzaIngredientFactory);
            pizza.setName("clamPizza");
            pizza.prepare();
        }
        return pizza;
    }
}

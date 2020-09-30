package cn.pbb.pizza;

import cn.pbb.PizzaIngredientFactory;
import cn.pbb.abstractPizza.Pizza;

/**
 * @author: pbb
 * @date: 2020/9/30 15:23
 */
public class CheesePizza extends Pizza {
    PizzaIngredientFactory pizzaIngredientFactory;

    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("preparing cn.pbb.pizza: " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
    }
}

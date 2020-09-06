package PizzaStore;

import ABPizzaStore.ABCheesePizza;
import ABPizzaStore.ABClamPizza;
import ABPizzaStore.ABPepperoniPizza;
import ABPizzaStore.ABVeggiePizza;

/**
 * @author: pbb
 * @date: 2020/9/6 9:28
 */
public class PizzaStore1 extends PizzaStore{
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equals("cheese")){
            pizza = new ABCheesePizza();
        }else if(type.equals("pepperoni")){
            pizza = new ABPepperoniPizza();
        }else if(type.equals("clam")){
            pizza = new ABClamPizza();
        }else if(type.equals("veggie")){
            pizza = new ABVeggiePizza();
        }
        return pizza;
    }
}

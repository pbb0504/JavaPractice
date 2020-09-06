package PizzaStore;

import NYPizzaStore.NYCheesePizza;
import NYPizzaStore.NYClamPizza;
import NYPizzaStore.NYPepperoniPizza;
import NYPizzaStore.NYVeggiePizza;

/**
 * @author: pbb
 * @date: 2020/9/6 9:28
 */
public class PizzaStore2 extends PizzaStore{
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equals("cheese")){
            pizza = new NYCheesePizza();
        }else if(type.equals("pepperoni")){
            pizza = new NYPepperoniPizza();
        }else if(type.equals("clam")){
            pizza = new NYClamPizza();
        }else if(type.equals("veggie")){
            pizza = new NYVeggiePizza();
        }
        return pizza;
    }
}

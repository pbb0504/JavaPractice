package cn.pbb;

import cn.pbb.pizzaStore.NYPizzaStore;

/**
 * @author: pbb
 * @date: 2020/9/30 16:13
 */
public class BuyPizza {
    public static void main(String[] args) {
        NYPizzaStore pizzaStrore = new NYPizzaStore();
        pizzaStrore.orderPizza("clam");
    }
}

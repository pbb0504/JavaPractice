package cn.pbb;

import cn.pbb.basematrial.*;

/**
 * @author 13053
 */
public interface PizzaIngredientFactory {
    /**
     * create
     *
     * @return
     */
    public Dough createDough();

    /**
     * create
     *
     * @return
     */
    public Sauce createSauce();

    /**
     * create
     *
     * @return
     */
    public Cheese createCheese();

    /**
     * create
     *
     * @return
     */
    public Veggies[] createVeggies();

    /**
     * create
     *
     * @return
     */
    public Pepperoni createPepperoni();

    /**
     * create
     *
     * @return
     */
    public Clams createClam();
}

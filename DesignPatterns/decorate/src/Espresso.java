

/**
 * @author: pbb
 * @date: 2020/8/27 21:25
 */
public class Espresso extends Beverage {

    public Espresso(){
        description = "this is Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}

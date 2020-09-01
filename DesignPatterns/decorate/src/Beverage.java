/**
 * @author: pbb
 * @date: 2020/8/27 21:17
 */
public abstract class Beverage {

    String description = "unknown beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

/**
 * @author: pbb
 * @date: 2020/9/5 22:47
 */
public class Main {
    public static void main(String[] args) {
        PizzaDian pizzaDian = new PizzaDian(new SimplePizzaFactory());
        pizzaDian.orderPizza("cheese");
    }
}

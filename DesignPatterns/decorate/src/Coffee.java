
/**
 * @author: pbb
 * @date: 2020/8/27 21:43
 */
public class Coffee {
    public static void main(String[] args) {
        // 不停地对beverage进行装饰
        Beverage beverage = new Espresso();
        System.out.println("without condiment: " + beverage.cost());
        beverage = new Mocha(beverage);
        System.out.println("with Mocha: " + beverage.cost());
        beverage = new Whip(beverage);
        System.out.println("with Mocha and Whip: " + beverage.cost());
        beverage = new Soy(beverage);
        System.out.println("with Mocha and Whip and Soy: " + beverage.cost());
    }
}

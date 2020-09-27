/**
 * @author: pbb
 * @date: 2020/9/27 22:37
 */
public class BuyHouseProxy implements BuyHouse {
    BuyHouse buyHouse;

    BuyHouseProxy(BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }

    @Override
    public void buy() {
        System.out.println("before buy");
        buyHouse.buy();
        System.out.println("after buy");
    }
}

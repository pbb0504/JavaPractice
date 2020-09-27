import java.lang.reflect.Proxy;

/**
 * @author: pbb
 * @date: 2020/9/27 22:36
 */
public class Test {
    public static void main(String[] args) {
        BuyHouse buyHouse = new BuyHouseImpl();
        BuyHouseProxy buyHouseProxy = new BuyHouseProxy(buyHouse);
        buyHouseProxy.buy();
        System.out.println("---------------------------------------");
        BuyHouse buyHouseDynamicProxy = (BuyHouse)Proxy.newProxyInstance(BuyHouse.class.getClassLoader(),
                new Class[]{BuyHouse.class},
                new DynamicProxyHandler(BuyHouse.class));
        buyHouseDynamicProxy.buy(); 
    }
}

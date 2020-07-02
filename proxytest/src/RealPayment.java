/**
 * @author: pbb
 * @date: 2020/6/18 15:54
 */
public class RealPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("我是真实类");
    }
}

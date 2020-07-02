/**
 * @author: pbb
 * @date: 2020/6/18 15:59
 */
public class Main {
    public static void main(String[] args) {
        Payment payment = new AliPay(new RealPayment());
        payment.pay();
    }
}

/**
 * @author: pbb
 * @date: 2020/6/18 15:54
 */
public class AliPay implements Payment {
    private final Payment payment;

    public AliPay(Payment payment) {
        this.payment = payment;
    }

    public void beforePay() {
        System.out.println("支付前");
    }

    @Override
    public void pay() {
        beforePay();
//        在实现此方法时，只需要管接口，并使用接口中的方法，无需管实现类的细节
        payment.pay();
        afterPay();
    }

    public void afterPay() {
        System.out.println("支付后");
    }
}

/**
 * @author: pbb
 * @date: 2020/10/12 22:27
 */
public class TurkeyAdaptor implements Duck {

    Turkey turkey;

    public TurkeyAdaptor(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quark() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}

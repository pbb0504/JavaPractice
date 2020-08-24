package duck;

/**
 * @author: pbb
 * @date: 2020/8/24 22:06
 */
public class Duck {
    FlyBehavior flyBehavior;
    QuackBehavir quackBehavir;

    void performFly() {
        flyBehavior.fly();
    }

    void performQuack() {
        quackBehavir.quack();
    }

    void swim() {
        System.out.println("swim");
    }

    void display() {
        System.out.println("i'm a duck");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavir(QuackBehavir quackBehavir) {
        this.quackBehavir = quackBehavir;
    }
}

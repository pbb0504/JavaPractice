/**
 * @author: pbb
 * @date: 2020/8/17 14:00
 */
public class Demo2 {
    public static void main(String[] args) {
        C c = new C();
        System.out.println("11-3=" + c.func1(11, 3));
        System.out.println("1-8=" + c.func1(1, 8));

        D d = new D();
        System.out.println("11-3=" + d.func3(11, 3));
        System.out.println("1-8=" + d.func3(1, 8));
        System.out.println("11+3+9=" + d.func2(11, 3));
    }
}

class Base {

}

class C extends Base {
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class D extends Base {
    private C c = new C();

    public int func1(int num1, int num2) {
        return num1 + num2;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }

    public int func3(int a, int b) {
        return this.c.func1(a, b);
    }
}

/**
 * @author: pbb
 * @date: 2020/8/17 14:00
 */
public class Demo1 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3=" + a.func1(11,3));
        System.out.println("1-8=" + a.func1(1,8));

        B b = new B();
        System.out.println("11-3=" + b.func1(11,3));
        System.out.println("1-8=" + b.func1(1,8));
        System.out.println("11+3+9="+b.func2(11,3));
    }
}

class A {
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class B extends A {
    @Override
    public int func1(int num1, int num2) {
        return num1 + num2;
    }

    public int func2(int a, int b) {
        return func1(a,b) + 9;
    }
}

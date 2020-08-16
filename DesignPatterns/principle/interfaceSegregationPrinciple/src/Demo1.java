/**
 * @author: pbb
 * @date: 2020/8/16 19:50
 */
public class Demo1 {

}

interface Itf1 {
    void func1();

    void func2();

    void func3();

    void func4();

    void func5();
}

class B implements Itf1 {

    @Override
    public void func1() {

    }

    @Override
    public void func2() {

    }

    @Override
    public void func3() {

    }

    @Override
    public void func4() {

    }

    @Override
    public void func5() {

    }
}

/**
 * A通过接口1依赖（使用）B类，只用到1、2、3方法
 */
class A {
    // 传入Itf1的实现类
    void depend1(Itf1 itf1) {
        itf1.func1();
    }

    void depend2(Itf1 itf1) {
        itf1.func2();
    }

    void depend3(Itf1 itf1) {
        itf1.func3();
    }
}

class D implements Itf1 {

    @Override
    public void func1() {

    }

    @Override
    public void func2() {

    }

    @Override
    public void func3() {

    }

    @Override
    public void func4() {

    }

    @Override
    public void func5() {

    }
}

/**
 * C通过接口1依赖（使用）D类，只用到1、4、5方法
 */
class C {
    void depend1(Itf1 itf1) {
        itf1.func1();
    }

    void depend2(Itf1 itf1) {
        itf1.func4();
    }

    void depend3(Itf1 itf1) {
        itf1.func5();
    }
}
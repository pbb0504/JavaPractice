import org.jetbrains.annotations.NotNull;

/**
 * @author: pbb
 * @date: 2020/8/16 20:18
 */
public class Demo2 {
}

interface Interface1{
    void func1();
}

interface Interface2{
    void func2();
    void func3();
}

interface Interface3{
    void func4();
    void funv5();
}

class B2 implements Interface1,Interface2{

    @Override
    public void func1() {

    }

    @Override
    public void func2() {

    }

    @Override
    public void func3() {

    }
}

class A2 {
    void depend1(Interface1 interface1){
        interface1.func1();
    }

    void depend2(Interface2 interface2){
        interface2.func2();
    }

    void depend3(Interface2 interface2){
        interface2.func3();
    }
}

class D2 implements Interface1,Interface3{

    @Override
    public void func1() {

    }

    @Override
    public void func4() {

    }

    @Override
    public void funv5() {

    }
}

class C2 {
    void depend1(Interface1 interface1){
        interface1.func1();
    }

    void depend2(Interface2 interface2){
        interface2.func2();
    }

    void depend3(Interface2 interface2){
        interface2.func3();
    }
}

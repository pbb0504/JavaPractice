package jdbc_01;

import java.util.Collections;

public class InterfaceTest {
    public static void main(String[] args) {
        School school = new School();
        school.startEat(new Student(),new Teacher(),new Parent(),new Other());
        school.startSleep(new Student(),new Teacher(),new Parent(),new Other());
        school.walk(new Student());

        School2 school2 = new School2();
        People student = new Student2();
        school2.eat(student);
        People teacher = new Teacher2();
        school2.eat(teacher);
        People parent = new Parent2();
        school2.eat(parent);
    }
}
// 不使用接口

// 如果不使用接口，在更改类的时候需要在每个需要实现它的地方都修改一遍。
// 如果实现了某个接口，那么只需要修改此类即可，因为实现的细节完全在此类中，在其他地方调用的是它实现的接口
class Student{
    public void eat2(){
        System.out.println("学生吃饭");
    }
    public void sleep(){
        System.out.println("学生睡觉");
    }
    void walk(){
        System.out.println("walk");
    }
}

class Teacher{
    public void eat(){
        System.out.println("老师吃饭");
    }
    public void sleep(){
        System.out.println("老师吃饭");
    }
}

class Parent{
    public void eat(){
        System.out.println("家长下馆子");
    }
    public void sleep(){
        System.out.println("家长住旅馆");
    }
}

class Other{
    public void eat(){
        System.out.println("asdf");
    }
    public void sleep(){
        System.out.println("kalsdkfj");
    }
}
class School{
    public void startEat(Student s,Teacher t,Parent p,Other o){
        s.eat2();
        t.eat();
        p.eat();
        o.eat();
    }

    public void startSleep(Student s, Teacher t,Parent p,Other o){
        s.sleep();
        t.sleep();
        p.sleep();
        o.sleep();
    }

    void walk(Student s){
        s.walk();
    }
}
//_____________________________________________________________________________________________________
// 接下来使用接口
interface People{
    void eat();
    void sleep();

}

class Student2 implements People{

    @Override
    public void eat() {
        System.out.println("aklsdjf");
    }

    @Override
    public void sleep() {

    }
}

class Teacher2 implements People{

    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }
}

class Parent2 implements People{

    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }
}

class  School2 {
    public void eat(People p){
        p.eat();
    }
    public void sleep(People p){
        p.sleep();
    }
}


interface Pass{
    int pass();
    int notPass();
}
class Player1 implements Pass{

    @Override
    public int pass() {
        return 1;
    }

    @Override
    public int notPass() {
        return 0;
    }
}
class Player2 implements Pass{
    public int tongguo(){
        return 1;
    }
    public int meitongguo(){
        return 0;
    }

    @Override
    public int pass() {
        return 1;
    }

    @Override
    public int notPass() {
        return 0;
    }
}
class userPlayer{
    void showPlayer(){
        Player1 player1 = new Player1();
        Player2 player2 = new Player2();
        System.out.println(player1.notPass()+player2.meitongguo());
        System.out.println(player1.pass()+player2.tongguo());
    }
}
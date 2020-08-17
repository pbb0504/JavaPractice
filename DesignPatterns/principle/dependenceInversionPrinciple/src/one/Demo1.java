package one;

/**
 * @author: pbb
 * @date: 2020/8/17 11:10
 */
public class Demo1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}


class Email{
    String getInfo(){
        return "email";
    }
}
// 完成person接受消息的功能

/**
 * 问题：
 * 1. 如果获取消息不是从email，而是从微信或其他的通信软件。
 * 那么就需要一个新的方法去应对不同的软件。
 * 2. 所以我们需要接受一个接口（功能），这个接口代表了传递信息的功能。
 * 我只需要接受实现了“传递消息”功能的实现类，而不用管实现类的细节。
 * 只因为我们需要的是“传递消息”这个功能，而不管其他任何细节。
 */
class Person{
    void receive(Email email){
        System.out.println(email.getInfo());
    }
}

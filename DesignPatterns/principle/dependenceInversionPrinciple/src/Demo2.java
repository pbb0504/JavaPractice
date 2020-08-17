/**
 * @author: pbb
 * @date: 2020/8/17 11:10
 */
public class Demo2 {

}

//现在我有一个Person类，有一个接收信息的方法，此方法通过email来收信。
/*class Person{
    void receive(Email email){
        System.out.println(email.getInfo());
    }
}*/
/**
 * 但是当我们不止需要email来收信，而是还需要微信、qq呢？
 *         所以我们不能将方法的参数定死在email上，而是需要接收一个接口
 *         这个接口中有getInfo()方法。我只要getInfo()，其他的一律不管。
 */

interface Message {
    String getInfo();
}
class Person {
    void receive(Message message){
        System.out.println(message.getInfo());
    }
}
//在具体使用的时候
class Email implements Message{
    private String emailInfo;

    @Override
    public String getInfo() {
        return emailInfo;
    }
}
//现在来个微信
class WeChat implements Message {
    private String weChatInfo;
    @Override
    public String getInfo(){
        return this.weChatInfo;
    }
}

class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Message message = new Email();
        Message message2 = new WeChat();
        person.receive(message);
        person.receive(message2);
    }
}

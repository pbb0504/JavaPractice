/**
 * @author: pbb
 * @date: 2020/9/26 16:39
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread01 thread01 = new MyThread01();
        thread01.setName("thread01");
        thread01.start();
        System.out.println("----------------------------------------------");
        // 这里myThread02没有继承Thread，所以没有setName等方法，只有一个run方法
        // 多态
        Runnable myThread02 = new MyThread02();
        Thread thread = new Thread(myThread02);
        thread.setName("thread02");
        thread.start();
    }
}

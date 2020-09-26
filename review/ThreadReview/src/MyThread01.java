/**
 * @author: pbb
 * @date: 2020/9/26 16:35
 */
public class MyThread01 extends Thread {
    private int x;

    @Override
    public void run() {
        for (x = 1; x < 10; x++) {
            System.out.println(Thread.currentThread().getName() + " " + x);
        }
    }
}

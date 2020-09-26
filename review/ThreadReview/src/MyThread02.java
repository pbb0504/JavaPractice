/**
 * @author: pbb
 * @date: 2020/9/26 16:43
 */
public class MyThread02 implements Runnable {
    private int x;

    @Override
    public void run() {
        for (x = 0; x < 10; x++) {
            System.out.println(Thread.currentThread().getName() + " " + x);
        }
    }
}

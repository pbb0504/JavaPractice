/**
 * @author: pbb
 * @date: 2020/10/4 10:07
 * <p>
 * 双重检查加锁
 */
public class Demo1 {
    private volatile static Demo1 demo1;

    private Demo1() {
    }

    private static Demo1 getInstance() {
        if (demo1 == null) {
            synchronized (Demo1.class) {
                if (demo1 == null) {
                    demo1 = new Demo1();
                }
            }
        }
        return demo1;
    }
}

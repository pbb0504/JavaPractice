import java.util.concurrent.atomic.AtomicReference;

public class Test03 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        AtomicReference<StringBuilder> sb = new AtomicReference<>(new StringBuilder());
        sb.get().append("0".repeat(20000));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

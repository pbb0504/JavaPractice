import java.io.*;

/**
 * @author: pbb
 * @date: 2020/10/18 10:48
 */
public class Demo2 {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("2.txt");
            fos.write(97);
            fos.close();

            FileInputStream fis = new FileInputStream("2.txt");
            int i = fis.read();
            System.out.println(i);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

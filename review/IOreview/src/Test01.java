import java.io.*;

/**
 * @author: pbb
 * @date: 2020/9/25 12:41
 */
public class Test01 {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("11111.txt");
            byte[] bytes = new byte[4];
            for(int i = 0; i < 4; i++){
                bytes[i] = 0;
            }
            fileOutputStream.write(bytes,0,4);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

import java.io.IOException;
import java.io.InputStream;

public class ReadIn {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        StringBuilder stringBuilder = new StringBuilder();
        while(true){
            int ch;
            ch = inputStream.read();
            if(ch=='\n'){
                String s = stringBuilder.toString();
                if(s.equals("over")){
                    inputStream.close();
                    System.exit(0);
                }
                System.out.println(s);
                stringBuilder.delete(0,stringBuilder.length());
            }else
                stringBuilder.append((char)ch);
        }
    }
}

public class Test02 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String str = "";
        for(int a = 0; a < 20000; a++) str = str + "0";
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

public class Main {

    public static void main(String[] args) {
         boolean isP=new Main().isPalindrome(-121);
         System.out.println(isP);
    }
    public boolean isPalindrome(int x) {
        String s=String.valueOf(x);
        char[] chars=s.toCharArray();
        char[] chars1=new char[chars.length];
        for(int i=chars.length-1;i>=0;i--){
            chars1[chars.length-i-1]=chars[i];
        }
        for(int j=0;j<chars.length;j++){
            if (chars[j]!=chars1[j]){
                return false;
            }
        }
        return true;
    }
}

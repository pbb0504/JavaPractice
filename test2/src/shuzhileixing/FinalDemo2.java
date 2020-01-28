package shuzhileixing;

public class FinalDemo2 {

    static final int EEE = 0;
    public static void main(String[] args) {
        final int RRR = 1;
        System.out.println(EEE);
        new FinalDemo2().func();
        System.out.println(RRR);
    }

    public void func(){
        System.out.println(EEE);
        // String[] args = {"111","222","333"};
        // new FinalDemo2().main(args);
    }
}

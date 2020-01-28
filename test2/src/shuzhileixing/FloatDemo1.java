package shuzhileixing;

import java.math.BigDecimal;

public class FloatDemo1 {
    public static void main(String[] args) {
        System.out.println(2.0-1.1);
        System.out.println("-----------------------");
        BigDecimal a = new BigDecimal("2.0");
        BigDecimal b = new BigDecimal("1.1");
        System.out.println(a.add(b));
        System.out.println("-----------------------");
        System.out.println('\u2122');
        System.out.println('\u03c0');
    }
}

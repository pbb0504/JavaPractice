package inAndOut;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        System.out.println("please input your name");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input);
    }
}

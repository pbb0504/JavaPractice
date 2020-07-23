package com.company.consoletest;

import java.io.Console;
import java.util.Scanner;

/**
 * @author: pbb
 * @date: 2020/7/23 21:49
 */
public class ConsoleTest {
    public static void main(String[] args) {
        /*Console console = System.console();
        String username = console.readLine("username: ");
        char[] password = console.readPassword("password: ");
        System.out.println(username+password);*/
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(s+".........");
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] numb = {-1, 100, 2, 100, 100, 4, 100};
        System.out.println(new Main().majorityElement(numb));
    }

    private int majorityElement(int[] numb) {
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        for (int i : numb) num.add(i);
        num.sort(Comparator.naturalOrder());
        num1.add(num.get(0));
        for (int i = 1; i < num.size(); i++) {
            if (num.get(i).equals(num1.get(0)))
                num1.add(num.get(i));
            else if (((!num.get(i).equals(num1.get(0))) && (num2.isEmpty())) || ((!num.get(i).equals(num1.get(0))) && (num.get(i).equals(num2.get(0)))))
                num2.add(num.get(i));
            else {
                if (num1.size() < num2.size()) {
                    num1.clear();
                    num1.add(num.get(i));
                } else {
                    num2.clear();
                    num2.add(num.get(i));
                }
            }
        }
        if (num1.size() > num2.size())
            return num1.get(0);
        else
            return num2.get(0);
    }
}
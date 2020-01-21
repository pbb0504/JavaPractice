package com.company;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        new ButtonFrame();
    }
}

// 点击按钮之后就开启一个线程，线程经过随机的时间改变面板的颜色
class ButtonFrame extends JFrame {
    static boolean flag = false;
    long start;

    ButtonFrame() {
        this.setTitle("反应速度测试");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.blue);
        JPanel panel = new JPanel();
        panel.setBackground(Color.blue);
        add(panel);
        JButton button = new JButton("111");
        button.setSize(100, 40);
        button.addActionListener(e -> {
            Runnable r = () -> {
                try {
                    Thread.sleep((long) ((long) 3000 * random()));
                    start = System.currentTimeMillis();
                    panel.setBackground(Color.white);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            };

            if (!flag) {
                Thread thread = new Thread(r, "timer");
                thread.start();
                flag = true;
            } else {
                panel.setBackground(Color.blue);
                long end = System.currentTimeMillis();
                button.setText((end - start) + "");
                flag = false;
            }
        });

        add(button, BorderLayout.NORTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

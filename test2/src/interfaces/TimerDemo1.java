package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TimerDemo1 {
    public static void main(String[] args) {
        // TimePrinter timePrinter = new TimePrinter();
        ActionListener actionListener = new TimePrinter();
        Timer t = new Timer(1000,actionListener);
        t.start();
        JOptionPane.showMessageDialog(null,"quit now?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("beep!");
    }
}
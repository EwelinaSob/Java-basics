package Clock;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class Clock extends JFrame implements Runnable {

    private Thread thread;
    String hour, minute, second;
    JLabel label;

    public Clock() {

        label = new JLabel("", JLabel.CENTER);
        label.setOpaque(true);
        label.setBounds(5, 5, 100, 40);
        label.setBackground(Color.gray);
        label.setForeground(Color.yellow);
        label.setBorder(BorderFactory.createTitledBorder("Zegar"));
        add(label);

        setSize(100, 100);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                LocalDateTime today = LocalDateTime.now();
                hour = "" + today.getHour();
                minute = String.format("%02d", today.getMinute());
                second = String.format("%02d", today.getSecond());
                label.setText(hour + ":" + minute + ":" + second);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Clock clock = new Clock();
    }
}

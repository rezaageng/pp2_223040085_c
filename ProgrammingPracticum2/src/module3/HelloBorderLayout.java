package module3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloBorderLayout extends JFrame {

    public HelloBorderLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelPertanyaan = new JLabel("apakah ibukita indonesia");
        JLabel labelHasil = new JLabel("apakah ibukita indonesia");

        JButton buttonA = new JButton("jakarta");
        JButton buttonB = new JButton("Bandung");
        JButton buttonC = new JButton("Surabaya");

        buttonA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                labelHasil.setText("jawaban benar");

            }

        });

        buttonB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                labelHasil.setText("jawaban salah");

            }

        });

        buttonC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                labelHasil.setText("jawaban salah");

            }

        });

        this.add(labelPertanyaan, BorderLayout.NORTH);
        this.add(labelHasil, BorderLayout.SOUTH);
        this.add(buttonA, BorderLayout.WEST);
        this.add(buttonB, BorderLayout.CENTER);
        this.add(buttonC, BorderLayout.EAST);

        this.setSize(400, 200);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloBorderLayout h = new HelloBorderLayout();
                h.setVisible(true);
            }
        });
    }

}

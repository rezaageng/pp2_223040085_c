package module4;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Listener Example");

        JLabel label = new JLabel("Click this area");
        label.setBounds(50, 50, 300, 30);

        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse clicked at: (" + e.getX() + "," + e.getY() + ")");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                label.setText("Mouse pressed at: (" + e.getX() + "," + e.getY() + ")");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                label.setText("Mouse released at: (" + e.getX() + "," + e.getY() + ")");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("Mose entered the area");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("Mouse exited the area");
            }
        });

        frame.add(label);
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

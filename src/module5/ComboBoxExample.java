package module5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ComboBox Example");

        String[] options = {"Option 1", "Option 2", "Option 3", "Option 4"};

        JComboBox<String> comboBox = new JComboBox<>(options);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();
                System.out.println("Selected: " + selected);
            }
        });

        comboBox.setBounds(50, 50, 150, 20);
        frame.setLayout(null);
        frame.add(comboBox);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

package module5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxModelExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ComboBoxModel Example");

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        model.addElement("item 1");
        model.addElement("item 2");
        model.addElement("item 3");
        model.addElement("item 4");

        JComboBox<String> comboBox = new JComboBox<>(model);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();
                System.out.println("Selected: " + selected);
            }
        });

        frame.setLayout(null);
        comboBox.setBounds(50, 50, 150, 20);
        frame.add(comboBox);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

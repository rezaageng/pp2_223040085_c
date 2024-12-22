package assignment1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void createUI() {
        JFrame frame = new JFrame("Main");

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem reset = new JMenuItem("Reset");
        JMenuItem exit = new JMenuItem("Exit");

        menuBar.add(menu);
        menu.add(reset);
        menu.add(exit);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(16, 16, 350, 20);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(16, 36, 350, 20);
        frame.add(nameField);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(16, 56, 350, 20);
        frame.add(genderLabel);

        JRadioButton maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(16, 76, 100, 20);
        frame.add(maleRadio);

        JRadioButton femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(116, 76, 100, 20);
        frame.add(femaleRadio);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        JLabel raceLabel = new JLabel("Race");
        raceLabel.setBounds(16, 96, 350, 20);
        frame.add(raceLabel);

        String[] raceOptions = {"Human", "Elf", "Devil", "Vampire"};
        JComboBox<String> race = new JComboBox<String>(raceOptions);
        race.setBounds(16, 116, 350, 24);
        frame.add(race);

        JLabel roleLabel = new JLabel("Role");
        roleLabel.setBounds(16, 140, 350, 20);
        frame.add(roleLabel);

        DefaultListModel<String> roleModel = new DefaultListModel<>();
        roleModel.addElement("Warrior");
        roleModel.addElement("Mage");
        roleModel.addElement("Assassins");
        roleModel.addElement("Support");

        JList<String> roleList = new JList<>(roleModel);
        roleList.setBounds(16, 160, 350, 80);
        frame.add(roleList);

        JLabel heightLabel = new JLabel("Height");
        heightLabel.setBounds(16, 240, 350, 20);
        frame.add(heightLabel);

        JSlider heightSlider = new JSlider(JSlider.HORIZONTAL, 120, 220, 120);
        heightSlider.setMinorTickSpacing(2);
        heightSlider.setMajorTickSpacing(10);
        heightSlider.setPaintTicks(true);
        heightSlider.setPaintLabels(true);
        heightSlider.setBounds(16, 260, 350, 40);
        frame.add(heightSlider);

        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setBounds(16, 300, 350, 20);
        frame.add(descriptionLabel);

        JTextArea descriptionArea = new JTextArea();
        descriptionArea.setBounds(16, 320, 350, 80);
        frame.add(descriptionArea);

        JCheckBox agreement = new JCheckBox("I agree to the terms and conditions");
        agreement.setBounds(16, 400, 350, 20);
        frame.add(agreement);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(16, 420, 100, 40);
        frame.add(submitButton);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Race");
        tableModel.addColumn("Role");
        tableModel.addColumn("Height");
        tableModel.addColumn("Description");

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(16, 460, 350, 200);
        frame.add(scrollPane);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                genderGroup.clearSelection();
                race.setSelectedIndex(0);
                roleList.clearSelection();
                heightSlider.setValue(120);
                descriptionArea.setText("");
                agreement.setSelected(false);
            }
        });


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String gender = maleRadio.isSelected() ? maleRadio.getText() : femaleRadio.getText();
                String raceValue = (String) race.getSelectedItem();
                String roleValue = roleList.getSelectedValue();
                int height = heightSlider.getValue();
                String description = descriptionArea.getText();

                String[] data = {name, gender, raceValue, roleValue, String.valueOf(height), description};
                tableModel.addRow(data);

                nameField.setText("");
                genderGroup.clearSelection();
                race.setSelectedIndex(0);
                roleList.clearSelection();
                heightSlider.setValue(120);
                descriptionArea.setText("");
                agreement.setSelected(false);
            }
        });


        frame.setJMenuBar(menuBar);
        frame.setSize(400, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        createUI();
    }
}

package module2.exercise;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercise3 extends JFrame {
    public Exercise3() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");

        menuBar.add(menu);

        JMenuItem reset = new JMenuItem("Reset");
        JMenuItem exit = new JMenuItem("Exit");

        menu.add(reset);
        menu.add(exit);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(16, 16, 350, 10);

        JTextField nameField = new JTextField();
        nameField.setBounds(16, 32, 350, 30);

        JLabel phoneLabel = new JLabel("Phone: ");
        phoneLabel.setBounds(16, 72, 350, 10);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(16, 88, 350, 30);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(16, 128, 350, 10);

        JRadioButton maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(16, 144, 350, 30);

        JRadioButton femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(16, 176, 350, 30);

        ButtonGroup group = new ButtonGroup();
        group.add(maleRadio);
        group.add(femaleRadio);

        JCheckBox checkBox = new JCheckBox("Foreigner");
        checkBox.setBounds(16, 216, 350, 30);

        JLabel savingTypeLabel = new JLabel("Saving Type:");
        savingTypeLabel.setBounds(16, 256, 350, 10);

        JList<String> savingTypeList = new JList<String>(new String[]{"Regular", "Gold", "Platinum", "Diamond"});
        savingTypeList.setBounds(16, 272, 350, 70);

        JLabel transactionFrequencyLabel = new JLabel("Transaction Frequency:");
        transactionFrequencyLabel.setBounds(16, 352, 350, 10);

        JSlider transactionFrequencySlider = new JSlider(1, 100, 1);
        transactionFrequencySlider.setBounds(16, 368, 350, 40);
        transactionFrequencySlider.setPaintLabels(true);
        transactionFrequencySlider.setPaintTicks(true);
        transactionFrequencySlider.setMajorTickSpacing(9);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(16, 408, 350, 10);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(16, 424, 350, 30);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password: ");
        confirmPasswordLabel.setBounds(16, 464, 350, 10);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(16, 480, 350, 30);

        JLabel dateOfBirthLabel = new JLabel("Date of Birth: ");
        dateOfBirthLabel.setBounds(16, 520, 350, 10);

        JSpinner dateOfBirthSpinner = new JSpinner(new SpinnerDateModel());
        dateOfBirthSpinner.setBounds(16, 536, 350, 30);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateOfBirthSpinner, "dd/MM/yyyy");
        dateOfBirthSpinner.setEditor(dateEditor);

        JButton button = new JButton("Submit");
        button.setBounds(16, 576, 100, 40);

        JTextArea textOutput = new JTextArea("");
        textOutput.setBounds(16, 632, 350, 200);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phone = phoneField.getText();
                String gender = maleRadio.isSelected() ? maleRadio.getText() : femaleRadio.getText();
                String foreigner = checkBox.isSelected() ? "Yes" : "No";
                String savingType = savingTypeList.getSelectedValue();
                int transactionFrequency = transactionFrequencySlider.getValue();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                String dateOfBirth = dateEditor.getFormat().format(dateOfBirthSpinner.getValue());

                if (!password.equals(confirmPassword)) {
                    textOutput.append("Password does not match\n");
                    return;
                }

                textOutput.append("Name: " + name +
                        "\nPhone: " + phone +
                        "\nGender: " + gender +
                        "\nForeigner: " + foreigner +
                        "\nSaving Type: " + savingType +
                        "\nTransaction Frequency: " + transactionFrequency +
                        "\nDate of Birth: " + dateOfBirth +
                        "\n" +
                        "______________________\n");

                nameField.setText("");
                phoneField.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                group.clearSelection();
                checkBox.setSelected(false);
                savingTypeList.clearSelection();
                transactionFrequencySlider.setValue(1);
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                phoneField.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                group.clearSelection();
                checkBox.setSelected(false);
                savingTypeList.clearSelection();
                transactionFrequencySlider.setValue(1);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.setJMenuBar(menuBar);
        this.add(nameLabel);
        this.add(nameField);
        this.add(phoneLabel);
        this.add(phoneField);
        this.add(genderLabel);
        this.add(maleRadio);
        this.add(femaleRadio);
        this.add(checkBox);
        this.add(savingTypeLabel);
        this.add(savingTypeList);
        this.add(transactionFrequencyLabel);
        this.add(transactionFrequencySlider);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(confirmPasswordLabel);
        this.add(confirmPasswordField);
        this.add(dateOfBirthLabel);
        this.add(dateOfBirthSpinner);
        this.add(button);
        this.add(textOutput);

        this.setSize(400, 1000);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Exercise3 frame = new Exercise3();
                frame.setVisible(true);
            }
        });
    }
}

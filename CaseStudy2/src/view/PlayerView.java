package view;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class PlayerView extends JFrame {
    private final JTextField idField = new JTextField();
    private final JTextField nameField = new JTextField();
    private final JTextField roleField = new JTextField();
    private final JTextField weaponField = new JTextField();
    private final JTextField raceField = new JTextField();
    private final JTextField genderField = new JTextField();
    private final JButton insertButton = new JButton("Insert");
    private final JButton updateButton = new JButton("Update");
    private final JButton deleteButton = new JButton("Delete");
    private final JButton refreshButton = new JButton("Refresh");
    private final JTable playerTable = new JTable();

    public PlayerView() {
        setTitle("Player Manager");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(new JLabel("ID"));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        idField.setEditable(false);
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Role"));
        inputPanel.add(roleField);
        inputPanel.add(new JLabel("Weapon"));
        inputPanel.add(weaponField);
        inputPanel.add(new JLabel("Race"));
        inputPanel.add(raceField);
        inputPanel.add(new JLabel("gender"));
        inputPanel.add(genderField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(insertButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        add(inputPanel, BorderLayout.NORTH);

        JScrollPane playerTableScrollPane = new JScrollPane(playerTable);
        add(playerTableScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void insertButtonListener(ActionListener listener) {
        insertButton.addActionListener(listener);
    }

    public void updateButtonListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }

    public void deleteButtonListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void refreshButtonListener(ActionListener listener) {
        refreshButton.addActionListener(listener);
    }

    public void setPlayerTableData(Object[][] data, Object[] columnNames) {
        playerTable.setModel(new DefaultTableModel(data, columnNames));
    }

    public void addTableSelectionListener(ListSelectionListener listener) {
        playerTable.getSelectionModel().addListSelectionListener(listener);
    }

    public JTable getPlayerTable() {
        return playerTable;
    }

    public int getIdField() {
        return Integer.parseInt(idField.getText());
    }

    public void setIdField(String id) {
        idField.setText(id);
    }

    public String getNameField() {
        return nameField.getText();
    }

    public void setNameField(String name) {
        nameField.setText(name);
    }

    public String getRoleField() {
        return roleField.getText();
    }

    public void setRoleField(String role) {
        roleField.setText(role);
    }

    public String getWeaponField() {
        return weaponField.getText();
    }

    public void setWeaponField(String weapon) {
        weaponField.setText(weapon);
    }

    public String getRaceField() {
        return raceField.getText();
    }

    public void setRaceField(String race) {
        raceField.setText(race);
    }

    public String getGenderField() {
        return genderField.getText();
    }

    public void setGenderField(String gender) {
        genderField.setText(gender);
    }

    public void cleanFields() {
        idField.setText("");
        nameField.setText("");
        roleField.setText("");
        weaponField.setText("");
        raceField.setText("");
        genderField.setText("");
    }
}

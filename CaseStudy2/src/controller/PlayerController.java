package controller;

import model.MyBatisUtil;
import model.Player;
import model.PlayerMapper;
import org.apache.ibatis.session.SqlSession;
import view.PlayerView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PlayerController {
    private final PlayerView view;
    private final PlayerMapper mapper;

    public PlayerController(PlayerView view, PlayerMapper mapper) {
        this.view = view;
        this.mapper = mapper;

        new RefreshButtonListener().actionPerformed(null);

        view.insertButtonListener(new InsertButtonListener());
        view.refreshButtonListener(new RefreshButtonListener());
        view.updateButtonListener(new UpdateButtonListener());
        view.deleteButtonListener(new DeleteButtonListener());
        view.addTableSelectionListener(new TableSelectionListener());
    }

    class TableSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int selectedRow = view.getPlayerTable().getSelectedRow();
            if (selectedRow != -1) {
                int id = (int) view.getPlayerTable().getValueAt(selectedRow, 0);
                String name = (String) view.getPlayerTable().getValueAt(selectedRow, 1);
                String role = (String) view.getPlayerTable().getValueAt(selectedRow, 2);
                String weapon = (String) view.getPlayerTable().getValueAt(selectedRow, 3);
                String race = (String) view.getPlayerTable().getValueAt(selectedRow, 4);
                String gender = (String) view.getPlayerTable().getValueAt(selectedRow, 5);


                view.setIdField(String.valueOf(id));
                view.setNameField(name);
                view.setRoleField(role);
                view.setWeaponField(weapon);
                view.setRaceField(race);
                view.setGenderField(gender);
            }
        }
    }

    class RefreshButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                List<Player> players = mapper.getPlayers();
                Object[][] data = new Object[players.size()][6];
                for (int i = 0; i < players.size(); i++) {
                    Player player = players.get(i);
                    data[i][0] = player.getId();
                    data[i][1] = player.getName();
                    data[i][2] = player.getRole();
                    data[i][3] = player.getWeapon();
                    data[i][4] = player.getRace();
                    data[i][5] = player.getGender();
                }
                Object[] columnNames = {"id", "Name", "Role", "Weapon", "Race", "Gender"};
                view.setPlayerTableData(data, columnNames);

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(view, "Failed to get players");
            }
        }
    }

    class InsertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNameField();
            String role = view.getRoleField();
            String weapon = view.getWeaponField();
            String race = view.getRaceField();
            String gender = view.getGenderField();

            if (name.isEmpty() || role.isEmpty() || weapon.isEmpty() || race.isEmpty() || gender.isEmpty()) {
                JOptionPane.showMessageDialog(view, "All fields must be filled");
            }

            Player player = new Player();
            player.setName(name);
            player.setRole(role);
            player.setWeapon(weapon);
            player.setRace(race);
            player.setGender(gender);

            SqlSession session = MyBatisUtil.getSqlSession();

            try {
                mapper.insertPlayer(player);
                session.commit();
                JOptionPane.showMessageDialog(view, "Player inserted successfully");
                view.cleanFields();
                new RefreshButtonListener().actionPerformed(null);
            } catch (Exception ex) {
                session.rollback();
                ex.printStackTrace();
                JOptionPane.showMessageDialog(view, "Failed to insert player");
            } finally {
                session.close();
            }
        }
    }

    class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = view.getIdField();
            String name = view.getNameField();
            String role = view.getRoleField();
            String weapon = view.getWeaponField();
            String race = view.getRaceField();
            String gender = view.getGenderField();

            System.out.println(id);

            if (name.isEmpty() || role.isEmpty() || weapon.isEmpty() || race.isEmpty() || gender.isEmpty()) {
                JOptionPane.showMessageDialog(view, "All fields must be filled");
            }

            Player player = new Player();
            player.setId(id);
            player.setName(name);
            player.setRole(role);
            player.setWeapon(weapon);
            player.setRace(race);
            player.setGender(gender);

            SqlSession session = MyBatisUtil.getSqlSession();

            try {
                mapper.updatePlayer(player);
                session.commit();
                JOptionPane.showMessageDialog(view, "Player updated successfully");
                view.cleanFields();
                new RefreshButtonListener().actionPerformed(null);
            } catch (Exception ex) {
                session.rollback();
                ex.printStackTrace();
                JOptionPane.showMessageDialog(view, "Failed to update player");
            } finally {
                session.close();
            }

        }
    }

    class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = view.getIdField();

            System.out.println();

            SqlSession session = MyBatisUtil.getSqlSession();

            try {
                mapper.deletePlayer(id);
                session.commit();
                JOptionPane.showMessageDialog(view, "Player deleted successfully");
                view.cleanFields();
                new RefreshButtonListener().actionPerformed(null);
            } catch (Exception ex) {
                session.rollback();
                ex.printStackTrace();
                JOptionPane.showMessageDialog(view, "Failed to update player");
            } finally {
                session.close();
            }

        }
    }
}

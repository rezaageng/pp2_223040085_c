package controller;

import model.User;
import model.UserMapper;
import view.UserPdf;
import view.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserController {
    private UserView view;
    private UserMapper mapper;
    private UserPdf pdf;

    public UserController(UserView view, UserMapper mapper, UserPdf pdf) {
        this.view = view;
        this.mapper = mapper;
        this.pdf = pdf;

        this.view.addAddUserListener(new AddUserListener());
        this.view.addRefreshListener(new RefreshListener());
        this.view.addExportPdfListener(new ExportPdfListener());

    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNameInput();
            String email = view.getEmailInput();

            if (!name.isEmpty() && !email.isEmpty()) {
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                mapper.insertUser(user);
                JOptionPane.showMessageDialog(view, "User added successfully!");
            } else {
                JOptionPane.showMessageDialog(view, "Please fill in all fields.");
            }
        }
    }

    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getProgressBar().setIndeterminate(false);
            view.getProgressBar().setValue(0);
            new SwingWorker<List<User>, Integer>() {
                @Override
                protected List<User> doInBackground() throws Exception {
                    List<User> users = mapper.getAllUsers();
                    int totalUsers = users.size();
                    for (int i = 0; i < totalUsers; i++) {
                        int progress = (int) ((i + 1) / (double) totalUsers * 100);
                        publish(progress);
                    }
                    return users;
                }

                @Override
                protected void process(List<Integer> chunks) {
                    int progress = chunks.get(chunks.size() - 1);
                    view.getProgressBar().setValue(progress);
                }

                @Override
                protected void done() {
                    try {
                        List<User> users = get();
                        String[] userArray = users.stream()
                                .map(u -> u.getName() + " (" + u.getEmail() + ")")
                                .toArray(String[]::new);
                        view.setUserList(userArray);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(view, "Failed to refresh user list.");
                    } finally {
                        view.getProgressBar().setValue(100);
                    }
                }
            }.execute();
        }
    }


    class ExportPdfListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (pdf != null) {  // Pastikan objek pdf tidak null
                List<User> users = mapper.getAllUsers();
                pdf.exportPdf(users);
                JOptionPane.showMessageDialog(view, "PDF exported successfully!");
            } else {
                JOptionPane.showMessageDialog(view, "PDF export failed. PDF object is null.");
            }
        }
    }

}
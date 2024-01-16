package view;

import user.Authentication;
import user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends Page {

    public LoginPage() {
        super();
        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(Color.WHITE);

        panel.setLayout(new GridBagLayout());        
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        // Trocar por um ícone/imagem
        JLabel title = new JLabel("TaDa");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(title, gbc);

        gbc.gridy++;
        gbc.gridwidth--;
        add(new JLabel("E-mail: "), gbc);
        gbc.gridy++;
        add(new JLabel("Password: "), gbc);

        gbc.gridx++;
        gbc.gridy--;
        JTextField emailField = new JTextField(20);
        add(emailField, gbc);
        gbc.gridy++;
        JTextField passwordField = new JTextField(20);
        add(passwordField, gbc);

        gbc.gridx--;
        gbc.gridy++;
        gbc.gridwidth++;
        JButton signInButton = new JButton("Sign In");
        add(signInButton, gbc);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = passwordField.getText();
                if (email != null && password != null) {
                    if(Authentication.isValidEmail(email) && Authentication.isValidPassword(password)){
                        createUser(email, password);
                        homePage = new HomePage();
                        changeTo(homePage);
                    }
                    else {
                        JOptionPane.showMessageDialog(panel, "Please enter a valid email and password.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(panel, "Please enter a valid email and password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void createUser(String email, String password) {
        currentUser.setEmail(email);
        currentUser.setPassword(password);
    }
}

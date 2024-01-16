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
        JPasswordField passwordField = new JPasswordField(20);
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
                String password = String.valueOf(passwordField.getPassword());
                if (!(email.isEmpty() || password.isEmpty())) {
                    if(Authentication.isValidEmail(email) && Authentication.isValidPassword(password)){
                        createUser(email, password);
                        homePage = new HomePage();
                        changeTo(homePage);
                    }
                }
            }
        });
    }

    private void createUser(String email, String password) {
        currentUser.setEmail(email);
        currentUser.setPassword(password);
    }
}

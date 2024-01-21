package view;

import user.Authentication;

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
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        //ImageIcon originalImageIcon = new ImageIcon(getClass().getResource("/icons/TaDa.png"));
        JLabel title = new JLabel("TaDa");
        title.setFont(new java.awt.Font("Ariel", 1, 25));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridy++;
        gbc.gridwidth--;
        panel.add(new JLabel("E-mail: "), gbc);
        gbc.gridy++;
        panel.add(new JLabel("Password: "), gbc);

        gbc.gridx++;
        gbc.gridy--;
        JTextField emailField = new JTextField(20);
        panel.add(emailField, gbc);
        gbc.gridy++;
        JPasswordField passwordField = new JPasswordField(20);
        panel.add(passwordField, gbc);

        gbc.gridx--;
        gbc.gridy++;
        gbc.gridwidth++;
        JButton signInButton = new JButton("Sign In");
        panel.add(signInButton, gbc);

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
                    else {
                        JOptionPane.showMessageDialog(panel, "Please enter a valid email and password.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(panel, "Please enter a valid email and password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        getContentPane().add(panel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createUser(String email, String password) {
        currentUser.setEmail(email);
        currentUser.setPassword(password);
    }    
    
}

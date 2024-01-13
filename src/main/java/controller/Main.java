package controller;

import view.HomePage;
import view.LoginPage;

import javax.swing.*;

public class Main {
    public static LoginPage loginPage = new LoginPage();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            loginPage.setVisible(true);
        });
    }
}

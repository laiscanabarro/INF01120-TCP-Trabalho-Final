package view;

import user.User;
import utils.PageUtils;

import javax.swing.*;

public class Page extends JFrame {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public static User currentUser = new User();
    public static HomePage homePage;

    public Page(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("TaDa");
        setSize(WIDTH, HEIGHT);
    }

    public void changeTo(JFrame destinyPage) {
        PageUtils.changeTo(this, destinyPage);
    }
}

package utils;

import javax.swing.*;

public class PageUtils {
    public static void changeTo(JFrame origin, JFrame destiny){
        destiny.setBounds(origin.getX(), origin.getY(), origin.getWidth(), origin.getHeight());
        destiny.setExtendedState(origin.getExtendedState());
        destiny.setVisible(true);
        origin.setVisible(false);
    }
}

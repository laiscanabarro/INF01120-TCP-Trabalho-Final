package view;

import content.DailyList;
import content.ImportantList;
import content.TaskList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.HomePage.*;

public class ListsPage extends JPanel {
    private static final int buttonWidth = 300;
    private static final int buttonHeight = 25;
    private static final Dimension buttonDimension = new Dimension(buttonWidth, buttonHeight);
    public static JPanel showLists() {

        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(Color.WHITE);

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JButton backButton = generalButton("", new Dimension(1,50), Color.WHITE);
        panel.add(backButton, gbc);

        gbc.gridx++;
        JLabel title = new JLabel("Lists");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(title, gbc);

        gbc.gridx = 0;
        gbc.gridwidth = 2;
        for (TaskList list : Page.currentUser.getTaskLists()) {
            gbc.gridy++;
            JButton button = new JButton(list.getName());
            button.setPreferredSize(buttonDimension);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateRightPanel(ListSpecificPage.showSpecificList(list));
                }
            });
            panel.add(button, gbc);
        }

        gbc.gridy++;
        JButton importantListButton = new JButton(ImportantList.getInstance().getName());
        importantListButton.setPreferredSize(buttonDimension);
        panel.add(importantListButton, gbc);

        gbc.gridy++;
        JButton dailyListButton = new JButton(DailyList.getInstance().getName());
        dailyListButton.setPreferredSize(buttonDimension);
        panel.add(dailyListButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        panel.add(new JLabel(), gbc);

        importantListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRightPanel(ImportantListPage.showList(ImportantList.getInstance()));
            }
        });

        dailyListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRightPanel(ListSpecificPage.showSpecificList(DailyList.getInstance()));
            }
        });

        return panel;
    }
}

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
    private static final int buttonWidth = 360;
    private static final int buttonHeight = 25;
    private static final Dimension buttonDimension = new Dimension(buttonWidth, buttonHeight);
    private static final Dimension smallButtonDimension = new Dimension(60, buttonHeight);
    public static JPanel showLists() {

        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(Color.WHITE);

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel title = new JLabel("Lists");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(title, gbc);

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

            gbc.gridx = 3;
            gbc.gridwidth = 1;
            JButton delete = new JButton("-");
            delete.setPreferredSize(smallButtonDimension);
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Page.currentUser.removeList(list);
                    updateRightPanel(ListsPage.showLists());
                }
            });
            panel.add(delete, gbc);
        }

        gbc.gridx = 1;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton importantListButton = new JButton(ImportantList.getInstance().getName());
        importantListButton.setPreferredSize(buttonDimension);
        panel.add(importantListButton, gbc);

        gbc.gridy++;
        JButton dailyListButton = new JButton(DailyList.getInstance().getName());
        dailyListButton.setPreferredSize(buttonDimension);
        panel.add(dailyListButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        JLabel addListLabel = new JLabel("New List:");
        panel.add(addListLabel, gbc);
        gbc.gridx++;
        gbc.gridwidth = 2;
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(buttonDimension);
        panel.add(nameField, gbc);
        gbc.gridx = 3;
        gbc.gridwidth = 1;
        JButton addListButton = new JButton("+");
        addListButton.setPreferredSize(smallButtonDimension);
        panel.add(addListButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 4;
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

        addListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if (!name.isEmpty()) {
                    TaskList newList = new TaskList();
                    newList.setName(name);
                    Page.currentUser.addList(newList);
                    updateRightPanel(ListsPage.showLists());
                }
            }
        });

        return panel;
    }
}

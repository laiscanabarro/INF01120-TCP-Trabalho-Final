package view;

import content.TaskList;
import utils.PageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static utils.PageUtils.changeTo;
import static view.HomePage.generalButton;
import static view.Page.homePage;

public class NewListPage extends JPanel {
    public static JPanel createList() {
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
        JLabel title = new JLabel("Create list");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(title, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(new JLabel("Name: "), gbc);

        gbc.gridy++;
        JTextField nameField = new JTextField(20);
        panel.add(nameField, gbc);

        gbc.gridy++;
        JButton createButton = new JButton("Create");
        panel.add(createButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        panel.add(new JLabel(), gbc);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if (name != null && !name.isEmpty()) {
                    TaskList newList = new TaskList();
                    newList.setName(name);
                    Page.currentUser.addList(newList);
                }
            }
        });

        return panel;
    }
}

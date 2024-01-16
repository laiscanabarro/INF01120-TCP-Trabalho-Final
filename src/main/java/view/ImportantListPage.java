package view;

import content.ImportantList;
import content.Task;
import content.TaskList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static view.HomePage.generalButton;
import static view.HomePage.updateRightPanel;
import static view.Page.hilightColor;

public class ImportantListPage extends JPanel {
    private static final int buttonWidth = 261;
    private static final int buttonHeight = 25;
    private static final Dimension buttonDimension = new Dimension(buttonWidth, buttonHeight);
    public static JPanel showList(TaskList list) {
        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(Color.WHITE);

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        JButton backButton = generalButton("<", new Dimension(50,50), hilightColor);
        panel.add(backButton, gbc);

        gbc.gridx++;
        JLabel title = new JLabel(list.getName());
        title.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(title, gbc);

        for (Task task : list.getTasks()) {
            gbc.gridy++;
            gbc.gridx = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            JCheckBox status = new JCheckBox();
            status.setSelected(task.getStatus());
            panel.add(status, gbc);
            status.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    task.setStatus(!task.getStatus());
                }
            });

            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            JButton button = new JButton(task.getName());
            button.setPreferredSize(buttonDimension);
            panel.add(button, gbc);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateRightPanel(TaskPage.showTask(task));
                }
            });

            JLabel importanceLabel = new JLabel(String.valueOf(task.getImportanceScale()));
            gbc.gridx = 2;
            JButton increaseButton = new JButton("+");
            panel.add(increaseButton, gbc);
            increaseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ImportantList.increasePriority(task);
                    importanceLabel.setText(String.valueOf(task.getImportanceScale()));
                }
            });

            gbc.gridx = 3;
            panel.add(importanceLabel, gbc);

            gbc.gridx = 4;
            JButton decreaseButton = new JButton("-");
            panel.add(decreaseButton, gbc);
            decreaseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ImportantList.decreasePriority(task);
                    importanceLabel.setText(String.valueOf(task.getImportanceScale()));
                }
            });
        }

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        panel.add(new JLabel(), gbc);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRightPanel(ListsPage.showLists());
            }
        });

        return panel;
    }
}

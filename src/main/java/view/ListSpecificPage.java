package view;

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

public class ListSpecificPage extends JPanel {
    private static final int buttonWidth = 261;
    private static final int buttonHeight = 25;
    private static final Dimension buttonDimension = new Dimension(buttonWidth, buttonHeight);
    public static JPanel showSpecificList(TaskList list) {
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
            gbc.gridwidth = 1;
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

            gbc.gridx = 2;
            JButton delete = new JButton("-");
            delete.setPreferredSize(new Dimension(41, buttonHeight));
            panel.add(delete, gbc);
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    list.removeTask(task);
                    updateRightPanel(ListSpecificPage.showSpecificList(list));
                }
            });
        }

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        JLabel addTaskLabel = new JLabel("New Task:");
        panel.add(addTaskLabel, gbc);
        gbc.gridx++;
        JTextField nameField = new JTextField(26);
        panel.add(nameField, gbc);
        gbc.gridx++;
        JButton addTaskButton = new JButton("+");
        panel.add(addTaskButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 3;
        panel.add(new JLabel(), gbc);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRightPanel(ListsPage.showLists());
            }
        });

        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if (name != null) {
                    Task newTask = new Task();
                    newTask.setName(name);
                    list.addTask(newTask);
                    updateRightPanel(ListSpecificPage.showSpecificList(list));
                }
            }
        });

        return panel;
    }
}

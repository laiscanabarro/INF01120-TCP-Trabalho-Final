package view;

import content.Task;
import content.TaskList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static view.HomePage.updateRightPanel;

public class ListSpecificPage extends JPanel {
    private static final int BUTTON_WIDTH = 360;
    private static final int BUTTON_HEIGHT = 25;
    private static final Dimension BUTTON_DIMENSION = new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT);
    private static final Dimension SMALL_BUTTON_DIMENSION = new Dimension(60, BUTTON_HEIGHT);

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
        JButton backButton = new JButton("Back");
        panel.add(backButton, gbc);

        gbc.gridx++;
        gbc.gridwidth = 3;
        JLabel title = new JLabel(list.getName());
        title.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(title, gbc);

        gbc.gridy++;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        JButton orderAlpha = new JButton("A");
        orderAlpha.setPreferredSize(SMALL_BUTTON_DIMENSION);
        panel.add(orderAlpha, gbc);
        orderAlpha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.changeOrder(TaskList.ORDER_BY.ALPHABET);
                updateRightPanel(ListSpecificPage.showSpecificList(list));
            }
        });

        gbc.gridx++;
        JButton orderDateAsc = new JButton("^D");
        orderDateAsc.setPreferredSize(SMALL_BUTTON_DIMENSION);
        panel.add(orderDateAsc, gbc);
        orderDateAsc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.changeOrder(TaskList.ORDER_BY.END_DATE_ASC);
                updateRightPanel(ListSpecificPage.showSpecificList(list));
            }
        });

        gbc.gridx++;
        JButton orderDateDesc = new JButton("vD");
        orderDateDesc.setPreferredSize(SMALL_BUTTON_DIMENSION);
        panel.add(orderDateDesc, gbc);
        orderDateDesc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.changeOrder(TaskList.ORDER_BY.END_DATE_DESC);
                updateRightPanel(ListSpecificPage.showSpecificList(list));
            }
        });

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
            gbc.gridwidth = 3;
            gbc.anchor = GridBagConstraints.WEST;
            JButton button = new JButton(task.getName());
            button.setPreferredSize(BUTTON_DIMENSION);
            panel.add(button, gbc);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateRightPanel(TaskPage.showTask(task));
                }
            });

            gbc.gridx = 4;
            gbc.gridwidth = 1;
            JButton delete = new JButton("-");
            delete.setPreferredSize(SMALL_BUTTON_DIMENSION);
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
        gbc.gridwidth = 3;
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(BUTTON_DIMENSION);
        panel.add(nameField, gbc);
        gbc.gridx = 4;
        gbc.gridwidth = 1;
        JButton addTaskButton = new JButton("+");
        addTaskButton.setPreferredSize(SMALL_BUTTON_DIMENSION);
        panel.add(addTaskButton, gbc);
        gbc.gridx++;
        JButton clearListButton = new JButton("Clear List");
        panel.add(clearListButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 6;
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

        clearListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.clear();
                updateRightPanel(ListSpecificPage.showSpecificList(list));
            }
        });

        return panel;
    }
}

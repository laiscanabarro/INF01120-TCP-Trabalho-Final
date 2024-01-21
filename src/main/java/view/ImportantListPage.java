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

import static view.HomePage.updateRightPanel;

public class ImportantListPage extends JPanel {
    private static final int BUTTON_WIDTH = 360;
    private static final int BUTTON_HEIGHT = 25;
    private static final Dimension BUTTON_DIMENSION = new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT);
    private static final Dimension SMALL_BUTTON_DIMENSION = new Dimension(60, BUTTON_HEIGHT);

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
        JButton backButton = new JButton("Back");
        panel.add(backButton, gbc);

        gbc.gridx++;
        gbc.gridwidth = 5;
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
                updateRightPanel(ImportantListPage.showList(ImportantList.getInstance()));
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
                updateRightPanel(ImportantListPage.showList(ImportantList.getInstance()));
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
                updateRightPanel(ImportantListPage.showList(ImportantList.getInstance()));
            }
        });

        gbc.gridx++;
        JButton orderImpAsc = new JButton("^I");
        orderImpAsc.setPreferredSize(SMALL_BUTTON_DIMENSION);
        panel.add(orderImpAsc, gbc);
        orderImpAsc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.changeOrder(TaskList.ORDER_BY.IMPORTANCE_ASC);
                updateRightPanel(ImportantListPage.showList(ImportantList.getInstance()));
            }
        });

        gbc.gridx++;
        JButton orderImpDesc = new JButton("vI");
        orderImpDesc.setPreferredSize(SMALL_BUTTON_DIMENSION);
        panel.add(orderImpDesc, gbc);
        orderImpDesc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.changeOrder(TaskList.ORDER_BY.IMPORTANCE_DESC);
                updateRightPanel(ImportantListPage.showList(ImportantList.getInstance()));
            }
        });

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

            gbc.gridx++;
            gbc.gridwidth = 5;
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

            JLabel importanceLabel = new JLabel(String.valueOf(task.getImportanceScale()));
            gbc.gridx = 6;
            gbc.gridwidth = 1;
            JButton increaseButton = new JButton("+");
            increaseButton.setPreferredSize(SMALL_BUTTON_DIMENSION);
            panel.add(increaseButton, gbc);
            increaseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ImportantList.increasePriority(task);
                    importanceLabel.setText(String.valueOf(task.getImportanceScale()));
                }
            });

            gbc.gridx = 7;
            panel.add(importanceLabel, gbc);

            gbc.gridx = 8;
            JButton decreaseButton = new JButton("-");
            decreaseButton.setPreferredSize(SMALL_BUTTON_DIMENSION);
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
        gbc.gridwidth = 9;
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

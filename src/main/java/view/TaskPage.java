package view;

import content.ImportantList;
import content.Subtask;
import content.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static view.HomePage.updateRightPanel;

public class TaskPage extends JPanel {
    private static final int BUTTON_WIDTH = 360;
    private static final int BUTTON_HEIGHT = 25;
    private static final Dimension BUTTON_DIMENSION = new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT);
    private static final Dimension SMALL_BUTTON_DIMENSION = new Dimension(60, BUTTON_HEIGHT);

    public static JPanel showTask(Task task) {
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
        JLabel title = new JLabel(task.getName());
        title.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(title, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        JLabel scaleLabel = new JLabel("Importance Scale: ");
        panel.add(scaleLabel, gbc);

        gbc.gridx++;
        JLabel scale = new JLabel(String.valueOf(task.getImportanceScale()));
        JButton increase = new JButton("+");
        increase.setPreferredSize(SMALL_BUTTON_DIMENSION);
        panel.add(increase, gbc);
        increase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImportantList.increasePriority(task);
                scale.setText(String.valueOf(task.getImportanceScale()));
            }
        });

        gbc.gridx++;
        panel.add(scale, gbc);

        gbc.gridx++;
        JButton decrease = new JButton("-");
        decrease.setPreferredSize(SMALL_BUTTON_DIMENSION);
        panel.add(decrease, gbc);
        decrease.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImportantList.decreasePriority(task);
                scale.setText(String.valueOf(task.getImportanceScale()));
            }
        });

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 3;
        JLabel descriptionLabel = new JLabel("Description: ");
        panel.add(descriptionLabel, gbc);

        gbc.gridx++;
        JTextField description = new JTextField(task.getDescription());
        description.setPreferredSize(BUTTON_DIMENSION);
        panel.add(description, gbc);
        description.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newDescription = description.getText();
                task.setDescription(newDescription);
            }
        });

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 3;
        JLabel deadlineLabel = new JLabel("Deadline: ");
        panel.add(deadlineLabel, gbc);

        gbc.gridx++;
        JTextField deadline = new JTextField(String.valueOf(task.getDeadline() == null ? "" : task.getDeadline()));
        deadline.setPreferredSize(BUTTON_DIMENSION);
        panel.add(deadline, gbc);
        deadline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newDeadline = deadline.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                LocalDate localDate = LocalDate.parse(newDeadline, formatter);
                task.setDeadline(localDate);
            }
        });

        if (task.getConclusionDate() != null) {
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = 3;
            JLabel conclusionLabel = new JLabel("Conclusion Date: ");
            panel.add(conclusionLabel, gbc);

            gbc.gridx++;
            JLabel conclusion = new JLabel(task.getConclusionDate().toString());
            panel.add(conclusion, gbc);
        }

        for (Subtask subtask : task.getSubtasks()) {
            gbc.gridy++;
            gbc.gridx = 0;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            JCheckBox status = new JCheckBox();
            status.setSelected(subtask.getStatus());
            panel.add(status, gbc);
            status.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    subtask.setStatus(!subtask.getStatus());
                }
            });

            gbc.gridx++;
            gbc.gridwidth = 3;
            gbc.anchor = GridBagConstraints.WEST;
            JLabel label = new JLabel(subtask.getName());
            panel.add(label, gbc);

            gbc.gridx = 4;
            gbc.gridwidth = 1;
            JButton delete = new JButton("-");
            delete.setPreferredSize(SMALL_BUTTON_DIMENSION);
            panel.add(delete, gbc);
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    task.removeSubtask(subtask);
                    updateRightPanel(TaskPage.showTask(task));
                }
            });

            gbc.gridx++;
            JButton promote = new JButton("Promote to Task");
            panel.add(promote, gbc);
            promote.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    subtask.promoteToTask();
                    updateRightPanel(TaskPage.showTask(task));
                }
            });
        }

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        JLabel addSubtaskLabel = new JLabel("New Subtask:");
        panel.add(addSubtaskLabel, gbc);
        gbc.gridx++;
        gbc.gridwidth = 3;
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(BUTTON_DIMENSION);
        panel.add(nameField, gbc);
        gbc.gridx = 4;
        gbc.gridwidth = 1;
        JButton addSubtaskButton = new JButton("+");
        addSubtaskButton.setPreferredSize(SMALL_BUTTON_DIMENSION);
        panel.add(addSubtaskButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 6;
        panel.add(new JLabel(), gbc);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (task.getCurrentList().equals(ImportantList.getInstance())) {
                    updateRightPanel(ImportantListPage.showList(task.getCurrentList()));
                } else {
                    updateRightPanel(ListSpecificPage.showSpecificList(task.getCurrentList()));
                }
            }
        });

        addSubtaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if (name != null && !name.isEmpty()) {
                    Subtask newSubtask = new Subtask();
                    newSubtask.setName(name);
                    task.addSubtask(newSubtask);
                    updateRightPanel(TaskPage.showTask(task));
                }
            }
        });

        return panel;
    }
}

package view;

import content.Habit;
import content.HabitsList;
import utils.Recurrence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;

public class HabitPage extends Page {

    private static final String DATA_FILE = "habits_data_" + currentUser.getEmail() + ".ser";

    private ArrayList<HabitsList> habitsLists;
    private DefaultListModel<String> habitsListModel;
    private JList<String> habitsList;
    private DefaultListModel<Habit> displayedHabitsModel;
    private JList<Habit> displayedHabitsList;



    public HabitPage() {
        initComponents();
        loadHabitData();
        checkCompletion();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveHabitData();
            }
        });
    }

    private void initComponents() {

        setSize(ProductivityPage.WIDTH, ProductivityPage.HEIGHT);

        setLayout(new BorderLayout());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveHabitData();
                changeTo(homePage);
            }
        });

        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.add(backButton);
        add(backButtonPanel, BorderLayout.NORTH);

        JPanel habitsListsPanel = new JPanel(new BorderLayout());
        habitsListsPanel.setBorder(BorderFactory.createTitledBorder("Habits Lists"));

        // habitsLists = new ArrayList<>();

        habitsListModel = new DefaultListModel<>();
        habitsList = new JList<>(habitsListModel);
        habitsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        habitsList.addListSelectionListener(e -> {
            updateDisplayedHabits();
        });

        habitsListsPanel.add(new JScrollPane(habitsList), BorderLayout.CENTER);

        JButton createListButton = new JButton("Create List");
        createListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewHabitsList();
            }
        });

        JButton removeListButton = new JButton("Remove List");
        removeListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSelectedHabitsList();
            }
        });

        removeListButton.setPreferredSize(new Dimension(120, 26));

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.add(createListButton);
        buttonsPanel.add(removeListButton);

        habitsListsPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(habitsListsPanel, BorderLayout.WEST);

        JPanel displayedHabitsPanel = new JPanel(new BorderLayout());
        displayedHabitsPanel.setBorder(BorderFactory.createTitledBorder("Displayed Habits"));

        JPanel labelsPanel = new JPanel(new GridLayout(1, 7));
        labelsPanel.add(new JLabel("Name"));
        labelsPanel.add(new JLabel("Category"));
        labelsPanel.add(new JLabel("Goal"));
        labelsPanel.add(new JLabel("Recurrence"));
        labelsPanel.add(new JLabel("Completion Count"));
        labelsPanel.add(new JLabel("Progress"));
        labelsPanel.add(new JLabel(""));

        displayedHabitsPanel.add(labelsPanel, BorderLayout.NORTH);

        displayedHabitsModel = new DefaultListModel<>();
        displayedHabitsList = new JList<>(displayedHabitsModel);
        displayedHabitsList.setCellRenderer(new HabitCellRenderer());
        displayedHabitsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        displayedHabitsPanel.add(new JScrollPane(displayedHabitsList), BorderLayout.CENTER);

        JButton checkAsCompletedButton = new JButton("Mark/Unmark Habit");
        checkAsCompletedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelectedHabitAsCompleted();
            }
        });

        JButton addHabitButton = new JButton("Add Habit");
        addHabitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewHabit();
            }
        });

        JButton removeHabitButton = new JButton("Remove Habit");
        removeHabitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSelectedHabit();
            }
        });

        JButton clearHabitsButton = new JButton("Clear Habits");
        clearHabitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearHabitsList();
            }
        });

        JButton orderHabitsButton = new JButton("Order Habits");
        orderHabitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOrderOptions();
            }
        });

        JPanel habitButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        habitButtonsPanel.add(addHabitButton);
        habitButtonsPanel.add(removeHabitButton);
        habitButtonsPanel.add(clearHabitsButton);
        habitButtonsPanel.add(orderHabitsButton);
        habitButtonsPanel.add(checkAsCompletedButton);

        displayedHabitsPanel.add(habitButtonsPanel, BorderLayout.SOUTH);

        add(displayedHabitsPanel, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    private void loadHabitData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            habitsLists = (ArrayList<HabitsList>) ois.readObject();
            updateHabitsListModel();
        } catch (IOException | ClassNotFoundException e) {
            habitsLists = new ArrayList<>();
        }
    }

    private void saveHabitData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(habitsLists);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateHabitsListModel() {
        habitsListModel.removeAllElements();
        for (HabitsList habitsList : currentUser.getHabitLists()) {
            habitsListModel.addElement(habitsList.getCategory());
        }
    }

    private void showOrderOptions() {
        String[] options = {"Default", "By Name", "By Category", "By Goal (Ascending)", "By Goal (Descending)"};
        String selectedOption = (String) JOptionPane.showInputDialog(this, "Select order option:", "Order Habits",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (selectedOption != null) {
            int selectedListIndex = habitsList.getSelectedIndex();
            if (selectedListIndex >= 0 && selectedListIndex < currentUser.getHabitLists().size()) {
                HabitsList selectedList = currentUser.getHabitLists().get(selectedListIndex);
                selectedList.habitChangeOrder(getOrderByOption(selectedOption));

                updateDisplayedHabits();
            }
        }
    }

    private String getOrderByOption(String selectedOption) {
        switch (selectedOption) {
            case "By Name":
                return "name";
            case "By Category":
                return "category";
            case "By Goal (Ascending)":
                return "goalAscending";
            case "By Goal (Descending)":
                return "goalDescending";
            default:
                return "";
        }
    }

    private void clearHabitsList() {
        int selectedListIndex = habitsList.getSelectedIndex();
        if (selectedListIndex >= 0 && selectedListIndex < currentUser.getHabitLists().size()) {
            HabitsList selectedList = currentUser.getHabitLists().get(selectedListIndex);

            if (selectedList.clearList()) {
                displayedHabitsModel.removeAllElements();
            }
        }
    }

    private void createNewHabitsList() {
        String listCategory = JOptionPane.showInputDialog(this, "Enter the category of the new habits list:");
        if (listCategory != null && !listCategory.trim().isEmpty()) {
            HabitsList newList = new HabitsList(listCategory);
            currentUser.getHabitLists().add(newList);
            habitsListModel.addElement(listCategory);
        }
    }

    private void removeSelectedHabitsList() {
        int selectedIndex = habitsList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < currentUser.getHabitLists().size()) {
            currentUser.getHabitLists().remove(selectedIndex);
            habitsListModel.remove(selectedIndex);

            displayedHabitsModel.removeAllElements();
            habitsList.clearSelection();
        }
    }

    private void addNewHabit() {
        int selectedListIndex = habitsList.getSelectedIndex();
        if (selectedListIndex >= 0 && selectedListIndex < currentUser.getHabitLists().size()) {
            HabitsList selectedList = currentUser.getHabitLists().get(selectedListIndex);
            String habitName = JOptionPane.showInputDialog(this, "Enter the name of the new habit:");
            if (habitName != null && !habitName.trim().isEmpty()) {

                String habitCategory = JOptionPane.showInputDialog(this, "Enter the category for the habit:");

                Recurrence.RecurrenceType[] recurrenceTypes = Recurrence.RecurrenceType.values();

                JComboBox<Recurrence.RecurrenceType> recurrenceComboBox = new JComboBox<>(recurrenceTypes);
                int option = JOptionPane.showConfirmDialog(this, recurrenceComboBox, "Choose Recurrence", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    Recurrence.RecurrenceType selectedRecurrence = recurrenceComboBox.getItemAt(recurrenceComboBox.getSelectedIndex());

                    int goal = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the goal for the habit:"));


                    if (selectedList.addHabit(new Habit(habitName, habitCategory, new Recurrence(selectedRecurrence), goal))) {
                        displayedHabitsModel.addElement(selectedList.searchHabit(habitName));
                        displayedHabitsList.setSelectedIndex(displayedHabitsModel.size() - 1);
                    } else {
                        JOptionPane.showMessageDialog(this, "Habit with the same name already exists in the list.");
                    }
                }
            }
        }
    }

    private void removeSelectedHabit() {
        int selectedIndex = displayedHabitsList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < displayedHabitsModel.size()) {

            Habit habitToRemove = displayedHabitsModel.getElementAt(selectedIndex);
            displayedHabitsModel.remove(selectedIndex);

            int selectedListIndex = habitsList.getSelectedIndex();
            if (selectedListIndex >= 0 && selectedListIndex < currentUser.getHabitLists().size()) {
                HabitsList selectedList = currentUser.getHabitLists().get(selectedListIndex);

                selectedList.removeHabit(habitToRemove.getName());
            }
        }
    }

    private void markSelectedHabitAsCompleted() {
        int selectedIndex = displayedHabitsList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < displayedHabitsModel.size()) {
            Habit selectedHabit = displayedHabitsModel.getElementAt(selectedIndex);
            selectedHabit.changeStatus();
            displayedHabitsModel.setElementAt(selectedHabit, selectedIndex);
        }
    }

    private void updateDisplayedHabits() {
        int selectedListIndex = habitsList.getSelectedIndex();
        if (selectedListIndex >= 0 && selectedListIndex < currentUser.getHabitLists().size()) {
            HabitsList selectedList = currentUser.getHabitLists().get(selectedListIndex);

            displayedHabitsModel.removeAllElements();
            displayedHabitsModel.addAll(selectedList.getHabits());
        }
    }

    private static class HabitCellRenderer extends JPanel implements ListCellRenderer<Habit> {
        private JLabel nameLabel = new JLabel();
        private JLabel categoryLabel = new JLabel();
        private JLabel goalLabel = new JLabel();
        private JLabel recurrenceLabel = new JLabel();
        private JLabel completionCountLabel = new JLabel();
        private JLabel progressionLabel = new JLabel();
        private JCheckBox completionCheckBox = new JCheckBox();

        public HabitCellRenderer() {
            setLayout(new GridLayout(1, 6));
            add(nameLabel);
            add(categoryLabel);
            add(goalLabel);
            add(recurrenceLabel);
            add(completionCountLabel);
            add(progressionLabel);
            add(completionCheckBox);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Habit> list, Habit value, int index, boolean isSelected, boolean cellHasFocus) {
            nameLabel.setText(value.getName());
            categoryLabel.setText(value.getCategory());
            goalLabel.setText(String.valueOf(value.getGoal()));
            recurrenceLabel.setText(value.getRecurrence().toString());
            completionCountLabel.setText(String.valueOf(value.getCompletionCount()));
            progressionLabel.setText(String.format("%.1f%%", value.getProgress()));

            completionCheckBox.setSelected(value.isComplete());
            completionCheckBox.setEnabled(false);

            setBackground(isSelected ? Color.YELLOW : list.getBackground());

            return this;
        }
    }

    private void checkCompletion() {
        for (HabitsList habitsList : currentUser.getHabitLists()) {
            ArrayList<Habit> allHabits = habitsList.getHabits();
            for (Habit habit : allHabits) {
                habit.checkCompletion();
            }
        }
        updateDisplayedHabits();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HabitPage().setVisible(true);
            }
        });
    }
}
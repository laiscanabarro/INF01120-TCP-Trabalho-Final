package view;

import content.HabitsList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class HomePage extends Page {
    public static final int dividerPosition = 190;
    private static final JSplitPane splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    private static JPanel contentPanel;
    private static final JPanel sideMenu = new JPanel();
    private static final int buttonWidth = dividerPosition - 10;
    private static final int buttonHeight = 25;
    private static final Dimension buttonDimension = new Dimension(buttonWidth, buttonHeight);
    private static final JFrame userInfoPageAt = new UserInfoPage();
    private static final String DATA_FILE = "habits_data_" + currentUser.getEmail() + ".ser";

    public HomePage() {
        super();
        setLocationRelativeTo(null);
        sideMenu.setOpaque(true);
        sideMenu.setBackground(Color.WHITE);
        sideMenu.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        loadHabitData();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        JButton profileButton = new JButton(String.valueOf(LoginPage.currentUser.getEmail()));
        profileButton.setPreferredSize(buttonDimension);
        sideMenu.add(profileButton, gbc);

        gbc.gridy++;
        JButton listsButton = new JButton("All Lists");
        listsButton.setPreferredSize(buttonDimension);
        sideMenu.add(listsButton, gbc);

        gbc.gridy++;
        JButton habitsButton = new JButton("Habits");
        habitsButton.setPreferredSize(buttonDimension);
        sideMenu.add(habitsButton, gbc);

        gbc.gridy++;
        JButton calendarButton = new JButton("Calendar");
        calendarButton.setPreferredSize(buttonDimension);
        sideMenu.add(calendarButton, gbc);

        gbc.gridy++;
        JButton productivityButton = new JButton("Productivity");
        productivityButton.setPreferredSize(buttonDimension);
        sideMenu.add(productivityButton, gbc);

        gbc.gridy++;
        JButton signOutButton = new JButton("Sign Out");
        signOutButton.setPreferredSize(buttonDimension);
        sideMenu.add(signOutButton, gbc);

        //Componente em branco/preenchimento
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        sideMenu.add(new JLabel(), gbc);

        if (contentPanel == null) {
            contentPanel = new JPanel();
            contentPanel.setOpaque(true);
            contentPanel.setBackground(Color.WHITE);
        }

        splitPanel.setLeftComponent(sideMenu);
        splitPanel.setOneTouchExpandable(false);
        splitPanel.setDividerSize(1);
        updateRightPanel(contentPanel);

        add(splitPanel, BorderLayout.CENTER);

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeTo(userInfoPageAt);
            }
        });

        listsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRightPanel(ListsPage.showLists());
            }
        });

        habitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame habitPage = new HabitPage();
                changeTo(habitPage);
            }
        });

        calendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel newPanel = new JPanel();
                newPanel.setOpaque(true);
                newPanel.setBackground(Color.ORANGE);
                updateRightPanel(newPanel);
            }
        });

        productivityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductivityPage productivityPage = new ProductivityPage();
                changeTo(productivityPage);
            }
        });

        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            };
        });
    }

    public static void updateRightPanel(JPanel newPanel) {
        splitPanel.setRightComponent(newPanel);
        splitPanel.setDividerLocation(dividerPosition);
    }

    @SuppressWarnings("unchecked")
    private void loadHabitData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            currentUser.setHabitLists((ArrayList<HabitsList>) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            currentUser.setHabitLists(new ArrayList<>());
        }
    }
}

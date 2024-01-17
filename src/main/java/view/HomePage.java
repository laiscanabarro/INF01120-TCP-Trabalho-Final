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
    public static final int DIVIDER_POSITION = 190;
    private static final JSplitPane SPLIT_PANEL = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    private static JPanel contentPanel;
    private static final JPanel SIDEMENU = new JPanel();
    private static final int BUTTON_WIDTH = DIVIDER_POSITION - 10;
    private static final int BUTTON_HEIGHT = 25;
    private static final Dimension BUTTON_DIMENSION = new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT);
    private static final JFrame USER_INFO_PAGE = new UserInfoPage();
    private static final String DATA_FILE = "habits_data_" + currentUser.getEmail() + ".ser";

    public HomePage() {
        super();
        setLocationRelativeTo(null);
        SIDEMENU.setOpaque(true);
        SIDEMENU.setBackground(Color.WHITE);
        SIDEMENU.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        loadHabitData();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        JButton profileButton = new JButton(String.valueOf(LoginPage.currentUser.getEmail()));
        profileButton.setPreferredSize(BUTTON_DIMENSION);
        SIDEMENU.add(profileButton, gbc);

        gbc.gridy++;
        JButton listsButton = new JButton("All Lists");
        listsButton.setPreferredSize(BUTTON_DIMENSION);
        SIDEMENU.add(listsButton, gbc);

        gbc.gridy++;
        JButton habitsButton = new JButton("Habits");
        habitsButton.setPreferredSize(BUTTON_DIMENSION);
        SIDEMENU.add(habitsButton, gbc);

        gbc.gridy++;
        JButton calendarButton = new JButton("Calendar");
        calendarButton.setPreferredSize(BUTTON_DIMENSION);
        SIDEMENU.add(calendarButton, gbc);

        gbc.gridy++;
        JButton productivityButton = new JButton("Productivity");
        productivityButton.setPreferredSize(BUTTON_DIMENSION);
        SIDEMENU.add(productivityButton, gbc);

        gbc.gridy++;
        JButton signOutButton = new JButton("Sign Out");
        signOutButton.setPreferredSize(BUTTON_DIMENSION);
        SIDEMENU.add(signOutButton, gbc);

        //Componente em branco/preenchimento
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        SIDEMENU.add(new JLabel(), gbc);

        if (contentPanel == null) {
            contentPanel = new JPanel();
            contentPanel.setOpaque(true);
            contentPanel.setBackground(Color.WHITE);
        }

        SPLIT_PANEL.setLeftComponent(SIDEMENU);
        SPLIT_PANEL.setOneTouchExpandable(false);
        SPLIT_PANEL.setDividerSize(1);
        updateRightPanel(contentPanel);

        add(SPLIT_PANEL, BorderLayout.CENTER);

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeTo(USER_INFO_PAGE);
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
                CalendarPage calendarPage = new CalendarPage(Page.currentUser.getCalendar());
                changeTo(calendarPage);
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
        SPLIT_PANEL.setRightComponent(newPanel);
        SPLIT_PANEL.setDividerLocation(DIVIDER_POSITION);
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

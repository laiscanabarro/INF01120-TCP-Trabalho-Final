package view;

import content.TaskList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends Page {
    public static final int dividerPosition = 190;
    private static final JSplitPane splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    private static JPanel contentPanel;
    private static final JPanel sideMenu = new JPanel();
    private static final int buttonWidth = dividerPosition - 10;
    private static final int buttonHeight = 25;
    private static final Dimension buttonDimension = new Dimension(buttonWidth, buttonHeight);
    private static final JFrame userInfoPageAt = new UserInfoPage();

    public HomePage() {
        super();
        setLocationRelativeTo(null);
        sideMenu.setOpaque(true);
        sideMenu.setBackground(Color.WHITE);
        sideMenu.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JButton profileButton = generalButton(String.valueOf(LoginPage.currentUser.getEmail().toUpperCase().charAt(0)), new Dimension(50,50), hilightColor);
        sideMenu.add(profileButton, gbc);
        gbc.gridx++;
        JLabel title = new JLabel(String.valueOf(LoginPage.currentUser.getEmail()));
        sideMenu.add(title, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth++;
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

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        JButton addListButton = new JButton("+");
        addListButton.setPreferredSize(new Dimension(50,buttonHeight));
        sideMenu.add(addListButton, gbc);
        gbc.gridx++;
        JLabel addListLabel = new JLabel("New List");
        sideMenu.add(addListLabel, gbc);

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
            	JFrame habitPage = new HabitPage(currentUser.getEmail());
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

        addListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRightPanel(NewListPage.createList());
            }
        });

//        bnt6.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            };
//        });
    }

    public static JButton generalButton(String label, Dimension size, Color background) {
        JButton button = new JButton(label);
        button.setForeground(Color.WHITE);
        button.setPreferredSize(size);
//        button.setBorder(new RoundedBorder(0));
        button.setBackground(background);

        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);

        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        return button;
    }

    public static void updateRightPanel(JPanel newPanel) {
        splitPanel.setRightComponent(newPanel);
        splitPanel.setDividerLocation(dividerPosition);
    }
}

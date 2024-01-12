package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductivityPage extends Page {
    private static JPanel contentPanel;
    private static final int dividerPosition = 190;
    private static final int buttonWidth = dividerPosition - 10;
    private static final int buttonHeight = 25;

    public ProductivityPage() {
        super();
        setLocationRelativeTo(null);
        JPanel sideMenu = new JPanel();
        sideMenu.setOpaque(true);
        sideMenu.setBackground(Color.WHITE);
        sideMenu.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JButton profileButton = profileButton(String.valueOf(LoginPage.currentUser.getEmail().toUpperCase().charAt(0)));
        sideMenu.add(profileButton, gbc);
        gbc.gridx++;
        JLabel title = new JLabel(String.valueOf(LoginPage.currentUser.getEmail()));
        sideMenu.add(title, gbc);

        gbc.gridx--;
        gbc.gridy++;
        gbc.gridwidth++;
        JButton bnt1 = new JButton("P1");
        bnt1.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        sideMenu.add(bnt1, gbc);

        gbc.gridy++;
        JButton bnt2 = new JButton("P2");
        bnt2.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        sideMenu.add(bnt2, gbc);

        gbc.gridy++;
        JButton bnt3 = new JButton("Teste 3");
        bnt3.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        sideMenu.add(bnt3, gbc);

        gbc.gridy++;
        JButton bnt4 = new JButton("Teste 4");
        bnt4.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        sideMenu.add(bnt4, gbc);

        gbc.gridy++;
        JButton bnt5 = new JButton("Teste 5");
        bnt5.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        sideMenu.add(bnt5, gbc);

        gbc.gridy++;
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        sideMenu.add(backButton, gbc);

        gbc.gridy++;
        JButton bnt6 = new JButton("Exit");
        bnt6.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        sideMenu.add(bnt6, gbc);


        //Componente em branco/preenchimento
        gbc.gridx++;
        gbc.gridy++;
        gbc.weightx = 1;
        gbc.weighty = 1;
        sideMenu.add(new JLabel(), gbc);

        if (contentPanel == null) {
            contentPanel = new JPanel();
            contentPanel.setOpaque(true);
            contentPanel.setBackground(Color.WHITE);
        }

        JSplitPane splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                sideMenu, contentPanel);
        splitPanel.setOneTouchExpandable(true);
        splitPanel.setDividerLocation(dividerPosition);
        splitPanel.setDividerSize(1);

        add(splitPanel, BorderLayout.CENTER);

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
            }
        });
        bnt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel newPanel = new JPanel();
                newPanel.setOpaque(true);
                newPanel.setBackground(Color.RED);
                splitPanel.setRightComponent(newPanel);
                splitPanel.setDividerLocation(dividerPosition);
//                setContentPane(newPanel);
//                invalidate();
//                validate();
            }
        });
        bnt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel newPanel = new JPanel();
                newPanel.setOpaque(true);
                newPanel.setBackground(Color.GREEN);
                splitPanel.setRightComponent(newPanel);
                splitPanel.setDividerLocation(dividerPosition);
            }
        });
        bnt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel newPanel = new JPanel();
                newPanel.setOpaque(true);
                newPanel.setBackground(Color.ORANGE);
                splitPanel.setRightComponent(newPanel);
                splitPanel.setDividerLocation(dividerPosition);
            }
        });
        bnt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel newPanel = new JPanel();
                newPanel.setOpaque(true);
                newPanel.setBackground(Color.YELLOW);
                splitPanel.setRightComponent(newPanel);
                splitPanel.setDividerLocation(dividerPosition);
            }
        });

        bnt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel newPanel = new JPanel();
                newPanel.setOpaque(true);
                newPanel.setBackground(Color.PINK);
                splitPanel.setRightComponent(newPanel);
                splitPanel.setDividerLocation(dividerPosition);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Back to the homePage
                changeTo(homePage);
            }
        });

        bnt6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            };
        });
    }

    private static JButton profileButton(String label) {

        int size = 50;
        JButton button = new JButton(label);
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(size, size));
//        button.setBorder(new RoundedBorder(0));
        button.setBackground(hilightColor);

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
}

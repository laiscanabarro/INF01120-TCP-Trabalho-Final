
package view;
import java.awt.*;

public class ProductivityPage extends Page {

    /**
     * Creates new form ProductivityPage
     */
    public ProductivityPage() {
        initComponents();
    }

    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        taskGoalLabel = new javax.swing.JLabel();
        increaseTaskGoalBtn = new javax.swing.JButton();
        decreaseTaskGoalBtn = new javax.swing.JButton();
        habitGoalLabel = new javax.swing.JLabel();
        increaseHabitGoalBtn = new javax.swing.JButton();
        decreaseHabitGoalBtn = new javax.swing.JButton();
        taskProgressLabel = new javax.swing.JLabel();
        habitProgressLabel = new javax.swing.JLabel();
        compHabitsLabel = new javax.swing.JLabel();
        compTasksLabel = new javax.swing.JLabel();
        dailyGoalLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));

        Page.currentUser.updateProductivity();

        titleLabel.setFont(new java.awt.Font("Geeza Pro", 1, 48)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Productivity");

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        taskGoalLabel.setFont(new java.awt.Font("Helvetica", 0, 18)); // NOI18N
        taskGoalLabel.setText(Page.currentUser.getProductivity().getDailyTaskGoal() + " tasks");

        increaseTaskGoalBtn.setText("+");
        increaseTaskGoalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseTaskGoalBtnActionPerformed(evt);
            }
        });

        decreaseTaskGoalBtn.setText("-");
        decreaseTaskGoalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseTaskGoalBtnActionPerformed(evt);
            }
        });

        habitGoalLabel.setFont(new java.awt.Font("Helvetica", 0, 18)); // NOI18N
        habitGoalLabel.setText(Page.currentUser.getProductivity().getDailyHabitGoal() + " habits"
        );

        increaseHabitGoalBtn.setText("+");
        increaseHabitGoalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseHabitGoalBtnActionPerformed(evt);
            }
        });

        decreaseHabitGoalBtn.setText("-");
        decreaseHabitGoalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseHabitGoalBtnActionPerformed(evt);
            }
        });

        taskProgressLabel.setFont(new java.awt.Font("Helvetica", 0, 18)); // NOI18N
        // LoginPage.currentUser.updateProductivity();
        double taskProgress = Page.currentUser.getProductivity().getDailyTaskProgress();
        String formattedTaskProgress = String.format("%.2f", taskProgress);
        taskProgressLabel.setText(formattedTaskProgress + "%");

        habitProgressLabel.setFont(new java.awt.Font("Helvetica", 0, 18)); // NOI18N
        // LoginPage.currentUser.updateProductivity();
        Page.currentUser.getProductivity().calculateDailyHabitProgress();
        double habitProgress = Page.currentUser.getProductivity().getDailyHabitProgress();
        String formattedHabitProgress = String.format("%.2f", habitProgress);
        habitProgressLabel.setText(formattedHabitProgress + "%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2.setBackground(Color.WHITE);
        jPanel2.setOpaque(true);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(habitGoalLabel)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(increaseHabitGoalBtn)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
                                                                .addComponent(habitProgressLabel))
                                                        .addComponent(decreaseHabitGoalBtn)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(taskGoalLabel)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(increaseTaskGoalBtn)
                                                        .addComponent(decreaseTaskGoalBtn))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(taskProgressLabel)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(increaseTaskGoalBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(decreaseTaskGoalBtn))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(taskGoalLabel))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(taskProgressLabel)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(habitGoalLabel))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(increaseHabitGoalBtn)
                                                        .addComponent(habitProgressLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(decreaseHabitGoalBtn)))
                                .addContainerGap(103, Short.MAX_VALUE))
        );

        compHabitsLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        currentUser.updateProductivity();
        compHabitsLabel.setText(currentUser.getProductivity().getHabitsCompletedToday() + " completed habits");

        compTasksLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        currentUser.updateProductivity();
        compTasksLabel.setText(currentUser.getProductivity().getTasksCompletedToday() + " completed tasks");

        dailyGoalLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        dailyGoalLabel.setText("Daily goal");


        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel9.setText("Daily progress");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.WHITE);
        setOpacity(1.0f);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(dailyGoalLabel)
                                                .addGap(349, 349, 349)
                                                .addComponent(jLabel9))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(133, 133, 133)
                                                        .addComponent(titleLabel))))
                                .addContainerGap(149, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(compTasksLabel)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(compHabitsLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addComponent(backBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(22, 22, 22)
                                .addGap(1, 1, 1)
                                .addComponent(compTasksLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(compHabitsLabel))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dailyGoalLabel)
                                        .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(122, 122, 122))
        );

        pack();
    }// </editor-fold>

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {
        changeTo(homePage);
    }


    private void increaseTaskGoalBtnActionPerformed(java.awt.event.ActionEvent evt) {
        Page.currentUser.getProductivity().increaseDailyTaskGoal();
        taskGoalLabel.setText(Page.currentUser.getProductivity().getDailyTaskGoal() + " tasks");
        Page.currentUser.getProductivity().calculateDailyTaskProgress();
        double taskProgress = Page.currentUser.getProductivity().getDailyTaskProgress();
        String formattedTaskProgress = String.format("%.2f", taskProgress);
        taskProgressLabel.setText(formattedTaskProgress + "%");
    }

    private void decreaseTaskGoalBtnActionPerformed(java.awt.event.ActionEvent evt) {
        Page.currentUser.getProductivity().decreaseDailyTaskGoal();
        taskGoalLabel.setText(Page.currentUser.getProductivity().getDailyTaskGoal() + " tasks");
        Page.currentUser.getProductivity().calculateDailyTaskProgress();
        double taskProgress = Page.currentUser.getProductivity().getDailyTaskProgress();
        String formattedTaskProgress = String.format("%.2f", taskProgress);
        taskProgressLabel.setText(formattedTaskProgress + "%");
    }

    private void increaseHabitGoalBtnActionPerformed(java.awt.event.ActionEvent evt) {
        Page.currentUser.getProductivity().increaseDailyHabitGoal();
        habitGoalLabel.setText(Page.currentUser.getProductivity().getDailyHabitGoal() + " habits");
        double habitProgress = Page.currentUser.getProductivity().getDailyHabitProgress();
        String formattedHabitProgress = String.format("%.2f", habitProgress);
        habitProgressLabel.setText(formattedHabitProgress + "%");
    }

    private void decreaseHabitGoalBtnActionPerformed(java.awt.event.ActionEvent evt) {
        Page.currentUser.getProductivity().decreaseDailyHabitGoal();
        habitGoalLabel.setText(Page.currentUser.getProductivity().getDailyHabitGoal() + " habits");
        double habitProgress = Page.currentUser.getProductivity().getDailyHabitProgress();
        String formattedHabitProgress = String.format("%.2f", habitProgress);
        habitProgressLabel.setText(formattedHabitProgress + "%");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductivityPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductivityPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductivityPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductivityPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductivityPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel compHabitsLabel;
    private javax.swing.JLabel compTasksLabel;
    private javax.swing.JButton decreaseHabitGoalBtn;
    private javax.swing.JButton decreaseTaskGoalBtn;
    private javax.swing.JLabel habitGoalLabel;
    private javax.swing.JLabel habitProgressLabel;
    private javax.swing.JButton increaseHabitGoalBtn;
    private javax.swing.JButton increaseTaskGoalBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel dailyGoalLabel;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel taskGoalLabel;
    private javax.swing.JLabel taskProgressLabel;
    // End of variables declaration
}

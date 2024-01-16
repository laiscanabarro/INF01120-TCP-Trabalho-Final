/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import content.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import utils.PageUtils;
import static view.Page.homePage;

/**
 *
 * @author laisa
 */
public class CalendarPage extends Page {
    private static Calendar calendar;
    private static LocalDate date;
    
    /**
     * Creates new form CalenderPage
     * @param calendar
     * @param date
     */
    public CalendarPage(Calendar calendar, LocalDate date) {
        CalendarPage.calendar = calendar;
        CalendarPage.date = date;
        initComponents();
    }
    
    public CalendarPage(Calendar calendar) {
        CalendarPage.calendar = calendar;
        CalendarPage.date = LocalDate.now();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        setSize(WIDTH, HEIGHT);
        panelCalendar = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        labelMonthYear = new javax.swing.JLabel();
        textFieldTask = new javax.swing.JTextField();
        textFieldEvent = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCalendar =  new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSchedule = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TaDa - Calendar");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 1280, 720));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);
        setSize(new java.awt.Dimension(1280, 720));

        panelCalendar.setBackground(new java.awt.Color(255, 255, 255));
        panelCalendar.setPreferredSize(new java.awt.Dimension(1280, 720));

        labelTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(51, 51, 51));
        labelTitle.setText("Calendar");

        backButton.setForeground(new java.awt.Color(51, 51, 51));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        labelMonthYear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelMonthYear.setForeground(new java.awt.Color(51, 51, 51));
        //LocalDate today = LocalDate.now();
        labelMonthYear.setText(calendar.displayMonthYear(date));
        labelMonthYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMonthYearMouseClicked(evt);
            }
        });

        textFieldTask.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textFieldTask.setForeground(new java.awt.Color(153, 153, 153));
        textFieldTask.setText("New task");
        textFieldTask.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textFieldTask.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        textFieldTask.setDoubleBuffered(true);
        textFieldTask.setDragEnabled(true);
        textFieldTask.setMargin(new java.awt.Insets(2, 16, 2, 6));
        textFieldTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldTaskMouseClicked(evt);
            }
        });
        textFieldTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTaskActionPerformed(evt);
            }
        });

        textFieldEvent.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textFieldEvent.setForeground(new java.awt.Color(153, 153, 153));
        textFieldEvent.setText("New event");
        textFieldEvent.setMargin(new java.awt.Insets(2, 16, 2, 6));
        textFieldEvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldEventMouseClicked(evt);
            }
        });
        textFieldEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldEventActionPerformed(evt);
            }
        });

        tableCalendar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableCalendar.setForeground(new java.awt.Color(51, 51, 51));
        tableCalendar.setModel(new javax.swing.table.DefaultTableModel(
            (Object[][]) calendar.displayCalendar(date),
            new String [] {
                "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
            }
        ));
        tableCalendar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableCalendar.setCellSelectionEnabled(true);
        tableCalendar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableCalendar.setName(""); // NOI18N
        tableCalendar.setRowHeight(37);
        tableCalendar.setSelectionBackground(new java.awt.Color(0, 51, 255));
        tableCalendar.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableCalendar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableCalendar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableCalendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCalendarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableCalendar);

        tableSchedule.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableSchedule.setForeground(new java.awt.Color(51, 51, 51));
        tableSchedule.setModel(new javax.swing.table.DefaultTableModel(
            (Object [][]) calendar.searchSchedule(date).displaySchedule(),
            new String [] {
                "Tasks", "Events"
            }
        ));
        tableSchedule.setCellSelectionEnabled(true);
        tableSchedule.setRowHeight(30);
        tableSchedule.setSelectionBackground(new java.awt.Color(0, 51, 255));
        tableSchedule.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableSchedule.setShowVerticalLines(true);
        tableSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableScheduleMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableSchedule);

        javax.swing.GroupLayout panelCalendarLayout = new javax.swing.GroupLayout(panelCalendar);
        panelCalendar.setLayout(panelCalendarLayout);
        panelCalendarLayout.setHorizontalGroup(
            panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCalendarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(backButton)
                .addGap(36, 36, 36)
                .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCalendarLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                            .addComponent(labelMonthYear)
                            .addComponent(textFieldTask)
                            .addComponent(textFieldEvent)
                            .addComponent(jScrollPane3))))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        panelCalendarLayout.setVerticalGroup(
            panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCalendarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(labelMonthYear)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textFieldTask, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textFieldEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        changeTo(homePage);
    }//GEN-LAST:event_backButtonActionPerformed

    private void labelMonthYearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMonthYearMouseClicked
        displayMonth();
    }//GEN-LAST:event_labelMonthYearMouseClicked

    private void textFieldTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFieldTaskMouseClicked
        textFieldTask.setText(null);
    }//GEN-LAST:event_textFieldTaskMouseClicked

    private void textFieldEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFieldEventMouseClicked
        textFieldEvent.setText(null);
    }//GEN-LAST:event_textFieldEventMouseClicked

    private void textFieldTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTaskActionPerformed
        int day = showDate();
        System.out.println(day);
        
        if (day != -1) {
            String text = textFieldTask.getText();
            if (text != null && !text.trim().isEmpty()) {
                Task newTask = new Task(text, date);
                TaskList tasklist = new TaskList(); //arrumar isso, vai para uma list de allTask
                calendar.addTask(newTask, tasklist);
                setTableSchedule(date, true);
            }
        }

        textFieldTask.setText("New Task");
    }//GEN-LAST:event_textFieldTaskActionPerformed

    private void textFieldEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldEventActionPerformed
        int day = showDate();
        
        if (day != -1) {
           String text = textFieldEvent.getText();
            if (text != null && !text.trim().isEmpty()) {
                Event newEvent = new Event(text, date);
                calendar.addEvent(newEvent);
                setTableSchedule(date, true);
            } 
        }
        
        textFieldEvent.setText("New Event");
    }//GEN-LAST:event_textFieldEventActionPerformed

    private void tableCalendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCalendarMouseClicked
        int day = showDate();
        int month = CalendarPage.date.getMonthValue();
        int year = CalendarPage.date.getYear();

                
        if (day != -1) {
            LocalDate selectedDay = LocalDate.of(year, month, day);
            CalendarPage.date = selectedDay;           
            setTableSchedule(date, true); 
            
        }
        else {
            setTableSchedule(date, false);
        }

    }//GEN-LAST:event_tableCalendarMouseClicked

    private void tableScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableScheduleMouseClicked
        int col = tableSchedule.getSelectedColumn();
        int row = tableSchedule.getSelectedRow();        
        String selected = calendar.searchSchedule(date).displaySchedule()[row][col].toString();
        
        if (selected != null && col == 0) {
            Task task = calendar.searchTask(selected);
            TaskPage.showTask(task);
        }
        else if (selected != null && col == 1) {
            Event event = calendar.searchEvent(selected);
            EventPage eventPage = new EventPage(event, calendar);
            changeTo(eventPage);
        }
    }//GEN-LAST:event_tableScheduleMouseClicked

    private int showDate(){
        int col = tableCalendar.getSelectedColumn();
        int row = tableCalendar.getSelectedRow();
        int day = calendar.displayDay(col, row, (Object[][]) calendar.displayCalendar(date));
        
        return day;
    }
    
    private void displayMonth() {
        JPanel panelMonth = new JPanel();
        panelMonth.setLayout(new GridLayout(4, 4));   
        
        // Creates a RadioButton with associated text
        JRadioButton januaryCheckBox = new JRadioButton ("January");
        JRadioButton februaryCheckBox = new JRadioButton ("February");
        JRadioButton marchCheckBox = new JRadioButton ("March");
        JRadioButton aprilCheckBox = new JRadioButton ("April");
        JRadioButton mayCheckBox = new JRadioButton ("May");
        JRadioButton juneCheckBox = new JRadioButton ("June");
        JRadioButton julyCheckBox = new JRadioButton ("July");
        JRadioButton augustCheckBox = new JRadioButton ("August");
        JRadioButton setemberCheckBox = new JRadioButton ("Setemeber");
        JRadioButton octoberCheckBox = new JRadioButton ("October");
        JRadioButton novemberCheckBox = new JRadioButton ("November");
        JRadioButton decemberCheckBox = new JRadioButton ("December");
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(januaryCheckBox);
        buttonGroup.add(februaryCheckBox);
        buttonGroup.add(marchCheckBox);
        buttonGroup.add(aprilCheckBox);
        buttonGroup.add(mayCheckBox);
        buttonGroup.add(juneCheckBox);
        buttonGroup.add(julyCheckBox);
        buttonGroup.add(augustCheckBox);
        buttonGroup.add(setemberCheckBox);
        buttonGroup.add(octoberCheckBox);
        buttonGroup.add(novemberCheckBox);
        buttonGroup.add(decemberCheckBox);
        
        panelMonth.add(januaryCheckBox);
        panelMonth.add(februaryCheckBox);
        panelMonth.add(marchCheckBox);
        panelMonth.add(aprilCheckBox);
        panelMonth.add(mayCheckBox);
        panelMonth.add(juneCheckBox);
        panelMonth.add(julyCheckBox);
        panelMonth.add(augustCheckBox);
        panelMonth.add(setemberCheckBox);
        panelMonth.add(octoberCheckBox);
        panelMonth.add(novemberCheckBox);
        panelMonth.add(decemberCheckBox);
        
        JTextField yearTextField = new JTextField();
        panelMonth.add(new JLabel("Year:"));
        panelMonth.add(yearTextField);
        
        actionListenerMonth(januaryCheckBox, panelMonth);
        actionListenerMonth(februaryCheckBox, panelMonth);
        actionListenerMonth(marchCheckBox, panelMonth);
        actionListenerMonth(aprilCheckBox, panelMonth);
        actionListenerMonth(mayCheckBox, panelMonth);
        actionListenerMonth(juneCheckBox, panelMonth);
        actionListenerMonth(julyCheckBox, panelMonth);
        actionListenerMonth(augustCheckBox, panelMonth);
        actionListenerMonth(setemberCheckBox, panelMonth);
        actionListenerMonth(octoberCheckBox, panelMonth);
        actionListenerMonth(novemberCheckBox, panelMonth);
        actionListenerMonth(decemberCheckBox, panelMonth);
                
        int resultName = JOptionPane.showConfirmDialog(this, panelMonth, "Change month",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (resultName == JOptionPane.OK_OPTION) {
            String selectedMonth = getSelectedMonth(panelMonth);
            String yearText = yearTextField.getText();

            try {
                int year = Integer.parseInt(yearText);
                if (year > 0) {
                    Month month = Month.valueOf(selectedMonth.toUpperCase());
                    LocalDate selectedDate = LocalDate.of(year, month.getValue(), 1);
                    labelMonthYear.setText(calendar.displayMonthYear(selectedDate));
                    setTableCalendar(selectedDate);
                    CalendarPage.date = selectedDate;
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter a valid year.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid year.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } 
    
    private static void actionListenerMonth(JRadioButton button, JPanel panel) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearMonthSelection(panel);
                button.setSelected(true);
            }
        });
    }

    private static void clearMonthSelection(JPanel panel) {
        for (Component component : panel.getComponents()) {
            if (component instanceof JRadioButton) {
                ((JRadioButton) component).setSelected(false);
            }
        }
    }

    private static String getSelectedMonth(JPanel panel) {
        for (Component component : panel.getComponents()) {
            if (((JRadioButton) component).isSelected()) {
                return ((JRadioButton) component).getText();
            }
        }
        
        return null; 
    }

    private void setTableCalendar(LocalDate date) {
        tableCalendar.setModel(new javax.swing.table.DefaultTableModel(
            (Object[][]) calendar.displayCalendar(date),
            new String [] {
                "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
            }
        ));
    }
    
    private void setTableSchedule(LocalDate date, boolean value) {
        String[] column = {"Tasks", "Events"};
        if (value == true) {
            tableSchedule.setModel(new javax.swing.table.DefaultTableModel(
                (Object[][]) calendar.searchSchedule(date).displaySchedule(),
                column));
        }
        else {
            LocalDate invalidDate = LocalDate.of(0,1,1);
            Schedule schedule = new Schedule(invalidDate);
            
            tableSchedule.setModel(new javax.swing.table.DefaultTableModel(
                (Object[][]) schedule.displaySchedule(),
                column));
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelMonthYear;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel panelCalendar;
    private javax.swing.JTable tableCalendar;
    private javax.swing.JTable tableSchedule;
    private javax.swing.JTextField textFieldEvent;
    private javax.swing.JTextField textFieldTask;
    // End of variables declaration//GEN-END:variables

  // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
}

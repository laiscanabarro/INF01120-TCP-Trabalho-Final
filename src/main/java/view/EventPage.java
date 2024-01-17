/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import user.User;
import content.*;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import utils.Location;
import utils.Period;
import utils.Recurrence;

/**
 *
 * @author laisa
 */
public class EventPage extends Page {
    private static Event event;
    private static Calendar calendar;

    /**
     * Creates new form EventPage
     * @param event
     * @param calendar
     */
    public EventPage(Event event, Calendar calendar) {
        EventPage.event = event;
        EventPage.calendar = calendar;
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

        panelEvent = new javax.swing.JPanel();
        footer = new javax.swing.JPanel();
        buttonRepeat = new javax.swing.JLabel();
        labelEventName = new javax.swing.JLabel();
        labelAddLocation = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TaDa - Event");
        setSize(new java.awt.Dimension(1280, 720));

        panelEvent.setBackground(new java.awt.Color(255, 255, 255));
        panelEvent.setPreferredSize(new java.awt.Dimension(1286, 720));

        footer.setBackground(new java.awt.Color(51, 51, 255));
        footer.setPreferredSize(new java.awt.Dimension(100, 99));

        buttonRepeat.setBackground(new java.awt.Color(255, 255, 255));
        buttonRepeat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonRepeat.setForeground(new java.awt.Color(255, 255, 255));
        buttonRepeat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        if (!(event.getRecurrence().verifyRecurrence())) {
            buttonRepeat.setText("Repeat event");
        }
        else {
            buttonRepeat.setText(event.getRecurrence().getRecurrenceType().toString());
        }
        buttonRepeat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRepeatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonRepeat)
                .addGap(48, 48, 48))
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(buttonRepeat)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        labelEventName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelEventName.setForeground(new java.awt.Color(51, 51, 51));
        labelEventName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelEventName.setText(event.getName());
        labelEventName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        labelEventName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventNameMouseClicked(evt);
            }
        });

        if (event.getLocation() == null){
            labelAddLocation.setText("Add location");
        }
        else {
            labelAddLocation.setText(event.getLocation().displayLocation());
        }
        labelAddLocation.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelAddLocation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addLocationMouseClicked(evt);
            }
        });

        labelDate.setText(event.getPeriod().displayPeriod());
        labelDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateMouseClicked(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEventLayout = new javax.swing.GroupLayout(panelEvent);
        panelEvent.setLayout(panelEventLayout);
        panelEventLayout.setHorizontalGroup(
            panelEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, 1286, Short.MAX_VALUE)
            .addGroup(panelEventLayout.createSequentialGroup()
                .addGroup(panelEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEventLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(panelEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(labelAddLocation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelEventName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(labelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelEventLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(backButton)))
                .addContainerGap(925, Short.MAX_VALUE))
        );
        panelEventLayout.setVerticalGroup(
            panelEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEventLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEventName)
                .addGap(24, 24, 24)
                .addComponent(labelAddLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelEvent.getAccessibleContext().setAccessibleParent(panelEvent);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addLocationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addLocationMouseClicked
        displayLocationDialog();
    }//GEN-LAST:event_addLocationMouseClicked

    private void dateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateMouseClicked
        displayDateDialog();
    }//GEN-LAST:event_dateMouseClicked

    private void eventNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventNameMouseClicked
        displayNameDialog();
    }//GEN-LAST:event_eventNameMouseClicked

    private void buttonRepeatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRepeatMouseClicked
        displayRecurrenceDialog();
    }//GEN-LAST:event_buttonRepeatMouseClicked

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        LocalDate date = event.getPeriod().getStartDate();
        CalendarPage calendaPage = new CalendarPage(calendar, date);
        changeTo(calendaPage);
    }//GEN-LAST:event_backButtonActionPerformed
     
    private void displayRecurrenceDialog() {
        Recurrence recurrence;
        if (event.getRecurrence() == null){
            recurrence = new Recurrence();
        }
        else {
           recurrence = event.getRecurrence();
        }
        
        JPanel panelRecurrence = new JPanel();
        panelRecurrence.setLayout(new GridLayout(5, 2));
        
        // Creates a RadioButton with associated text
        JRadioButton dailyCheckBox = new JRadioButton ("Daily");
        JRadioButton weekdayCheckBox = new JRadioButton ("Weekday");
        JRadioButton weeklyCheckBox = new JRadioButton ("Weekly");
        JRadioButton monthlyCheckBox = new JRadioButton ("Monthly");
        JRadioButton annuallyCheckBox = new JRadioButton ("Annually");
        JRadioButton clearCheckBox = new JRadioButton ("Clear");
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(dailyCheckBox);
        buttonGroup.add(weekdayCheckBox);
        buttonGroup.add(weeklyCheckBox);
        buttonGroup.add(monthlyCheckBox);
        buttonGroup.add(annuallyCheckBox);
        buttonGroup.add(clearCheckBox);
        
        panelRecurrence.add(dailyCheckBox);
        panelRecurrence.add(weekdayCheckBox);
        panelRecurrence.add(weeklyCheckBox);
        panelRecurrence.add(monthlyCheckBox);
        panelRecurrence.add(annuallyCheckBox);
        panelRecurrence.add(clearCheckBox);
            
        actionListenerRecurrence(dailyCheckBox, Recurrence.RecurrenceType.DAILY, recurrence);
        actionListenerRecurrence(weekdayCheckBox, Recurrence.RecurrenceType.WEEKDAY, recurrence);
        actionListenerRecurrence(weeklyCheckBox, Recurrence.RecurrenceType.WEEKLY, recurrence);
        actionListenerRecurrence(monthlyCheckBox, Recurrence.RecurrenceType.MONTHLY, recurrence);
        actionListenerRecurrence(annuallyCheckBox, Recurrence.RecurrenceType.ANNUALLY, recurrence);
        actionListenerRecurrence(clearCheckBox, Recurrence.RecurrenceType.UNDEFINED, recurrence);
        
        int result = JOptionPane.showConfirmDialog(this, panelRecurrence, "Add recurrence",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            Recurrence.RecurrenceType recurrenceType = recurrence.getRecurrenceType();
            if (recurrence.verifyRecurrence()) {
                buttonRepeat.setText(recurrenceType.toString());
            }
            else {
                buttonRepeat.setText("Repeat event"); 
            }
        }
        
    }
    
    private void actionListenerRecurrence(JRadioButton button, Recurrence.RecurrenceType recurrenceType, Recurrence recurrence) {
        button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (recurrenceType.equals(Recurrence.RecurrenceType.UNDEFINED)) {
                        recurrence.clear(calendar, event);
                        calendar.removeEvent(event);
                        calendar.addEvent(event);
                    }
                    else {
                        recurrence.changeRecurrence(recurrenceType, calendar, event);
                    }
                }
            });
    }
    
    private void displayNameDialog() {
        JPanel panelName = new JPanel();
        panelName.setLayout(new GridLayout(2, 4));
        JTextField nameTextField = new JTextField();
        panelName.add(new JLabel("New name:"));
        panelName.add(nameTextField);   
        
        int resultName = JOptionPane.showConfirmDialog(this, panelName, "Edit name",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (resultName == JOptionPane.OK_OPTION) {
            String name = nameTextField.getText();
            if (name != null && !name.trim().isEmpty()) { 
                event.setName(name);
                labelEventName.setText(name);
            }
        }
    }
        
    private void displayLocationDialog() {
        Location location;
        if (event.getLocation() == null){
            location = new Location();
        }
        else {
           location = event.getLocation();
        }
        
        JPanel panelLocation = new JPanel();
        panelLocation.setLayout(new GridLayout(5, 2));

        // Add text field for location information
        JTextField countryTextField = new JTextField();
        JTextField cityTextField = new JTextField();
        JTextField stateTextField = new JTextField();
        JTextField streetTextField = new JTextField();
        JTextField numberTextField = new JTextField();

        // Add labels and text boxes to the panel
        panelLocation.add(new JLabel("Country:"));
        panelLocation.add(countryTextField);

        panelLocation.add(new JLabel("City:"));
        panelLocation.add(cityTextField);

        panelLocation.add(new JLabel("State:"));
        panelLocation.add(stateTextField);

        panelLocation.add(new JLabel("Street:"));
        panelLocation.add(streetTextField);

        panelLocation.add(new JLabel("Number:"));
        panelLocation.add(numberTextField);

        int result = JOptionPane.showConfirmDialog(this, panelLocation, "Add Location",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // If the user clicks "OK", they get the entered information
        if (result == JOptionPane.OK_OPTION) {
            String country = countryTextField.getText();
            if (location.isNonEmpty(country)) { 
                location.setCountry(country);
            }

            String city = cityTextField.getText();
            if (location.isNonEmpty(city)) {
                location.setCity(city);
            }
      
            String state = stateTextField.getText();
            if (location.isNonEmpty(state)) {
                location.setState(state);
            }

            String street = streetTextField.getText();
            if (location.isNonEmpty(street)) {
                location.setStreet(street);
            }        
            

            try {
                if (location.isNonEmpty(numberTextField.getText())) {
                    int number = Integer.parseInt(numberTextField.getText());
                    if (number > 0) {
                        location.setNumber(number);
                    }
                }
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (location.verifyLocation()) {
                event.setLocation(location);
                labelAddLocation.setText(event.getLocation().displayLocation());
            }  
            else {
                JOptionPane.showMessageDialog(this, "Please enter all information.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void displayDateDialog() {
        Period period = event.getPeriod();
        JPanel panelDate = new JPanel();
        panelDate.setLayout(new GridLayout(5, 2));

        // Add text field for period information
        JTextField startDateTextField = new JTextField();
        JTextField endDateTextField = new JTextField();
        JTextField startTimeTextField = new JTextField();
        JTextField endTimeTextField = new JTextField();

        // Add labels and text boxes to the panel
        panelDate.add(new JLabel("Start date:"));
        panelDate.add(startDateTextField);

        panelDate.add(new JLabel("End date:"));
        panelDate.add(endDateTextField);

        panelDate.add(new JLabel("Start time:"));
        panelDate.add(startTimeTextField);

        panelDate.add(new JLabel("End time:"));
        panelDate.add(endTimeTextField);

        int result = JOptionPane.showConfirmDialog(this, panelDate, "Edit date",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // If the user clicks "OK", they get the entered information
        if (result == JOptionPane.OK_OPTION) {                 
            try {
                String startDate = startDateTextField.getText();
                if (!(startDate.isEmpty())) {
                    period.setStartDate(period.convertStringToLocalDate(startDate));
                }
            
                String endDate = endDateTextField.getText();
                if (!(endDate.isEmpty())) {
                    period.setEndDate(period.convertStringToLocalDate(endDate));
                }                                        
                
                labelDate.setText(event.getPeriod().displayPeriod());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid date.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            try {
                String startTime = startTimeTextField.getText();
                if (!(startTime.isEmpty())) {
                    period.setStartTime(period.convertStringToLocalTime(startTime));
                }
  
                String endTime = endTimeTextField.getText();
                if (!(endTime.isEmpty())) {
                    period.setEndTime(period.convertStringToLocalTime(endTime));
                }   
                
                long days = period.countDays();
                Schedule schedule;
                LocalDate start = period.getStartDate();
                for (int i = 1; i <= days; i++) {
                    schedule = calendar.searchSchedule(start.plusDays(i));
                    schedule.addEvent(event);
                }
                
                labelDate.setText(event.getPeriod().displayPeriod());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid time.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel buttonRepeat;
    private javax.swing.JPanel footer;
    private javax.swing.JLabel labelAddLocation;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelEventName;
    private javax.swing.JPanel panelEvent;
    // End of variables declaration//GEN-END:variables
}

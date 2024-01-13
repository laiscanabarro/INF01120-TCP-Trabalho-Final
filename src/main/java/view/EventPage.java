/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import user.User;
import content.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDate;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author laisa
 */
public class EventPage extends javax.swing.JFrame {
    
    private static User user;
    private static Event event;

    /**
     * Creates new form EventPage
     * @param user
     * @param event
     */
    public EventPage(User user, Event event) {
        EventPage.user = user;
        EventPage.event = event;
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
        labelAddParticipants = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TaDa - Event");
        setSize(new java.awt.Dimension(1280, 720));

        panelEvent.setBackground(new java.awt.Color(255, 255, 255));
        panelEvent.setPreferredSize(new java.awt.Dimension(1286, 690));

        footer.setBackground(new java.awt.Color(51, 51, 255));

        buttonRepeat.setBackground(new java.awt.Color(255, 255, 255));
        buttonRepeat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonRepeat.setForeground(new java.awt.Color(255, 255, 255));
        buttonRepeat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonRepeat.setText("Repeat event");
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
                .addContainerGap(42, Short.MAX_VALUE))
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

        if (event.getParticipants() == null){
            labelAddParticipants.setText("Add participants");
        }
        else {
            labelAddParticipants.setText(event.displayParticipants());
        }
        labelAddParticipants.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addParticipantsMouseClicked(evt);
            }
        });

        labelDate.setText(event.getPeriod().displayPeriod());
        labelDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelEventLayout = new javax.swing.GroupLayout(panelEvent);
        panelEvent.setLayout(panelEventLayout);
        panelEventLayout.setHorizontalGroup(
            panelEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelEventLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(panelEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(labelAddLocation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelEventName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(labelAddParticipants)
                    .addComponent(labelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(973, Short.MAX_VALUE))
        );
        panelEventLayout.setVerticalGroup(
            panelEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEventLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(labelEventName)
                .addGap(24, 24, 24)
                .addComponent(labelAddLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(labelAddParticipants)
                .addGap(12, 12, 12)
                .addComponent(labelDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 414, Short.MAX_VALUE)
                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addParticipantsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addParticipantsMouseClicked
        displayParticipantsDialog();
        
    }//GEN-LAST:event_addParticipantsMouseClicked

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
            if (!(name.isEmpty())) {
                event.setName(name);
                labelEventName.setText(name);
            }
        }
    }
        
    private void displayParticipantsDialog() {
        //
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
            if (country != null) { 
                location.setCountry(country);
            }

            String city = cityTextField.getText();
            if (city != null) {
                location.setCity(city);
            }
      
            String state = stateTextField.getText();
            if (state != null) {
                location.setState(state);
            }

            String street = streetTextField.getText();
            if (street != null) {
                location.setStreet(street);
            }        
            

            try {
                int number = Integer.parseInt(numberTextField.getText());
                location.setNumber(number);
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            if (location.verifyLocation()) {
                event.setLocation(location);
                labelAddLocation.setText(event.getLocation().displayLocation());
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
                
                labelDate.setText(event.getPeriod().displayPeriod());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid time.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
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
            java.util.logging.Logger.getLogger(EventPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                User user1 = new User();
                Period period = new Period(LocalDate.now());
                Event event1 = new Event("Presentation", period);
                new EventPage(user1, event1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buttonRepeat;
    private javax.swing.JPanel footer;
    private javax.swing.JLabel labelAddLocation;
    private javax.swing.JLabel labelAddParticipants;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelEventName;
    private javax.swing.JPanel panelEvent;
    // End of variables declaration//GEN-END:variables
}
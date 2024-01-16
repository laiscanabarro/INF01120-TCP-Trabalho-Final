/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import content.Event;
import content.Schedule;
import java.time.LocalDate;
import java.util.ArrayList;

public class RecurrenceList {
    // Arrays to place events by recurrence
    private ArrayList<Event> daily;
    private ArrayList<Event> weekday;
    private ArrayList<Event> weekly;
    private ArrayList<Event> monthly;
    private ArrayList<Event> annually;
    
    public RecurrenceList() {
        this.daily = new ArrayList<>();
        this.weekday = new ArrayList<>();
        this.weekly = new ArrayList<>();
        this.monthly = new ArrayList<>();
        this.annually = new ArrayList<>();
    }
    
    public ArrayList<Event> getDaily() {
        return this.daily;
    }

    public ArrayList<Event> getWeekday() {
        return this.weekday;
    }

    public ArrayList<Event> getWeekly() {
        return this.weekly;
    }

    public ArrayList<Event> getMonthly() {
        return this.monthly;
    }

    public ArrayList<Event> getAnnually() {
        return this.annually;
    }
    
    public void addDaily(Event event){
        daily.add(event);
    }
    
    public void removeDaily(Event event){
        daily.remove(event);
    }
    
    public void addWeekday(Event event){
        weekday.add(event);
    }
    
    public void removeWeekday(Event event){
        weekday.remove(event);
    }
    
    public void addWeekly(Event event){
        weekly.add(event);
    }
    
    public void removeWeekly(Event event){
        weekly.remove(event);
    }
    
    public void addMonthly(Event event){
        monthly.add(event);
    }
    
    public void removeMonthly(Event event){
        monthly.remove(event);
    }
    
    public void addAnnually(Event event){
        annually.add(event);
    }
    
    public void removeAnnually(Event event){
        annually.remove(event);
    }
    
    public void dailyList(Schedule schedule) {
        ArrayList<Event> eventList = getDaily();
        int listSize = eventList.size();
        
        for (int i = 0; i < listSize; i++) {
            // if the event is not in the list
            if (!(schedule.searchEvent(eventList.get(i)))) {
                // if the event occurred before
                LocalDate endEvent = eventList.get(i).getPeriod().getEndDate();
                if (schedule.getDate().isAfter(endEvent)) {
                    schedule.addEvent(eventList.get(i));
                }
            }
        }
    }
    
    public void weekdayList(Schedule schedule) {
        ArrayList<Event> eventList = getWeekday();
        LocalDate date =  schedule.getDate();
        int listSize = eventList.size();
        
        for (int i = 0; i < listSize; i++) {
            //
            
        }
        
    }
    
    public void weeklyList(Schedule schedule) {
        ArrayList<Event> eventList = getWeekly();
        LocalDate date =  schedule.getDate();
        int listSize = eventList.size();
        
        for (int i = 0; i < listSize; i++) {
            Period period = eventList.get(i).getPeriod();
            long days = period.countDays();
            //
            
        }
    }
    
    public void monthlyList(Schedule schedule) {
        ArrayList<Event> eventList = getMonthly();
        LocalDate date =  schedule.getDate();
        int listSize = eventList.size();
        
        for (int i = 0; i < listSize; i++) {
            
        }
    }
    
    public void annuallyList(Schedule schedule, Boolean leapYear) {
        ArrayList<Event> eventList = getAnnually();
        LocalDate date =  schedule.getDate();
        int listSize = eventList.size();
        
        for (int i = 0; i < listSize; i++) {
            
        }
    }
    
}

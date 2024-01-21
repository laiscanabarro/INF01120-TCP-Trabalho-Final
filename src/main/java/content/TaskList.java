package content;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static content.Task.COMPLETED;

public class TaskList {
    private String name;
    private ArrayList<Task> tasks;
    private ORDER_BY listOrder;
    public enum ORDER_BY {
        ALPHABET, IMPORTANCE_ASC, IMPORTANCE_DESC, END_DATE_ASC, END_DATE_DESC;
    }

    public TaskList(){
        setTasks(new ArrayList<>());
    }
    public TaskList(String name, ArrayList<Task> tasks){
        setName(name);
        setTasks(tasks);
    }
    public void setName(String name){ this.name = name; }
    public void setTasks(ArrayList<Task> tasks){
        if (this.tasks != null) {
            for (Task task : tasks) {
                addTask(task);
            }
        } else {
            this.tasks = tasks;
        }

    }
    public void setListOrder(ORDER_BY order) { this.listOrder = order; }
    public String getName(){ return name; }
    public ArrayList<Task> getTasks(){ return tasks; }
    public ORDER_BY getListOrder() { return listOrder; }

    public int getCompletedTodayCount() {
        int completedTodayCount = 0;
        LocalDate today = LocalDate.now();

        for (Task task : tasks) {
            if (task.getStatus() == COMPLETED && task.getConclusionDate().equals(today)) {
                completedTodayCount++;
            }
        }
        return completedTodayCount;
    }
    public void clear(){ tasks.clear(); }
    public void addTask(Task task){
        task.setCurrentList(this);
        tasks.add(task);
        if (task.getCurrentList().equals(DailyList.getInstance())) {
            task.setDeadline(LocalDate.now());
        }
    }
    public void removeTask(Task task){ tasks.remove(task); }
    public void changeOrder(ORDER_BY orderBy){
        switch (orderBy) {
            case ALPHABET -> orderByLetter();
            case END_DATE_ASC -> orderByEndDate(false);
            case END_DATE_DESC -> orderByEndDate(true);
            case IMPORTANCE_ASC -> orderByImportance(false);
            case IMPORTANCE_DESC -> orderByImportance(true);
            default -> setTasks(tasks);
        }
    }


    private void orderByLetter(){
        tasks.sort(Comparator.comparing(Task::getName));
        setListOrder(ORDER_BY.ALPHABET);
    }
    private void orderByEndDate(boolean isDesc){
        tasks.sort(Comparator.comparing(Task::getDeadline, Comparator.nullsFirst(Comparator.naturalOrder())));
        if (isDesc){
            Collections.reverse(tasks);
            setListOrder(ORDER_BY.END_DATE_DESC);
        } else {
            setListOrder(ORDER_BY.END_DATE_ASC);
        }
    }
    private void orderByImportance(boolean isDesc){
        tasks.sort(Comparator.comparingInt(Task::getImportanceScale));
        if (isDesc){
            Collections.reverse(tasks);
            setListOrder(ORDER_BY.IMPORTANCE_DESC);
        } else {
            setListOrder(ORDER_BY.IMPORTANCE_ASC);
        }
    }

}

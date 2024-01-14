package content;

import utils.TasksUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TaskList {
    private String name;
    private ArrayList<Task> tasks;

    public TaskList(){
        reset();
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
    public String getName(){ return name; }
    public ArrayList<Task> getTasks(){ return tasks; }
    public int getCompletedCount() {
        int completedCount = 0;
        for (Task task : tasks) {
            if (task.getStatus() == TasksUtils.COMPLETED) {
                completedCount++;
            }
        }
        return completedCount;
    }

    public int getCompletedTodayCount() {
        int completedTodayCount = 0;
        LocalDate today = LocalDate.now();

        for (Task task : tasks) {
            if (task.getStatus() == TasksUtils.COMPLETED && task.getConclusionDate().equals(today)) {
                completedTodayCount++;
            }
        }
        return completedTodayCount;
    }
    private void reset(){
        setName(null);
        ArrayList<Task> emptyTasks = new ArrayList<>();
        setTasks(emptyTasks);
    }
    public void clear(){ tasks.clear(); }
    public void addTask(Task task){
        task.setCurrentList(this);
        tasks.add(task);
    }
    public void removeTask(Task task){ tasks.remove(task); }
    public void changeOrder(String orderBy){
        switch (orderBy) {
            case TasksUtils.ORDER_ALPHABET -> orderByLetter();
            case TasksUtils.ORDER_END_DATE_ASC -> orderByEndDate(false);
            case TasksUtils.ORDER_END_DATE_DESC -> orderByEndDate(true);
            case TasksUtils.ORDER_IMPORTANCE_ASC -> orderByImportance(false);
            case TasksUtils.ORDER_IMPORTANCE_DESC -> orderByImportance(true);
            default -> setTasks(tasks);
        }
    }


    private void orderByLetter(){
        tasks.sort(Comparator.comparing(Task::getName));
    }
    private void orderByEndDate(boolean isDesc){
        tasks.sort(Comparator.comparing(Task::getDeadline));
        if (isDesc){
            Collections.reverse(tasks);
        }
    }
    private void orderByImportance(boolean isDesc){
        tasks.sort(Comparator.comparingInt(Task::getImportanceScale));
        if (isDesc){
            Collections.reverse(tasks);
        }
    }

}

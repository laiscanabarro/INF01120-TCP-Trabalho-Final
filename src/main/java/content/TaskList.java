package content;

import utils.TasksUtils;
import java.util.ArrayList;
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
    private void reset(){
        setName("");
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
            case TasksUtils.ORDER_END_DATE_ASC -> orderByEndDate(true);
            case TasksUtils.ORDER_END_DATE_DESC -> orderByEndDate(false);
            case TasksUtils.ORDER_IMPORTANCE_ASC -> orderByImportance(true);
            case TasksUtils.ORDER_IMPORTANCE_DESC -> orderByImportance(false);
            default -> setTasks(tasks);
        }
    }
    private void orderByLetter(){
        tasks.sort(Comparator.comparing(Task::getName));
    }
    private void orderByEndDate(boolean isAsc){
        if (isAsc){
            tasks.sort(Comparator.comparing(Task::getDeadline));
        } else {
            tasks.sort(Comparator.comparing(Task::getDeadline).reversed());
        }
    }
    private void orderByImportance(boolean isAsc){
        if (isAsc){
            tasks.sort(Comparator.comparingInt(Task::getImportanceScale));
        } else {
            tasks.sort(Comparator.comparingInt(Task::getImportanceScale).reversed());
        }
    }
}

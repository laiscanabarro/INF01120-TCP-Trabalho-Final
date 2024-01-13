package content;

import utils.TasksUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Task {
    private String name;
    private TaskList currentList;
    private TaskList oldList;
    private String description;
    private int importanceScale;
    private LocalDate deadline;
    private boolean status;
    private ArrayList<Subtask> subtasks;
    private Date conclusionDate;
    public static final boolean COMPLETED = true;

//    Deixar comentado até existir um alarm
//    private Alarm alarm;

    public Task() {
        setImportanceScale(ImportantList.MIN_IMPORTANCE);
        setStatus(!COMPLETED);
        setSubtasks(new ArrayList<>());
    }
    public Task(String name, TaskList currentList, String description,
                int importanceScale, LocalDate deadline, Date conclusionDate) {
        setName(name);
        setCurrentList(currentList);
        setDescription(description);
        setImportanceScale(importanceScale);
        setDeadline(deadline);
        setStatus(!COMPLETED);
        setSubtasks(new ArrayList<>());
        setConclusionDate(conclusionDate);
    }
    public void setName(String name){ this.name = name; }
    public void setCurrentList(TaskList currentList){ this.currentList = currentList; }
    public void setOldList(TaskList oldList){ this.oldList = oldList; }
    public void setDescription(String description){ this.description = description; }
    public void setDeadline(LocalDate deadline){ this.deadline = deadline; }
    public void setImportanceScale(int importanceScale){
        if(importanceScale != ImportantList.MIN_IMPORTANCE){
            changeList(ImportantList.getInstance());
        }
        this.importanceScale = importanceScale;
    }
    public void setStatus(boolean status){
        if(status == COMPLETED) {
            Date date = new Date();
            setConclusionDate(date);
        }
        this.status = status;
    }
    public void setSubtasks(ArrayList<Subtask> subtasks){ this.subtasks = subtasks; }
    public void setConclusionDate(Date conclusionDate){ this.conclusionDate = conclusionDate; }
    public String getName(){ return name; }
    public TaskList getCurrentList(){ return currentList; }
    public TaskList getOldList(){ return oldList; }
    public String getDescription(){ return description; }
    public LocalDate getDeadline(){ return deadline; }
    public int getImportanceScale(){ return importanceScale; }
    public boolean getStatus(){ return status; }
    public ArrayList<Subtask> getSubtasks(){ return subtasks; }
    public Date getConclusionDate(){ return conclusionDate; }
    public void addSubtask(Subtask subtask) {
        subtask.setMainTask(this);
        subtasks.add(subtask);
    }
    public void removeSubtask(Subtask subtask){ subtasks.remove(subtask); }
    public void changeList(TaskList newList){
        setOldList(currentList);
        setCurrentList(newList);
        getOldList().removeTask(this);
        getCurrentList().addTask(this);
    }
}

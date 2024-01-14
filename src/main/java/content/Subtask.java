package content;

public class Subtask {
    private String name;
    private boolean status;
    private Task mainTask;
    public static final boolean COMPLETED = true;

    public Subtask(){
        setStatus(!COMPLETED);
    }
    public Subtask(String name, Task mainTask){
        setName(name);
        setStatus(!COMPLETED);
        setMainTask(mainTask);
    }
    public void setName(String name){ this.name = name; }
    public void setStatus(boolean status){ this.status = status; }
    public void setMainTask(Task mainTask){ this.mainTask = mainTask; }
    public String getName(){ return name; }
    public boolean getStatus(){ return status; }
    public Task getMainTask(){ return mainTask; }
    public void promoteToTask(){
        Task newTask = new Task();
        newTask.setName(name);
        mainTask.removeSubtask(this);
        mainTask.getCurrentList().addTask(newTask);
        newTask.setImportanceScale(mainTask.getImportanceScale());
    }
}

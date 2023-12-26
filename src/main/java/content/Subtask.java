package content;

import utils.TasksUtils;

public class Subtask {
    private String name;
    private boolean status;
    private Task mainTask;

    public Subtask(){
        reset();
    }
    public Subtask(String name, boolean status, Task mainTask){
        setName(name);
        setStatus(status);
        setMainTask(mainTask);
    }
    public void setName(String name){ this.name = name; }
    public void setStatus(boolean status){ this.status = status; }
    public void setMainTask(Task mainTask){ this.mainTask = mainTask; }
    public String getName(){ return name; }
    public boolean getStatus(){ return status; }
    public Task getMainTask(){ return mainTask; }
    public void reset(){
        setName("");
        setStatus(!TasksUtils.COMPLETED);
        setMainTask(null);
    }
    public Task promoteToTask(){
        Task newTask = new Task();
        newTask.setName(name);
        mainTask.removeSubtask(this);
        mainTask.getCurrentList().addTask(newTask);
        return newTask;
    }
}

package content;

import utils.TasksUtils;

public class ImportantList extends TaskList {
    private static String listOrder;
    private static final ImportantList importantList;
    private ImportantList(){
        super.setName("Important");
        setListOrder(TasksUtils.ORDER_IMPORTANCE_DESC);
    }

    static {
        importantList = new ImportantList();
    }
    public static ImportantList getInstance() {
        return importantList;
    }
    public static void setListOrder(String newOrder){ listOrder = newOrder; }
    public static String getListOrder(){ return listOrder; }
    public static void removeImportance(Task task){
        task.setImportanceScale(TasksUtils.MIN_IMPORTANCE);
        if (task.getCurrentList().equals(getInstance())) {
            task.changeList(task.getOldList());
        }
    }
    public static void increasePriority(Task task){
        int newPriorityValue = task.getImportanceScale() + 1;
        if (newPriorityValue < TasksUtils.MAX_IMPORTANCE) {
            task.setImportanceScale(newPriorityValue);
        } else {
            task.setImportanceScale(TasksUtils.MAX_IMPORTANCE);
        }
        resetOrder();
    }
    public static void decreasePriority(Task task){
        int newPriorityValue = task.getImportanceScale() - 1;
        if (newPriorityValue > TasksUtils.MIN_IMPORTANCE) {
            task.setImportanceScale(newPriorityValue);
        } else {
            removeImportance(task);
        }
        resetOrder();
    }
    private static void resetOrder(){
        getInstance().changeOrder(getListOrder());
    }
}

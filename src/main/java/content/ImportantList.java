package content;

public class ImportantList extends TaskList {
    private static final ImportantList importantList;
    public static final int MIN_IMPORTANCE = 0;
    public static final int MAX_IMPORTANCE = 5;

    private ImportantList(){
        super();
        super.setName("Important");
        super.setListOrder(ORDER_BY.IMPORTANCE_DESC);
    }

    static {
        importantList = new ImportantList();
    }
    public static ImportantList getInstance() {
        return importantList;
    }
    public static void removeImportance(Task task){
        task.setImportanceScale(MIN_IMPORTANCE);
        if (task.getCurrentList().equals(getInstance())) {
            task.changeList(task.getOldList());
        }
    }
    public static void increasePriority(Task task){
        int newPriorityValue = task.getImportanceScale() + 1;
        if (newPriorityValue < MAX_IMPORTANCE) {
            task.setImportanceScale(newPriorityValue);
        } else {
            task.setImportanceScale(MAX_IMPORTANCE);
        }
        resetOrder();
    }
    public static void decreasePriority(Task task){
        int newPriorityValue = task.getImportanceScale() - 1;
        if (newPriorityValue > MIN_IMPORTANCE) {
            task.setImportanceScale(newPriorityValue);
        } else {
            removeImportance(task);
        }
        resetOrder();
    }
    private static void resetOrder(){
        getInstance().changeOrder(getInstance().getListOrder());
    }
}

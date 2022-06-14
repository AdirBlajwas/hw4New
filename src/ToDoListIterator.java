import java.util.*;

public class ToDoListIterator implements Iterator<Task> {

    static final int IS_LARGER =1;


    Iterator<Task> cursor;
    int counter = 0;
    ArrayList<Task> sortedList;
    Comparator<Task> taskComparator;
    Date scanDateLimit;


    public ToDoListIterator(ToDoList list, Date scanDateLimit) {
        taskComparator = Comparator.comparing(Task::getdueDate,Date::compareTo).thenComparing(Task::getDescription);
        ToDoList cloned = list.clone();
        this.sortedList = cloned.getTaskList();
        Collections.sort(sortedList,taskComparator);
        this.cursor = sortedList.iterator();
        this.scanDateLimit = scanDateLimit;
    }
//    public ToDoListIterator(ToDoList list,Date scanDateLimit){
//        sup
//    }
    public ToDoListIterator(ToDoList list){
        this(list,list.getScanningDueDate());
    }

    @Override
    public boolean hasNext() {
        if(!cursor.hasNext()) return false;
        if(this.scanDateLimit != null)
            return (this.scanDateLimit.compareTo(sortedList.get(counter+1).getdueDate()) != IS_LARGER);
        return true;
    }

    @Override
    public Task next() {
        counter++;
        return cursor.next();
    }
}

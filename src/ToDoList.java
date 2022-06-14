import java.util.*;

public class ToDoList implements TaskIterable, Cloneable {
    private ArrayList<Task> taskList;
    private Date ScanningDueDate;
    private static final Comparator<Task> taskComparator = Comparator.comparing(Task::getDueDate,Date::compareTo)
            .thenComparing(Task::getDescription);




    public ToDoList() {
        this.taskList = new ArrayList<Task>();
    }

    public void addTask(Task newTask) {
        for (Task task : this.taskList) {
            if (newTask.equals(task)) {
                throw new TaskAlreadyExistsException();
            }
        }
        this.taskList.add(newTask);
    }

    @Override
    public void setScanningDueDate(Date scanningDueDate) {
        ScanningDueDate = scanningDueDate;
    }

    public Date getScanningDueDate() {
        return ScanningDueDate;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    @Override
    public ToDoList clone(){
        ToDoList clonedToDoList = new ToDoList();
        clonedToDoList.taskList = new ArrayList<Task>();
        int size = clonedToDoList.taskList.size();
        for (int i = 0; i < size; i++){
            clonedToDoList.taskList.set(i, (Task) this.taskList.get(i).clone()); //= (Task) this.taskList.get(i).clone;
        }
        return clonedToDoList;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        ToDoList tasks = (ToDoList) other;
        Iterator<Task> thisItr = tasks.scanAllIterator();
        Iterator<Task> otherItr =tasks.scanAllIterator();
        Task thisTask, otherTask;
        while(thisItr.hasNext() && otherItr.hasNext()){
            thisTask = thisItr.next();
            otherTask = otherItr.next();
            if(!thisTask.equals(otherTask)) return false;
        }
        if(otherItr.hasNext()|| thisItr.hasNext()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        ToDoList cloned = this.clone();
        Collections.sort(cloned.taskList,taskComparator);
        return Objects.hash(cloned.taskList);
    }

    public Iterator<Task> iterator(){
        return new ToDoListIterator(this);
    }

    public Iterator<Task> scanAllIterator(){
        return new ToDoListIterator(this,null);
    }

}



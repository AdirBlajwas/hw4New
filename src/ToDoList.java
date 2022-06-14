import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ToDoList implements Iterable, Cloneable {
    private ArrayList<Task> taskList;

    public ToDoList() {
        this.taskList = new ArrayList<Task>();
    }

    public void addTask(Task newTask) {
        for (Task task : this.taskList) {
            if (newTask.equals(task)) {
                return;
            }
        }
        this.taskList.add(newTask);
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
//        try {
//            ToDoList clonedToDoList = (ToDoList) super.clone();
//            clonedToDoList.taskList = new ArrayList<Task>();
//            int size = clonedToDoList.taskList.size();
//            for (int i = 0; i < size; i++){
//                clonedToDoList.taskList[i] = (Task) this.taskList[i].clone;
//            }
//            return clonedToDoList;
//        }
//        catch (CloneNotSupportedException e){
//            return null;
//        }




    public Iterator<Task> iterator(){
        return taskList.iterator();
    }
}



import java.util.ArrayList;
import java.util.Iterator;

public class ToDoList implements Iterable, Cloneable{
    private ArrayList<Task> taskList;

    public ToDoList() {
        this.taskList = new ArrayList<Task>();
    }

    public void addTask(Task newTask){
        for(task : this.taskList){

        }
    }


    public Iterator<Task> iterator(){
        return taskList.iterator();
    }
}



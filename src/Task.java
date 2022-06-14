import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;


public class Task implements Comparable, Cloneable{
    private final String description;
    private Date dueDate;

    public Task(String description, Date dueDate) {
        this.description = description;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate= formatter.format(dueDate  );
        return  "(" + description + ", " + strDate + ")";
    }


    public String getDescription() {
        return description;
    }


    public Date getDueDate  () {
        return dueDate  ;
    }

    public void setDueDate(Date dueDate  ) {
        this.dueDate   = dueDate  ;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Task)){
            return false;
        }
        Task task = (Task) o;
        return this.dueDate.equals(task.dueDate) && this.description.equals(task.description);
    }


    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public int compareTo(Object o) {
        Task t1 = (Task) o;
        int dateCompare = this.dueDate  .compareTo(t1.dueDate  );
        if(dateCompare != 0) return dateCompare;
        return this.description.compareTo(t1.description);
    }

    @Override
    public Task clone(){
        try {
        Task clone = (Task) super.clone();
        clone.dueDate   = (Date) this.dueDate  .clone();
        return clone;
        } catch (CloneNotSupportedException e){
            return null;
        }
    }

}

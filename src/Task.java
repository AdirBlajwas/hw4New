import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;


public class Task implements Comparable, Cloneable{
    private final String description;
    private Date date;

    public Task(String description, Date date) {
        this.description = description;
        this.date = date;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate= formatter.format(date);
        return  description + ", " + strDate;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public String getDescription() {
//        return description;
//    }


    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Task)){
            return false;
        }
        if(o == this) return true;
//        return o.hashCode() == this.hashCode();
        return this.date.equals(((Task) o).date) && this.description.equals((((Task) o).description));
    }


    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public int compareTo(Object o) {
        Task t1 = (Task) o;
        int dateCompare = this.date.compareTo(t1.date);
        if(dateCompare != 0) return dateCompare;
        return this.description.compareTo(t1.description);
    }

    @Override
    public Task clone(){
        try {
        Task clone = (Task) super.clone();
        clone.date = (Date) this.date.clone();
        return clone;
        } catch (CloneNotSupportedException e){
            return null;
        }
    }

}

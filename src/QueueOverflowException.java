public class QueueOverflowException extends QueueException{
    public QueueOverflowException(){
        super("The Queue is full!");
    }
}

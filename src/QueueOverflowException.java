public class QueueOverflowException extends QueueException{
    public QueueOverflowException(){}
    public QueueOverflowException(String message){
        super(message);
    }
    public QueueOverflowException(String message, Throwable e){
        super(message,e);
    }
    



}

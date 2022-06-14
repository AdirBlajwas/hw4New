public class EmptyQueueException extends QueueException{
    EmptyQueueException(){}
    EmptyQueueException(String message){
        super(message);
    }
    public EmptyQueueException(String message, Throwable e){
        super(message,e);
    }

}

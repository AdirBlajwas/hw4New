public class EmptyQueueException extends QueueException{
    EmptyQueueException(String message){
        super(message);
    }
    EmptyQueueException(){
        super("The queue is empty");
    }
}

public class NegativeCapacityException extends QueueException{
    NegativeCapacityException(){}
    NegativeCapacityException(String message){
        super(message);
    }
    public NegativeCapacityException(String message, Throwable e){
        super(message,e);
    }
}

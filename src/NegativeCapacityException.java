public class NegativeCapacityException extends QueueException{
    NegativeCapacityException(String message){
        super(message);
    }
    NegativeCapacityException(){
        super("Negative size of a queue is not allowed!");
    }
}

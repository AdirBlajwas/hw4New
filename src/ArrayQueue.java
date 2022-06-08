//import java.util.Arrays;
import java.util.Iterator;

public class ArrayQueue<E extends Cloneable> implements Queue<E>{

    Cloneable[] arrayQueue ;
    Integer counter = new Integer(0);
    int capacity;
    ArrayPointer head;
    ArrayPointer rear;
    Iterator<E> it;

    public ArrayQueue(int maxCapacity){
        if(maxCapacity < 0)
            throw new NegativeCapacityException();
        this.capacity = maxCapacity;
        this.arrayQueue = new Cloneable[maxCapacity];
        this.head = new ArrayPointer(this.capacity);
        this.rear = new ArrayPointer(this.capacity);
        this.it = Arrays.stream(arrayQueue).iterator();
    }


    public void enqueue(E element){
       if(this.counter >= this.capacity)
       {
           throw new QueueOverflowException();
       }
       this.rear.advancePointer();
       this.arrayQueue[this.rear.getLoc()] = element;
       this.counter++;
    }

    public E dequeue(){
        if(this.isEmpty())
            throw new EmptyQueueException();
        E element = (E) this.arrayQueue[this.head.getLoc()];
        this.head.advancePointer();
        counter--;
        return element;
    }


    public E peek(){
        if(this.isEmpty())
            throw new EmptyQueueException();
        return (E) this.arrayQueue[this.head.getLoc()];
    }

    public int size(){
        return Math.abs(this.head.getLoc() - this.rear.getLoc());
    }
    public boolean isEmpty(){
        return counter == 0;
    }
    public Queue<E> clone(){
        ArrayQueue<E> clonedQueue = new ArrayQueue<E>(this.capacity);
        clonedQueue.arrayQueue = this.arrayQueue.clone();
        clonedQueue.counter = this.counter;
        clonedQueue.head = this.head.clone();
        clonedQueue.rear = this.rear.clone();
        return clonedQueue;
    }

}

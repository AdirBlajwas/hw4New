//import java.util.Arrays;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ArrayQueue<E extends Cloneable> implements Queue<E>, Iterable<E>{

    Cloneable[] arrayQueue ;
    int counter = 0;
    int capacity;
    ArrayPointer head;
    ArrayPointer rear;
//    Iterator<E> it;

    public ArrayQueue(int maxCapacity){
        if(maxCapacity < 0)
            throw new NegativeCapacityException();
        this.capacity = maxCapacity;
        this.arrayQueue = new Cloneable[maxCapacity];
        this.head = new ArrayPointer(this.capacity);
        this.rear = new ArrayPointer(this.capacity);
//        this.it = this.iterator();
    }


    public void enqueue(E element){
       if(this.counter >= this.capacity)
       {
           throw new QueueOverflowException();
       }
       this.arrayQueue[this.rear.getLoc()] = element;
       this.rear.advancePointer();
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

    public E getElement(ArrayPointer position){
        return (E) this.arrayQueue[position.getLoc()];
    }

    public int size(){
        return this.counter;
    }
    public boolean isEmpty(){
        return counter == 0;
    }

    @Override
    public ArrayQueue<E> clone(){
        try {
            ArrayQueue<E> clonedQueue = (ArrayQueue<E>) super.clone();
//            clonedQueue.arrayQueue = this.arrayQueue.clone();
            clonedQueue.arrayQueue = new Cloneable[this.capacity];
            for(int i = 0; i < this.capacity ; i++){
                if(this.arrayQueue[i] == null) continue;
                clonedQueue.arrayQueue[i]= (Cloneable) this.arrayQueue[i].getClass()
                        .getMethod("clone").invoke(this.arrayQueue[i]);
            }
            clonedQueue.head = this.head.clone();
            clonedQueue.rear = this.rear.clone();
        return clonedQueue;
        }
        catch(CloneNotSupportedException | NoSuchMethodException
                | InvocationTargetException| IllegalAccessException e)
        {
            return null;
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator(this);
    }

    public int getCounter() {
        return counter;
    }

    public ArrayPointer getHead() {
        return head;
    }


}

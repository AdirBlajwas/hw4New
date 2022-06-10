//import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ArrayQueue<E extends Cloneable> implements Queue<E>{

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

    private E getElement(ArrayPointer position){
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
            clonedQueue.arrayQueue = this.arrayQueue.clone();
            clonedQueue.head = this.head.clone();
            clonedQueue.rear = this.rear.clone();
        return clonedQueue;
        }
        catch(CloneNotSupportedException e)
        {
            return null;
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Queue.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return Queue.super.spliterator();
    }


    public class ArrayQueueIterator implements Iterator<E>{
        ArrayPointer position;
        int itrCounter = 0;
        E element;

        public ArrayQueueIterator(){
            this.position = head;
            element = getElement(position);
        }

        public boolean hasNext(){
            return itrCounter < counter;
        }

        public E next(){
            itrCounter++;
            this.position.advancePointer();
            this.element = getElement(position);
            return this.element;
        }

        


    }

}

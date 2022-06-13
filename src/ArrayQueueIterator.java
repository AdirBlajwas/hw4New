import java.util.Iterator;

public class ArrayQueueIterator<E extends Cloneable> implements Iterator<E> {
    ArrayPointer position;
    ArrayQueue<E>  q ;
    int itrCounter = 0;

    public ArrayQueueIterator(ArrayQueue<E> q1){
        this.q = q1;
        this.position = q1.getHead().clone();
    }


    public boolean hasNext(){
        return itrCounter < q.getCounter();
    }

    public E next(){
        itrCounter++;
        E element = (E)(this.q.getElement(position));
        this.position.advancePointer();
        return element;
    }




}
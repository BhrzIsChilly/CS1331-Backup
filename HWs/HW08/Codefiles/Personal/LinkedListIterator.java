import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * @author Braiden Anderson
 * @version 1.0.0
 * @param <T> Used to store any data type
 */
public class LinkedListIterator<T> implements Iterator<T> {
    // Instance Variables
    private Node<T> next;


    // Constructors
    /**
     * @param linkedList The linked list that is connected to the iterator
     */
    public LinkedListIterator(LinkedList<T> linkedList) {
        if (linkedList == null) {
            throw new IllegalArgumentException();
        }
        this.next = linkedList.getHead();
    }


    // Methods
    @Override
    public boolean hasNext() {
        if (this.next.getNext() != null) {
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }

        T returnData = this.next.getData();
        this.next = this.next.getNext();

        return returnData;
    }
}
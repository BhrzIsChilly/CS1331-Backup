import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Braiden Anderson
 * @version 1.0.0
 * @param <T> Used to store any data type
 */
public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private int size;

    /**
     * Creates an empty Linked List.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Creates a Linked List using the array of data types given.
     * @param data the array of data to be implemented into the list.
     */
    public LinkedList(T[] data) {
        this();

        if (data != null) {
            for (T datum : data) {
                add(datum); // keep adding to end
            }
        }
    }

    /**
     * @return returns the head of the linked list
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * @return returns the linked list in the form of an array of the specified data type
     */
    public T[] toArray() {
        T[] returnArray = (T[]) new Object[this.size];

        Node<T> followingNode = this.head;

        for (int i = 0; i < this.size; i++) {
            returnArray[i] = followingNode.getData();
            followingNode = followingNode.getNext();
        }

        return returnArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("===== LINKEDLIST %d =====\nisEmpty: %s\nsize: %d\nhead: %s\ndata: [",
                        hashCode(),
                        isEmpty(),
                        size(),
                        (head == null ? "null" : head.getData())));

        T[] data = toArray();
        if (data == null) {
            sb.append("TODO: Implement toArray method...");
        } else {
            for (int i = 0; i < data.length - 1; ++i) {
                sb.append(String.format("%s, ", data[i])); // append all but last value
            }
            if (data.length > 0) {
                sb.append(String.format("%s", data[data.length - 1])); // append last value
            }
        }
        sb.append("]\n============================");
        return sb.toString();
    }

    @Override
    public void add(T element) throws IllegalArgumentException {
        // Error handling
        if (element == null) {
            throw new IllegalArgumentException();
        }


        // Method body
        Node<T> nextNode = new Node<>(element);
        Node<T> followingNode = this.head;

        if (this.head == null) {
            this.head = nextNode;
            this.size++;
            return;
        }

        for (int i = 0; i < this.size; i++) {
            if (followingNode.getNext() != null) {
                followingNode = followingNode.getNext(); // flow through the list
            } else {
                followingNode.setNext(nextNode); // Adds the node to the end
                this.size++;
                return;
            }
        }
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        // Error handling
        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (element == null) {
            throw new IllegalArgumentException();
        }

        // Method body
        Node<T> previousNode;
        Node<T> insertingNode;
        Node<T> followingNode = this.head;

        if (index == 0) {
            insertingNode = new Node<>(element, this.head);
            this.head = insertingNode;
            this.size++;
        }

        for (int i = 0; i < index; i++) {
            if (followingNode.getNext() != null && i < index - 1) { // %check
                followingNode = followingNode.getNext();
            } else {
                previousNode = followingNode;
                followingNode = followingNode.getNext(); // Note: Point to new Node \\ Node is at index
                insertingNode = new Node<>(element, followingNode);
                // New node points to 'following node' which is the next node.
                previousNode.setNext(insertingNode);

                this.size++;
                return;
            }
        }
    }

    @Override
    public T remove() throws NoSuchElementException {
        // Error handling
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        // Method body
        T nodeData = this.head.getData();

        this.head = this.head.getNext();
        this.size--;
        System.out.println(this.size + " < Decreasing");
        return nodeData;
    }

    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        // Error handling
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        // Method body
        Node<T> followingNode = this.head;
        Node<T> indexNode = null;
        Node<T> proceedingNode = null;

        if (index == 0) { // first element
            return this.remove();
        }

        if (index == this.size - 1) { // last element
            for (int i = 0; i < index; i++) {
                // A, *B*, C, null
                if (followingNode.getNext().getNext() == null) {
                    T returnData = followingNode.getNext().getData();
                    followingNode.setNext(null);
                    this.size--;
                    return returnData;
                    // A, *B*, null | return C;
                }
                followingNode = followingNode.getNext();
            }
        }

        for (int i = 0; i < index; i++) { // any element inbetween
            if (i == index - 1) {
                indexNode = followingNode.getNext();
                proceedingNode = indexNode.getNext();
                followingNode.setNext(proceedingNode);
                this.size--;
                return indexNode.getData();
            }
            followingNode = followingNode.getNext();
        }
        return null;
    }

    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        // Error handling
        if (element == null) {
            throw new IllegalArgumentException();
        }

        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        // Method body
        Node<T> followingNode = this.head;

        for (int i = 0; i < this.size; i++) {
            T followingNodeData = followingNode.getData();
            if (followingNodeData.equals(element)) {
                this.remove(i);
                return followingNodeData;
            }
            followingNode = followingNode.getNext();
        }
        return null;
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        // Error handling
        if (element == null) {
            throw new IllegalArgumentException();
        }

        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        // Method body
        T returnValue = this.remove(index);

        this.add(index, element);
        return returnValue;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        // Error handling
        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        // Method body
        Node<T> followingNode = this.head;
        Node<T> indexNode = null;

        if (index == 0) { // first element
            return this.head.getData();
        }

        if (index == this.size - 1) { // last element
            for (int i = 0; i < index; i++) {
                if (i == index - 1) {
                    return followingNode.getNext().getData();
                }
                followingNode = followingNode.getNext();
            }
        }

        for (int i = 0; i < index; i++) { // any element inbetween
            if (i == index - 1) {
                return followingNode.getNext().getData();
            }
            followingNode = followingNode.getNext();
        }

        return null;
    }

    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        // Error handling
        if (element == null) {
            throw new IllegalArgumentException();
        }

        // Method body
        Node<T> followingNode = this.head;

        for (int i = 0; i < this.size; i++) {
            if (followingNode.getData().equals(element)) {
                return true;
            }
            followingNode = followingNode.getNext();
        }

        return false;
    }

    @Override
    public void clear() {
    // This works because when I delete the variable pointing at
    // the head of the list, then Java understands that that variable has no way to be
    // accessed anymore, so it deletes that variable, which stops pointing at its proceeding
    // node, deleting that node, and so on til all nodes are erased from memory.
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        if (this.head == null || this.size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> returnIterator = new LinkedListIterator<>(this);
        return returnIterator;
    }
}
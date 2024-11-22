/**
 * @author Braiden Anderson
 * @version 1.0.0
 * @param <T> Used to store any data type
 */
public class Node<T> {
    // Instance Variables
    private T data;
    private Node<T> next;


    // Constructors
    /**
     * @param data the data that gets passed into the node.
     */
    public Node(T data) {
        this(data, null);
    }

    /**
     * @param data the data that gets passed into the node.
     * @param next reference to the next node in the link.
     */
    public Node(T data, Node<T> next) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        this.data = data;
        this.next = next;
    }


    // Methods (Getters / Setters)
    /**
     * @return returns the data of the Node
     */
    public T getData() {
        return this.data;
    }

    /**
     * @return returns the 'next' node reference.
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * @param data the data that is set to the node.
     */
    public void setData(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        this.data = data;
    }

    /**
     * @param next the reference that gets set the next node.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
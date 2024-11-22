/**
 * Exception to be raised if there is no more stock available.
 * @author Braiden Anderson
 * @version 1.0.0
 */
public class OutOfStockException extends Exception {
    //Constructor
    /**
     * @param item String item used to indicate which item is not in stock.
     */
    public OutOfStockException(String item) {
        super(String.format("%s is not in stock.", item));
    }
}
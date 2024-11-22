/**
 * Exception to be raised if there is not enough money available.
 * @author Braiden Anderson
 * @version 1.0.0
 */
public class NotEnoughMoneyException extends RuntimeException {
    /**
     * The constructor indicating that the items were not vended
     * because of insufficient funds.
     */
    public NotEnoughMoneyException() {
        super("Item not vended. Insufficient funds.");
    }
}
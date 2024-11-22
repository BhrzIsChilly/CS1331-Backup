/**
 * @author Braiden Anderson
 * @version 1.0.0
 */
public class InvalidTicketException extends Exception {
    // Default Variable
    private static final String DEF_EXCEPTION_MESSAGE = "Invalid ticket";


    // Constructors
    /**
     * Constructs InavlidTicketException with default message.
     */
    public InvalidTicketException() {
        this(DEF_EXCEPTION_MESSAGE);
    }
    /**
     * @param exceptionMessage Constructs InavlidTicketException with custom message
     */
    public InvalidTicketException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
/*
 * Class for custom Exception NegativeLengthException
 * @author Trevor Hollack
 */

public class NegativeLengthException extends Exception {
    /*
     * Constructor of the NegativeLengthException
     * 
     * @param exceptionMessage the message to be displayed
     */
    public NegativeLengthException(String exceptionMessage) {
        super("Negative Length: " + exceptionMessage);
    }
}

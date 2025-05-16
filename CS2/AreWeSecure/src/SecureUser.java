/*
 * Class for the Secure User
 * @author Trevor Hollack
 */

public class SecureUser extends User {

    /*
     * Counts how many times the user has input wrong password
     */
    private int lockCounter;

    /*
     * Constructor of the Secure User
     * 
     * @param username stored username
     * 
     * @param password stored password
     */
    public SecureUser(String username, String password) {
        super(username, password);
    }

    /*
     * Overrides authenticate method in User, checks how many times password is
     * input incorrectly
     * 
     * @param inputPassword the user input password
     * 
     * @return false if the lockCounter has determined the account should be locked
     * 
     * @return true if the passwords match
     * 
     * @return false if the passwords don't match and the lockCounter is less than
     * 3, and increment the lockCounter
     */
    @Override
    public boolean authenticate(String inputPassword) {
        if (lockCounter >= 3) {
            return false;
        } else if (super.authenticate(inputPassword)) {
            lockCounter = 0;
            return true;
        } else {
            lockCounter++;
            return false;
        }

    }
}
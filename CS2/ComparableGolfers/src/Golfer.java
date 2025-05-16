/*
 * Class for Golfers
 * @author Trevor Hollack
 */

public class Golfer implements Comparable<Golfer> {

    /*
     * Stores first name of the Golfer
     */
    private String firstName;

    /*
     * Stores last name of the Golfer
     */
    private String lastName;

    /*
     * Stores the score of the Golfer
     */
    private int score;

    /*
     * Stores how many holes the Golfer has played
     */
    private int thru;

    /*
     * Constructor of the Golfer
     * 
     * @param firstName stored first name
     * 
     * @param lastName stored last name
     * 
     * @param score stored score value
     * 
     * @param thru stored value of holes played
     */
    public Golfer(String firstName, String lastName, int score, int thru) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
        this.thru = thru;
    }

    /*
     * Method that defines how the Gofler object's values will be printed
     * 
     * @return lastName, firstName: score through thru
     */
    public String toString() {
        return (lastName + ", " + firstName + ": " + score + " through " + thru);
    }

    /*
     * Compares the Golfer objects against each other, in order of 1. score (low to
     * high), 2. holes played (high to low), 3. last name (lexicographically), and
     * 4. first name (lexicographically)
     * 
     * Return value of 1 pushes the object down the order, and -1 up the order
     * 
     * @return 1 if score is higher than to the compared score
     * 
     * @return -1 if score is lower than to the compared score
     * 
     * @return 1 if thru is lower than the compared thru
     * 
     * @return -1 if thru is higher than the comapred thru
     * 
     * @return 1 if lastName comes lexicographically after the compared last name
     * 
     * @return -1 if lastname comes lexicographically before the compared last name
     * 
     * @return 1 if firstName comes lexicographically after the compared first name
     * 
     * @return -1 if firstName comes lexicographically before the compared first
     * name
     * 
     * @return 0 if both compared objects are exactly the same
     */
    @Override
    public int compareTo(Golfer other) {
        if (this.score > other.score) {
            return 1;
        } else if (this.score < other.score) {
            return -1;
        } else if (this.thru < other.thru) {
            return 1;
        } else if (this.thru > other.thru) {
            return -1;
        } else if (this.lastName.compareToIgnoreCase(other.lastName) > 1) {
            return 1;
        } else if (this.lastName.compareToIgnoreCase(other.lastName) < -1) {
            return -1;
        } else if (this.firstName.compareToIgnoreCase(other.firstName) > 1) {
            return 1;
        } else if (this.firstName.compareToIgnoreCase(other.firstName) < -1) {
            return -1;
        } else
            return 0;
    }
}

/*
 * Class for Athletes
 * @author Trevor Hollack
 */

public class Athlete<Type extends Comparable<Type>> {

    /*
     * Stores name of the Athlete
     */
    private String name;

    /*
     * Stores the sport the Athlete plays
     */
    private String sport;

    /*
     * Stores the rank that Athlete is with a generic type
     */
    private Type rank;

    /*
     * Constructor of the Athlete
     * 
     * @param String name the stored name
     * 
     * @param String sport the stored sport
     * 
     * @param Type rank the stored rank
     */
    public Athlete(String name, String sport, Type rank) {
        this.name = name;
        this.sport = sport;
        this.rank = rank;
    }

    /*
     * Getter for the Athlete name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /*
     * Getter for the Athlete port
     * 
     * @return sport
     */
    public String getSport() {
        return sport;
    }

    /*
     * Getter for the Athlete rank
     * 
     * @return rank
     */
    public Type getRank() {
        return rank;
    }

    /*
     * Method that defines how the Athlete object's values will be printed
     * 
     * @return name (sport - rank)
     */
    public String toString() {
        return (name + "  (" + sport + " - " + rank + ")");
    }

}

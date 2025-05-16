import java.util.Comparator;

/*
 * Class for the SortByName Comparator
 * @author Trevor Hollack
 */
public class SortByName implements Comparator<Athlete> {

    /*
     * Compares 2 Athlete objects against each other in order of 1. Sport
     * (lexicographically), and then 2. Name (lexicographicallyƒ)
     * 
     * Return value of 1 pushes the object down the order, and -1 up the order
     * 
     * @return 1 if athleteX's sport comes lexicographically after athleteY's sport
     * 
     * @return -1 if athleteX's sport comes lexicographically before athleteY's
     * sport
     * 
     * @return 1 if athleteX's name comes lexicographically after athleteY's name
     * 
     * @return -1 if athleteX's name comes lexicographically before athleteY's name
     * 
     * @return 0 if both athletes are exactly the same
     */
    @Override
    public int compare(Athlete athleteX, Athlete athleteY) {
        if (athleteX.getSport().compareToIgnoreCase(athleteY.getSport()) > 1) {
            return 1;
        } else if (athleteX.getSport().compareToIgnoreCase(athleteY.getSport()) < -1) {
            return -1;
        } else if (athleteX.getName().compareToIgnoreCase(athleteY.getName()) > 1) {
            return 1;
        } else if (athleteX.getName().compareToIgnoreCase(athleteY.getName()) < -1) {
            return -1;
        } else {
            return 0;
        }
    }
}

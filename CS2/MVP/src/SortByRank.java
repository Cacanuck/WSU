import java.util.Comparator;

/*
 * Class of the SortByRank Comparator
 * @author Trevor Hollack
 */
public class SortByRank implements Comparator<Athlete> {

    /*
     * Compares 2 Athlete objects against each other in order of 1. Sport
     * (lexicographically), and then 2. Rank (ascending)
     * 
     * Return value of 1 pushes the object down the order, and -1 up the order
     * 
     * @return 1 if athleteX's sport comes lexicographically after athleteY's sport
     * 
     * @return -1 if athleteX's sport comes lexicographically before athleteY's
     * sport
     * 
     * @return 1 if athleteX's rank is higher than athleteY's rank
     * 
     * @return -1 if athleteX's rank is lower than athleteY's rank
     * 
     * @return 0 if both athletes are exactly the same
     */
    @Override
    public int compare(Athlete athleteX, Athlete athleteY) {
        if (athleteX.getSport().compareToIgnoreCase(athleteY.getSport()) > 1) {
            return 1;
        } else if (athleteX.getSport().compareToIgnoreCase(athleteY.getSport()) < -1) {
            return -1;
        } else if (athleteX.getRank().compareTo(athleteY.getRank()) > 1) {
            return 1;
        } else if (athleteX.getRank().compareTo(athleteY.getRank()) < 1) {
            return -1;
        } else {
            return 0;
        }
    }
}

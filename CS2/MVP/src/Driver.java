import java.util.ArrayList;
import java.util.Collections;

/*
 * Class of the Driver
 * @author Trevor Hollack
 */
public class Driver {

    /*
     * Loop method to print the contents of the Athlete ArrayList
     * 
     * @param athleteList the list of the Athlete objects
     */
    public static void printArrayList(ArrayList<Athlete> athleteList) {
        for (int i = 0; i < athleteList.size(); ++i) {
            System.out.println(athleteList.get(i));
        }
    }

    public static void main(String[] args) throws Exception {
        /*
         * Create 5 Athlete objects
         */
        Athlete athlete1 = new Athlete("James Harden", "Basketball", 7);
        Athlete athlete2 = new Athlete("Lebron James", "Basketball", 3);
        Athlete athlete3 = new Athlete("Wayne Gretzky", "Hockey", 5);
        Athlete athlete4 = new Athlete("Barry Bonds", "Baseball", 1);
        Athlete athlete5 = new Athlete("Babe Ruth", "Baseball", 2);

        /*
         * Create Athlete ArrayList
         */
        ArrayList<Athlete> athleteList = new ArrayList<>();

        /*
         * Add created Athlete objects to the created ArrayList
         */
        athleteList.add(athlete1);
        athleteList.add(athlete2);
        athleteList.add(athlete3);
        athleteList.add(athlete4);
        athleteList.add(athlete5);

        /*
         * Print out the unsorted ArrayList
         */
        System.out.println();
        System.out.println("Unsorted:");
        printArrayList(athleteList);

        /*
         * Sort the ArrayList by Sport and then Name, and then print out the sorted
         * ArrayList
         */
        System.out.println();
        Collections.sort(athleteList, new SortByName());
        System.out.println("Sorted by Sport and then Name:");
        printArrayList(athleteList);

        /*
         * Sort the ArrayList by Sport and then Rank, and then print out the sorted
         * ArrayList
         */
        System.out.println();
        Collections.sort(athleteList, new SortByRank());
        System.out.println("Sorted by Sport and then Rank:");
        printArrayList(athleteList);
    }
}

import java.util.ArrayList;
import java.util.Collections;

/*
 * Class of the Driver
 * @author Trevor Hollack
 */
public class Driver {

    /*
     * Loop method to print the contents of the Golfer ArrayList
     * 
     * @param golfList the list of Golfer objects
     */
    public static void printArrayList(ArrayList<Golfer> golfList) {
        for (int i = 0; i < golfList.size(); ++i) {
            System.out.println(golfList.get(i));
        }
    }

    public static void main(String[] args) throws Exception {
        Golfer golfer1 = new Golfer("Jay", "Johnson", -5, 12);// Final Order:6
        Golfer golfer2 = new Golfer("Deshaun", "Smith", -7, 12);// Final Order:3
        Golfer golfer3 = new Golfer("Taylor", "Miller", -7, 12);// Final Order:2
        Golfer golfer4 = new Golfer("James", "Miller", -7, 12);// Final Order:1
        Golfer golfer5 = new Golfer("Hakeem", "Gonzalez", -7, 8);// Final Order:5
        Golfer golfer6 = new Golfer("Deshaun", "Smith", -7, 12);// Final Order:4

        ArrayList<Golfer> golfList = new ArrayList<>();

        golfList.add(golfer1);
        golfList.add(golfer2);
        golfList.add(golfer3);
        golfList.add(golfer4);
        golfList.add(golfer5);
        golfList.add(golfer6);

        System.out.println();
        printArrayList(golfList);

        Collections.sort(golfList);

        System.out.println("------------------------------");
        printArrayList(golfList);
    }
}

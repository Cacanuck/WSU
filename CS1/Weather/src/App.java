import java.util.Scanner;

public class App {
    /**
     * Averages the numbers in an array
     * 
     * @param nums
     * @return average of array
     */
    public static int findAverage(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num; //sum = sum + each value in array
        }
        return sum / nums.length; //sum divided by array length
    }

    public static void main(String[] args) throws Exception {
        System.out.println("How many days of date?"); //prompt for number of days
        Scanner scnr = new Scanner(System.in);
        int numDays = scnr.nextInt(); //save number of days
        int[] morningTemp = new int[numDays]; //array for morning temp for a particular day
        int[] noonTemp = new int[numDays]; //array of noon temp for a particular day
        int[] nightTemp = new int[numDays]; //array of night temp for a particular day
        for (int day = 0; day < numDays; day++) {
            System.out.println("Enter morning temp."); //prompt morning temp for each day
            morningTemp[day] = scnr.nextInt(); //input temp for morning
            System.out.println("Enter noon temp."); //prompt noon temp for each day
            noonTemp[day] = scnr.nextInt(); //input temp for noon
            System.out.println("Enter night temp."); //prompt night temp for each day
            nightTemp[day] = scnr.nextInt(); //input temp for night
        }
        for (int day = 0; day < numDays; day++) {
            int[] dayTemp = { morningTemp[day], noonTemp[day], nightTemp[day] }; //store all temps for each day
            int dayAverage = findAverage(dayTemp); //average temps for each day
            System.out.println("Day " + (day + 1) + " average is: " + dayAverage);
        }
        int morningAverage = findAverage(morningTemp); //average all morning temps
        int noonAverage = findAverage(noonTemp); //average all noon temps
        int nightAverage = findAverage(nightTemp); //average all night temps
        System.out.println("Morning average for all days: " + morningAverage);
        System.out.println("Noon average for all days: " + noonAverage);
        System.out.println("Night average for all days: " + nightAverage);

        scnr.close();
    }
}

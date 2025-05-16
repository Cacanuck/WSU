import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Prompt user for Birthday
        Scanner scnr = new Scanner(System.in);
        System.out.println("When were you born? (Use the form 1 January 1970)");
        //Isolate Day
        String day = scnr.next();
        //isolate Month
        String month = scnr.next();
        //Isolate Year
        String year = scnr.next();
        //Print Day, Month, year seperate
        System.out.println("Day: " + day);
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
        
    }
}

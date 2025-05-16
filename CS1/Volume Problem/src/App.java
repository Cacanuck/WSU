import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {

        System.out.print("Enter the Radius of the sphere: ");

        Scanner scnr = new Scanner (System.in);
        int radius = scnr.nextInt();

        double fourThirds = (double) 4 / 3;
        double volume = (fourThirds * Math.PI * Math.pow(radius, 3.0));

        System.out.println("The volume of the sphere is:");
        System.out.printf("%.2f", volume);

        System.out.println();

    }
}

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Get user input for n value, if value is even or <3 display error
        Scanner scnr = new Scanner (System.in);
        System.out.println("What is the value of n?");
        int number = scnr.nextInt();
        if (number < 3 || number % 2 == 0) {
            System.out.println("Error: n must be an odd number greater than 3.");
        }
        //Draw an x with asterisks with n number of asterisks per line
        else { 
            for (int row = 0; row < number; row ++) {
                for (int col = 0; col < number; col++) {
                    if (row == col || row + col == number - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
    }
}
    }
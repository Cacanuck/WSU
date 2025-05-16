import java.util.Scanner;

/*
 * Class of the Driver
 * @author Trevor Hollack
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("Enter the length of the square's sides: ");

        try {
            Scanner scnr = new Scanner(System.in);
            Square square1 = new Square(scnr.nextDouble());

            System.out.println(square1);
            System.out.println("The perimeter of the square is: " + square1.getPerimeter());
            System.out.println("The area of the square is: " + square1.getArea());

            scnr.close();

        }
        /*
         * Catch block for if the user inputs a negative side length
         */
        catch (NegativeLengthException nle) {
            System.out.println(nle.getMessage());
        }
        /*
         * Catch block for if the user does not input a number
         */
        catch (Exception e) {
            System.out.println("Error: You must enter a number");
        }
    }
}

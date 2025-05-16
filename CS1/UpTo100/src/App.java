import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Prompt user for numbers until the total of the numbers is greater than 100
            Scanner scnr = new Scanner(System.in);
            int numInputs = 0;
            int total = 0;
            while (total < 100){
                System.out.println("Enter a number:");
                int number = scnr.nextInt();
                total = number + total;
                if (total < 100) {
                    ++numInputs;
                }
            }
        //Tell the user how many numbers were input before reaching 100
            System.out.println("You entered " + numInputs + " value(s) before the total was greater than 100.");
    }
}

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

    //Prompt User for numbers of days late
        System.out.println("Enter number of days late:");
        Scanner scnr = new Scanner (System.in);
        int days = scnr.nextInt();
    //Prompt user if they are a VIP member
        System.out.println("Are you a library VIP (yes/no)");
        Scanner scnr1 = new Scanner (System.in);
        String vip = scnr1.next();
    //Calculate base late fee
        double fee = 0;
        if (days <= 5){
            fee = 1.00;
        }
        else if (days > 5 && days <= 10) {
            fee = 5.00;
        }
        else if (days > 10) {
            fee = 10.00;
        }
    //Calculate if there is a VIP benefit
        if (vip.equals("yes")) {
            fee = fee / 2;
        }
    //Print late fee calculation
        System.out.println("Late fine is $" + fee + "0 for " + days + " days late.");
    }
}

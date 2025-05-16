import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //After every question, output the answer before asking next question
        
        //Variable to track total score
            int score = 0;
        //Question with Integer answer
            System.out.println("What is 17 + 3?");
            Scanner scnr = new Scanner (System.in);
            int answer = scnr.nextInt();
            if (answer == 20) {
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect!");
            }
        //Question with String answer (must allow upper and lower cases)
            System.out.println("What state starts with the letter O and ends with the letter O?");
            Scanner scnr1 = new Scanner (System.in);
            String answer1 = scnr1.next();
            String ohio = "ohio";
            if (ohio.equalsIgnoreCase(answer1)) {
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect!");
            }
        //Question with true/false answer (must allow upper and lower cases)
            System.out.println("True or False? Pigs can fly.");
            Scanner scnr2 = new Scanner (System.in);
            boolean answer2 = scnr2.nextBoolean();
            if (answer2 == false) {
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect!");
            }  
        //Question with double answer
            System.out.println("What is 7 divided by 2?");
            Scanner scnr3 = new Scanner (System.in);
            double answer3 = scnr3.nextDouble();
            if (answer3 == 3.5) {
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect!");
            } 
        //Question with 1 char answer
            System.out.println("What is the 3rd letter of the alphabet?");
            Scanner scnr4 = new Scanner (System.in);
            char answer4 = scnr4.next().charAt(0);
            if (answer4 == 'c') {
                System.out.println("Correct!");
                score ++;
            }
            else {
                System.out.println("Incorrect!");
            }
        //Calculate Score out of 5, and %
            double percent = (score / 5.0) * 100;
        //Print score and %
            System.out.println("You got " + score + " out of 5 right, for a score of " + percent + "%.");
    }
}

import java.util.Scanner;
import java.util.Random;

public class App {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void easyMode(Scanner scnr) {
        String color = "";
        Random randGen = new Random();
        int score = 1;
        String previousAnswers = "";
        boolean winning = true;
        while (winning) {
            // Easy Mode
            score = score + 1;
            int colorValue = randGen.nextInt(4) + 0;
            if (colorValue == 0) {
                color = "red";
            } else if (colorValue == 1) {
                color = "green";
            } else if (colorValue == 2) {
                color = "yellow";
            } else if (colorValue == 3) {
                color = "blue";
            }
            if (previousAnswers == "") {
                previousAnswers = color;
            } else {
                previousAnswers = previousAnswers + " " + color;
            }
            System.out.println("Simon says: " + previousAnswers);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            clearScreen();

            String colorInput = scnr.nextLine();
            int realScore = score - 1;
            colorInput = colorInput.replace(" ", "");

            if (colorInput.equals(previousAnswers.replace(" ", ""))) {
                System.out.println("Score: " + realScore);
            } else {
                realScore = realScore - 1;
                System.out.println("Round over! Your score was: " + realScore);
                System.out.println("Would you like to play another round? (yes/no)");
                String again = scnr.nextLine();
                if (again.equalsIgnoreCase("yes")) {
                    color = "";
                    score = 1;
                    previousAnswers = "";
                } else if (again.equalsIgnoreCase("no")) {
                    System.out.println("Thanks for playing!");
                    winning = false;
                } else {
                    System.out.println("Not a valid answer.");
                    winning = false;
                }
            }
        }
    }

    public static void hardMode(Scanner scnr) {
        String expectedAnswer = "";
        Random randGen = new Random();
        int score = 1;
        String previousAnswers = "";
        boolean winning = true;
        while (winning) {
            score = score + 1;
            int randomNumber = randGen.nextInt(10) + 0;
            expectedAnswer = String.valueOf(randomNumber);
            if (previousAnswers == "") {
                previousAnswers = expectedAnswer;
            } else {
                previousAnswers = previousAnswers + " " + expectedAnswer;
            }
            System.out.println("Simon says: " + previousAnswers);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            clearScreen();
            String numberInput = scnr.nextLine();
            int realScore = score - 1;
            numberInput = numberInput.replace(" ", "");
            System.out.println(previousAnswers + ":" + numberInput);
            if (String.valueOf(numberInput).equals(previousAnswers.replace(" ", ""))) {
                System.out.println("score: " + realScore);
            } else {
                realScore = realScore - 1;
                System.out.println("Round over! Your score was: " + realScore);
                System.out.println("Would you like to play another round? (yes/no)");
                String again = scnr.nextLine();
                if (again.equalsIgnoreCase("yes")) {
                    expectedAnswer = "";
                    score = 1;
                    previousAnswers = "";
                } else if (again.equalsIgnoreCase("no")) {
                    System.out.println("Thanks for playing!");
                    winning = false;
                } else {
                    System.out.println("Not a valid answer.");
                    winning = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // Ask user for easy mode or hard mode
        System.out.println("Let's play Simon Says!");
        System.out.println("Select Difficulty: (easy/hard)");
        Scanner scnr = new Scanner(System.in);
        String difficulty = scnr.nextLine();
        String easy = "easy";
        String hard = "hard";
        while (!difficulty.equalsIgnoreCase(easy) && !difficulty.equalsIgnoreCase(hard)) {
            System.out.println("Invalid Difficulty");
            System.out.println("Select Difficulty: (easy/hard)");
            difficulty = scnr.nextLine();
        }
        if (difficulty.equalsIgnoreCase(easy)) {
            System.out.println("Easy Mode - Colors");

        } else if (difficulty.equalsIgnoreCase(hard)) {
            System.out.println("hard Mode - Numbers");
        }
        // If invalid mode, prompt until valid mode
        if (difficulty.equalsIgnoreCase(easy)) {
            easyMode(scnr);
        } else if (difficulty.equalsIgnoreCase(hard)) {
            // Hard Mode
            hardMode(scnr);
        }
        // Ignore user spacing and case

        // Simon adds one additional thing every round

        // Tell user how many sequences got correct, prompt to play again and select
        // mode
    }
}
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class App {

    public static List<String> loadValidWords() {
        List<String> validWords = new ArrayList<>(); // crate String ArrayList named vaildWords
        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) { // reads data from the file
                                                                                        // words.txt
            String line; // stores the line of wards in words.txt
            while ((line = reader.readLine()) != null) { // while there are still characters in the line being read
                validWords.add(line.trim()); // add the text without the whitespaces to the arraylist of valid words
            }
        } catch (IOException exception) {
            System.err.println("words.txt has failed to load."); // runs if the file cannot be read
            System.exit(1);
        }
        return validWords;
    }

    public static String chooseWord(List<String> validWords) {
        Random random = new Random(); // create random number generator
        String uniqueLetters = null; // empty string to store unique letters
        List<String> sevenLetterWords = new ArrayList<>(); // String ArrayList to store seven letter wods

        for (String word : validWords) {
            if (word.length() == 7 && hasUniqueCharacters(word)) { // if word length = 7 and has unique characters
                sevenLetterWords.add(word); // add the words to the String ArrayList sevenLetterWords
            }
        }

        if (sevenLetterWords.isEmpty()) { // if there are no words in this STring ArrayList
            System.out.println("No seven letter words in words.txt."); // exit this block
            System.exit(1);
        }

        uniqueLetters = sevenLetterWords.get(random.nextInt(sevenLetterWords.size())); // choose a random words from
                                                                                       // sevenLetterWords to store
        return uniqueLetters;
    }

    public static boolean hasUniqueCharacters(String word) {
        for (int i = 0; i < word.length(); i++) { // for less than the length of string word
            char currentChar = word.charAt(i); // store the next character in currentChar
            for (int j = i + 1; j < word.length(); j++) {
                if (currentChar == word.charAt(j)) { // if char in currnetChar is at the same spot in word
                    return false; // false because the chars are not unique
                }
            }
        }
        return true;
    }

    public static void displayUniqueLetters(String uniqueLetters) {
        char[] lettersArray = uniqueLetters.toCharArray(); // character array created from a string
        Random random = new Random(); // new random number generator

        for (int i = 0; i < uniqueLetters.length(); i++) {
            int j = random.nextInt(uniqueLetters.length()); // j = a random int at max number of length of string
                                                            // uniqueLetters
            char temp = lettersArray[i]; // temp char to store data from the arrray
            lettersArray[i] = lettersArray[j]; // chars at position j are now in position i
            lettersArray[j] = temp; // cars in temp are now in position j
        }

        String scrambledLetters = new String(lettersArray); // store the scrambled letters in a string
        System.out.println(scrambledLetters);
    }

    public static String mixLetters(String uniqueLetters) {
        displayUniqueLetters(uniqueLetters); // scrambles the letters
        return uniqueLetters;
    }

    public static void displayGuessedWords(List<String> guessedWords) {
        for (String word : guessedWords) {
            System.out.println(word); // shows the user the words they guessed
        }
    }

    public static int validateWord(String word, List<String> guessedWords, List<String> validWords, int score) {
        if (validWords.contains(word) && !guessedWords.contains(word)) { // if validWords has the user words and the
                                                                         // user word was not already guessed
            int wordScore = word.length() == 4 ? 1 : word.length(); // give the score for the length of the word as 4 +
                                                                    // 1 for each extra letter
            score = score + wordScore; // compute the score
            guessedWords.add(word); // add the guessed word to the list of already guessed words
        }

        System.out.println("Score: " + score); // show the user the score
        return score;
    }

    public static void main(String[] args) throws Exception {
        List<String> validWords = loadValidWords(); // set the string of valid words
        List<String> guessedWords = new ArrayList<>(); // create new String ArrayList to store guessed words
        String uniqueLetters = null;
        int score = 0;
        while (true) {
            if (uniqueLetters == null) {
                uniqueLetters = chooseWord(validWords);
                displayUniqueLetters(uniqueLetters);
                System.out.println("Score: " + score);
            }
            Scanner scnr = new Scanner(System.in); // new scnr
            String input = scnr.nextLine(); // read user input

            if (input.equals("bye")) { // if user enters bye
                break; // end game
            } else if (input.equals("mix")) { // if user enters mix
                uniqueLetters = mixLetters(uniqueLetters); // shows letters in new order
            } else if (input.equals("ls")) { // if user enters ls
                displayGuessedWords(guessedWords); // shows all words that have been guessed
            } else if (input.length() >= 4 && uniqueLetters.contains(input)) { // user enters a word
                score = validateWord(input, guessedWords, validWords, score); // tests to see if the word is valid and
                                                                              // gives a score
            } else if (input.length() >= 4 && input.length() <= uniqueLetters.length()) { // Check if the input contains
                                                                                          // only the letters from the
                                                                                          // jumbled string.
                boolean validInput = true;
                for (char c : input.toCharArray()) { // run for each character in the input string
                    if (uniqueLetters.indexOf(c) == -1) { // check if the input is in the jumbled string
                        validInput = false; // input is not in the valid string
                        break;
                    }
                }
                if (validInput) {
                    score = validateWord(input, guessedWords, validWords, score); // if the input is valid, compute the
                                                                                  // score
                } else {
                    System.out.println("Invalid input."); // display if the input is not in the jumbled string
                }
            } else {
                System.out.println("Invalid input."); // display if the input is not a valid option or word
            }
        }
    }
}
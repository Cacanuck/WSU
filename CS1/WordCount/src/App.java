import java.io.*;
import java.util.Scanner;

public class App {
    /**
     * Creates a file, writes the provided string to the file, and returns the File object.
     *
     * @param fileName
     * @param fileMessage
     * @return File with fileMessage written in it
     * @throws IOException
     */
    public static File writeText(String fileName, String fileMessage) {
        try {
            File file = new File(fileName); //new file
            FileWriter fileWriter = new FileWriter(file); //new file writer
            fileWriter.write(fileMessage); //write messag to the file
            fileWriter.close();
            return file;
        } catch (IOException exception) { //close if exception
            return null;
        }
    }

    /**
     * Counts the number of words in a file.
     * A word is defined as any text separated by whitespace.
     *
     * @param file
     * @return number of words in file
     * @throws IOException
     */
    public static int countWords(File file) {
        try {
            Scanner scnr = new Scanner(file); //new scanner
            int wordCount = 0;
            while (scnr.hasNext()) { //looks for next word
                scnr.next(); //reads next word
                wordCount++;
            }
            scnr.close();
            return wordCount;
        } catch (IOException exception) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("What is the name of the file?"); //ask for name of file
        String fileName = scnr.nextLine(); //read user input
        System.out.print("What would you like to print to the file?"); //ask for message in file
        String fileMessage = scnr.nextLine(); //read user input
        File file = writeText(fileName, fileMessage); //create file and call writeText method
        if (file != null) { //tests to make sure a file was created before outputting
            int wordCount = countWords(file); //call countWords method
            System.out.println(fileName + " contains " + wordCount + " words."); //output
        }
        scnr.close();
    }
}
//Renamed some paramaters for easier viewing
//FileWriter or BufferedWriter seem to work better than FileStream for words
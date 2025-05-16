import net.lingala.zip4j.core.*;
import net.lingala.zip4j.exception.*;
import java.io.File;

/*
 * Class of the Searcher
 * @author Trevor Hollack
 */
public class Searcher extends Thread {

    /*
     * String filePath stores the name of a temp file
     */
    private final String filePath;

    /*
     * int passLength how long the password needs to be
     */
    private final int passLength;

    /*
     * int threadID the ID of which thread is being used
     */
    private final int threadID;

    /*
     * Constructor for the Searcher object
     * 
     * @param filePath
     * 
     * @param passLength
     * 
     * @param threadID
     */
    public Searcher(String filePath, int passLength, int threadID) {
        this.filePath = filePath;
        this.passLength = passLength;
        this.threadID = threadID;
    }

    /*
     * Method to generate every version of the password
     * 
     * @param passLength
     * 
     * @param index
     * 
     * @return password
     */
    private String makePassword(int passLength, int index) {
        StringBuilder password = new StringBuilder();
        String charString = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < charString.length(); i++) {
            char char1 = charString.charAt(i);
            for (int j = 0; j < charString.length(); j++) {
                char char2 = charString.charAt(j);
                for (int k = 0; k < charString.length(); k++) {
                    char char3 = charString.charAt(k);
                    password.setLength(0);
                    password.append(char1).append(char2).append(char3);
                }
            }
        }
        return password.toString();
    }

    /*
     * Overrides the run() method in the Thread class to generate and try every
     * password to open the zip file
     */
    @Override
    public void run() {
        if (!Driver.isPassFound()) {
            /*
             * Runs if the password has not yet been found, creates the threads and runs the
             * makePasswrod method, and tests the passwords on the zip file
             */
            try {
                File tempFile = new File(filePath);
                ZipFile zipfile = new ZipFile(tempFile);
                int totalPasswords = (int) Math.pow(26, passLength);
                int passPerThread = totalPasswords / Driver.numthreads;
                int startIndex = threadID * passPerThread;
                int endIndex = (threadID + 1) * passPerThread;
                for (int i = startIndex; i < endIndex + 26 * 26 * 26; i++) {
                    String password = makePassword(passLength, i);
                    System.out.println("Thread " + threadID + " trying password: " + password);
                    zipfile.setPassword(password);
                    zipfile.extractAll("contents-" + threadID);
                    Driver.setPassFound(true);
                    System.out.println("Thread: " + threadID + " cracked the password: " + password);
                }
            } catch (ZipException e) {

                /*
                 * Deletes the temp files that are created to test the passwords on the zip
                 * files
                 */
            } finally {
                File contentsDir = new File("contents-" + threadID);
                if (contentsDir.exists()) {
                    File[] files = contentsDir.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            file.delete();
                        }
                    }
                    contentsDir.delete();
                }
            }
        }
    }
}
import java.util.Scanner;

/*
 * Class of the Driver
 * @author Trevor Hollack
 */
public class Driver {
    public static void main(String[] args) throws Exception {

        /*
         * Prompt user for the upper limit for the calculation, how many threads to use,
         * and store those values
         */
        System.out.println();
        System.out.println(
                "Enter the the high value to test the number of prime numbers starting from 1.\n(if counting from 1 to 17, enter 17)");
        Scanner scnr = new Scanner(System.in);
        int maxVal = scnr.nextInt();
        System.out.println("Enter the numberof threads to use:");
        int numThreads = scnr.nextInt();
        scnr.close();

        /*
         * Create the number of threads needed, and divide the range specified into even
         * sections for the threads to handle
         */
        PrimeThread[] threads = new PrimeThread[numThreads];
        int section = maxVal / numThreads;

        /*
         *Assign each thread the section of numbers to calculate through 
         */
        for (int i = 0; i < numThreads; i++) {
            int start = i * section;
            int end = (i < numThreads - 1) ? start + section : maxVal;
            threads[i] = new PrimeThread(start, end);
            threads[i].start();
        }

        /*
         * Calculate how many primes are in each thread and add them together
         */
        int primeCount = 0;
        for (PrimeThread thread : threads) {
            try {
                thread.join();
                primeCount += thread.getTotalPrimes();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*
         * Give output to the user
         */
        System.out.println("There are: " + primeCount + " prime numbers between 1 and " + maxVal);
    }
}

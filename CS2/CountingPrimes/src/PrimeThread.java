/*
 * Class of the PrimeThread
 * @author trevor Hollack
 */
public class PrimeThread extends Thread {

    /*
     * int start the lower end of the range to calculate
     */
    private int start;

    /*
     * int end the upper end of the range to calculate
     */
    private int end;

    /*
     * int totalPrimes the value to hold the amount of prime numbers in the range
     */
    private int totalPrimes;

    /*
     * Constructor for the PrimeThread class
     * 
     * @param start
     * 
     * @param end
     */
    public PrimeThread(int start, int end) {
        this.start = start;
        this.end = end;
        this.totalPrimes = 0;
    }

    /*
     * Method to determine if a number is prime
     * 
     * @param n
     * 
     * @return false if n is <= 1
     * 
     * @return true if n is 2 or 3
     * 
     * @return false if n is divisible by 2 or 3
     * 
     * @return false if n is divisible by a prime number
     * 
     * @return true if the number does not apply to any of these cases
     */
    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /*
     * Overrides the run method in the Thread Class to see if each number in the
     * range is a prime, and to increment the number of total primes in that range
     * if a nubmer is found to be prime
     */
    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            if (isPrime(i)) {
                totalPrimes++;
            }
        }
    }

    /*
     * Getter method for the total number of primes calculated
     * 
     * @return totalPrimes
     */
    public int getTotalPrimes() {
        return totalPrimes;
    }
}
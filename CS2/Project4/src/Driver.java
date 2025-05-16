/*
 * Class of the Driver
 * @author trevor Hollack
 */
public class Driver {

	/*
	 * boolean passwordFound recognizes if the password has been found or not
	 */
	private static boolean passwordFound = false;

	/*
	 * String file holds the name of the file
	 */
	private static final String file = "protected3.zip";

	/*
	 * int numthreads the number of threads to generate
	 */
	public static final int numthreads = 4;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		crackPass(file, 3);

		long endTime = System.currentTimeMillis();
		long totalTime = (endTime - startTime);
		System.out.println("Took: " + totalTime + " MS to crack the password.");
	}

	/*
	 * Method to run multiple threads and test the generated passwords
	 * 
	 * @param STring filePath
	 * 
	 * @param int passLnegth
	 */
	private static void crackPass(String filePath, int passLength) {
		Thread[] threads = new Thread[numthreads];
		for (int i = 0; i < numthreads; i++) {
			threads[i] = new Thread(new Searcher(filePath, passLength, i));
			threads[i].start();
		}
		for (int i = 0; i < numthreads; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Method to detect if the password has been found
	 * 
	 * @return passwordFound
	 */
	public static boolean isPassFound() {
		return passwordFound;
	}

	/*
	 * Setter method for he passwordFound variable
	 * 
	 * @param b
	 */
	public static synchronized void setPassFound(boolean b) {
		passwordFound = b;
	}
}

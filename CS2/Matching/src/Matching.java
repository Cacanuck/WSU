/*
 * Class of Matching
 * @author Trevor Hollack
 */
public class Matching {

    /*
     * Method to check for nested parentheses in the string
     * 
     * @param String n
     * 
     * @return true if there is exactly 1 set of parentheses in the string
     * 
     * @return true if there is an empty string
     * 
     * @return false if there is not just a set of parentheses in the string
     */
    public static boolean nestParen(String n) {
        /*
         * Checks for exactly 1 set of parentheses in the string
         */
        if (n.equals("()")) {
            return true;
        }
        /*
         * Checks if the string is empty
         */
        else if (n.equals("")) {
            return true;
        }
        /*
         * If there is more than 1 set of parentheses in the string, remove the first
         * and last characters in the string and then run the method again recursively
         */
        else if (n.contains("()")) {
            String nNew1 = n.substring(1);
            String nNew2 = nNew1.substring(0, nNew1.length() - 1);
            return nestParen(nNew2);
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        String test1 = "()"; // should output true
        String test2 = "(())"; // should output true
        String test3 = "(((x)))"; // should output false
        String test4 = "((()))"; // should output true
        String test5 = "x"; // should output false
        String test6 = "((((()))))"; // should return true
        String test7 = "(x())"; // should return false
        String test8 = ""; // should return true
        String test9 = "())"; // should return false

        System.out.println();
        System.out.println("Test 1: " + nestParen(test1));
        System.out.println("Test 2: " + nestParen(test2));
        System.out.println("Test 3: " + nestParen(test3));
        System.out.println("Test 4: " + nestParen(test4));
        System.out.println("Test 5: " + nestParen(test5));
        System.out.println("Test 6: " + nestParen(test6));
        System.out.println("Test 7: " + nestParen(test7));
        System.out.println("Test 8: " + nestParen(test8));
        System.out.println("Test 9: " + nestParen(test9));
    }
}

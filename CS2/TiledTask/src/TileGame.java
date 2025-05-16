import java.util.ArrayDeque;
import java.util.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/*
 * Class of the Tile Game
 * @author Trevor Hollack
 */
public class TileGame {

    /*
     * int to track how many turns it takes to empty the stack
     */
    public static int turnTracker = 0;

    /*
     * Method to add and remove items to/from the stack based on what number is at
     * the start of the stack at the beginning of each turn, as well as output the
     * contents of the stack and how many turns it takes to empty the stack
     * 
     * @param stack
     * 
     * @param q
     * 
     * @return turnTracker which is the number of turns it takes to empty the stack
     * 
     * @return 0 if there is not a 1, 2, or 3 in the stack
     */
    public static int tileGame(ArrayDeque<Integer> stack, Queue<Integer> q) throws NoSuchElementException {

        System.out.println("Starting Stack: " + stack);
        System.out.println();

        while (stack.peek() != null) {
            /*
             * Top of Stack is a 1
             */
            if (stack.peek() == 1) {
                stack.pop();
                stack.pop();
                turnTracker = turnTracker + 1;
                System.out.println("Turn: " + turnTracker);
                System.out.println(stack);
                System.out.println("------------------------");
            }
            /*
             * Top of Stack is a 2
             */
            else if (stack.peek() == 2) {
                stack.pop();
                stack.pop();
                stack.pop();
                turnTracker = turnTracker + 1;
                System.out.println("Turn: " + turnTracker);
                System.out.println(stack);
                System.out.println("------------------------");
            }
            /*
             * Top of Stack is a 3
             */
            else if (stack.peek() == 3) {
                stack.pop();
                int q1 = q.remove();
                int q2 = q.remove();
                int q3 = q.remove();
                stack.push(q1);
                stack.push(q2);
                stack.push(q3);
                turnTracker = turnTracker + 1;
                System.out.println("Turn: " + turnTracker);
                System.out.println(stack);
                System.out.println("------------------------");
            }
            /*
             * There is not a 1, 2, or 3 in the Stack
             */
            else {
                System.out.println("Error: Integer that is not 1, 2, or 3 is in the stack. Ending...");
                return 0;
            }
        }
        System.out.println("Total Turns: " + turnTracker);
        return turnTracker;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(2);
        q.add(1);
        q.add(3);
        q.add(1);
        q.add(2);
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println();

        /*
         * Checks for NoSuchElementException in case the stack is empty before the end
         * of the turn, and completes the turn by adding 1 to the turnTracker counter,
         * which would not be incremented if the error occurs
         */
        try {
            tileGame(stack, q);
        } catch (NoSuchElementException e) {
            turnTracker = turnTracker + 1;
            System.out.println("Stack is empty");
            System.out.println("Total Turns: " + turnTracker);
        }
    }
}

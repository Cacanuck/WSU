import javax.swing.JFrame;

/*
 * @author Trevor Hollack
 * Class of the TicTacToe game
 */
public class TicTacToe {
    public static void main(String[] args) throws Exception {

        JFrame frame = new FilledFrame();

        frame.setTitle("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

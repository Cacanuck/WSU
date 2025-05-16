import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @author Trevor Hollack
 * Class of the FilledFrame
 * 
 * Changes made to the original project:
 * 
 * checkWin method and its implementation
 * rules method and its implementation
 * startGame method and its implementation
 * winnerScreen method and its implementation
 */
public class FilledFrame extends JFrame {
    /*
     * int value of frame's width
     */
    private static final int frameWidth = 400;
    /*
     * int value of frame's height
     */
    private static final int frameHeight = 500;
    /*
     * 2 dimenional array of buttons for the game board
     */
    private JButton[][] buttonGrid;
    /*
     * int that tracks which player's turn it is
     */
    private int currentPlayer;
    /*
     * panel for the buttons in the game
     */
    private JPanel gamePanel;
    /*
     * panel for the game state tracker
     */
    private JPanel gameState;
    /*
     * label to display which player's turn it is
     */
    private JLabel gameStatus;
    /*
     * parent frame for the whole game
     */
    private JFrame parentFrame;

    /*
     * Constructor of the FilledFrame
     */
    public FilledFrame() {
        rules();
    }

    /*
     * Rules method that contains a string of the rules in a JOptionPane, and once
     * the button is clicked teh game starts
     */
    public void rules() {
        String rules = "Rules of Tic Tac Toe\n\n\n" +
                "Players take turns clicking on empty squares to place their symbol.\n" +
                "The first player with 3 of their symbol in a row horizontally, vertically,\n" +
                "or diagonally wins.\n" +
                "Click the button to start the game.";

        parentFrame = new JFrame();
        JOptionPane.showMessageDialog(parentFrame, rules, "Rules", JOptionPane.INFORMATION_MESSAGE);

        startGame();
    }

    /*
     * startGame method the initializes the GamePanel and GameState tracker
     */
    public void startGame() {
        createGamePanel();
        createGameState();
        setSize(frameWidth, frameHeight);
    }

    /*
     * createGamePanel method that creates the panel for the buttons needed to play
     * the game, and
     * sets the location in the middle of the application
     */
    public void createGamePanel() {
        gamePanel = new JPanel(new GridLayout(3, 3));
        buttonGrid = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();

                button.addActionListener(new ClickListener(i, j));
                buttonGrid[i][j] = button;
                gamePanel.add(button);
            }
        }
        add(gamePanel, BorderLayout.CENTER);
    }

    /*
     * createGameState method that creates the panel for the game state tracker, and
     * tracks which
     * playr's turn it is
     */
    public void createGameState() {
        gameState = new JPanel(new FlowLayout());
        currentPlayer = 1;
        gameStatus = new JLabel("Game Status: Player " + currentPlayer + "'s turn.");
        gameState.add(gameStatus);
        add(gameState, BorderLayout.SOUTH);
    }

    /*
     * Local inner class to track when a button is clicked and to display the X or O
     * value to
     * the button, and switch the player's turn
     */
    class ClickListener implements ActionListener {
        private final int row;
        private final int column;

        public ClickListener(int row, int column) {
            this.row = row;
            this.column = column;
        }

        /*
         * actionPerformed method that overrides the default method to run the
         * buttonClicked method
         * when a button is clicked
         * 
         * @param ActionEvent e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            buttonClicked(e);
        }

        /*
         * buttonClicked method that displays an X or O when a button is clicked, and
         * changes
         * player turns after a button is clicked, as well as displays a window if a
         * player wins
         * 
         * @param ActionEvent e
         */
        public void buttonClicked(ActionEvent e) {
            if (buttonGrid[row][column].getText().equals("")) {
                if (currentPlayer == 1) {
                    buttonGrid[row][column].setText("X");
                    if (checkWin()) {
                        winnerScreen(1);
                    } else {
                        currentPlayer = 2;
                    }
                } else if (currentPlayer == 2) {
                    buttonGrid[row][column].setText("O");
                    if (checkWin()) {
                        winnerScreen(2);
                    } else {
                        currentPlayer = 1;
                    }
                }
                updateGameStatus();

            }
        }
    }

    /*
     * updateGameStatus method that updates the gameStatus label to display which
     * player's turn it is
     * after the turns switch
     */
    public void updateGameStatus() {
        gameStatus.setText("Game Status: Player " + currentPlayer + "'s turn.");
    }

    /*
     * checkWin method that checks to see if 3 buttons are in a row vertically,
     * horizontally, or diagonally are clicked by the same player
     * 
     * @return true if there is 3 buttons in a row clicked by the same player
     * 
     * @return false if there are no 3 buttons in a row from the same player
     */
    public boolean checkWin() {

        /*
         * Checks rows
         */
        for (int i = 0; i < 3; ++i) {
            if (buttonGrid[i][0].getText().equals(buttonGrid[i][1].getText())
                    && buttonGrid[i][0].getText().equals(buttonGrid[i][2].getText())
                    && !buttonGrid[i][0].getText().equals("")) {
                return true;
            }
        }

        /*
         * Checks columns
         */
        for (int i = 0; i < 3; i++) {
            if (buttonGrid[0][i].getText().equals(buttonGrid[1][i].getText()) &&
                    buttonGrid[0][i].getText().equals(buttonGrid[2][i].getText()) &&
                    !buttonGrid[0][i].getText().equals("")) {
                return true;
            }
        }

        /*
         * Checks diagonals
         */
        if (buttonGrid[0][0].getText().equals(buttonGrid[1][1].getText()) &&
                buttonGrid[0][0].getText().equals(buttonGrid[2][2].getText()) &&
                !buttonGrid[0][0].getText().equals("")) {
            return true;
        }
        if (buttonGrid[0][2].getText().equals(buttonGrid[1][1].getText()) &&
                buttonGrid[0][2].getText().equals(buttonGrid[2][0].getText()) &&
                !buttonGrid[0][2].getText().equals("")) {
            return true;
        }
        return false;
    }

    /*
     * Method that displays a JOptionPane with the winner of the game
     * 
     * @param winner the player that won
     */
    public void winnerScreen(int winner) {
        JOptionPane.showMessageDialog(this, "Player " + winner + " wins.\n");
    }
}
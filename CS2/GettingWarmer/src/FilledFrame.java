import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;

/*
 * Class of the FilledFrame
 * @author Trevor Hollack
 */
public class FilledFrame extends JFrame {
    /*
     * Button to activate the conversion
     */
    private JButton Convert;
    /*
     * Label fo the Fahrenheit text box
     */
    private JLabel Fahrenheit;
    /*
     * Label for the Celsius text box
     */
    private JLabel Celsius;
    /*
     * TextField for the Fahrenheit input
     */
    private JTextField fText;
    /*
     * TextField for the Celsius output
     */
    private JTextField cText;
    /*
     * int value of the frame's width
     */
    private static final int frameWidth = 200;
    /*
     * int value of the frame's height
     */
    private static final int frameHeight = 120;
    /*
     * double user's input in Fahrenheit
     */
    private double input;
    /*
     * double value of conversion into Celsius
     */
    private double output;
    /*
     * FormattedTextField to read input in the Fahrenheit box
     */
    private JFormattedTextField inputField;

    /*
     * Constructor for the FilledFrame
     */
    public FilledFrame() {
        createFTextField();
        createCTextField();
        createConvertButton();
        createPanel();
        setSize(frameWidth, frameHeight);
    }

    /*
     * createPanel method that creates a panel and adds all of the assets needed to
     * the panel
     */
    private void createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(Fahrenheit);
        panel.add(Celsius);
        panel.add(fText);
        panel.add(cText);
        panel.add(Convert);
        add(panel);
    }

    /*
     * createFTextField method that creates and sets the location of the text field for
     * Fahrenheit, as well as the FormattedTextField to read user input
     */
    private void createFTextField() {
        Fahrenheit = new JLabel("Fahrenheit");
        final int fieldWidth = 10;
        fText = new JTextField(fieldWidth);
        Fahrenheit.setBounds(5, 0, 75, 30);
        fText.setBounds(2, 30, 75, 30);

        inputField = new JFormattedTextField(NumberFormat.getNumberInstance());
        inputField.setText(null);

    }

    /*
     * createCTextField method that creates and sets the location of the text field
     * for Celsius
     */
    private void createCTextField() {
        Celsius = new JLabel("Celsius");
        final int fieldWidth = 10;
        cText = new JTextField(fieldWidth);
        Celsius.setBounds(100, 0, 75, 30);
        cText.setBounds(97, 30, 75, 30);

    }

    /*
     * createConvertButton method that creates the button to start the conversion of
     * user input, as well as the logic to perform the conversion
     */
    private void createConvertButton() {
        Convert = new JButton("Convert");
        Convert.setBounds(50, 60, 75, 30);

        Convert.addActionListener(e -> {
            try {
                String sInput = fText.getText();
                input = Double.parseDouble(sInput);
                output = (input - 32) * 5 / 9;
                double roundOutput = Math.round(output * 10.0) / 10.0;
                String sOutput = roundOutput + "";
                cText.setText(sOutput);
            } catch (Exception exception) {
                cText.setText("Error: Bad Input");
            }
        });

    }
}

/*
 * Class for Squares
 * @author Trevor Hollack
 */

public class Square {

    /*
     * Stores the side length of the square
     */
    private double side;

    /*
     * Constructor of the Square
     * 
     * @param side stored length value
     */
    public Square(double side) throws NegativeLengthException, Exception {
        this.side = side;
        if (side < 0) {
            throw new NegativeLengthException("" + side);
        }
    }

    /*
     * Method that defines how the Square object's value will be printed
     * 
     * @return Square with side: side
     */
    public String toString() {
        return ("Square with side: " + side);
    }

    /*
     * Method that calculates the perimeter of the Square object
     * 
     * @return side * 4
     */
    public double getPerimeter() {
        return side * 4;
    }

    /*
     * Method that calculates the area of the Square object
     * 
     * @return side * side
     */
    public double getArea() {
        return side * side;
    }
}

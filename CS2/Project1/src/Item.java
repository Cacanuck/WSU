/*
 * Class for the Item
 * @author Trevor Hollack
 */
public class Item {
    /*
     * Label for the Item
     */
    private final String name;
    /*
     * Weight of the item in pounds
     */
    private final double weight;
    /*
     * Value of the item rounded to the nearest dollar
     */
    private final int value;
    /*
     * Idicates whether the item should be taken or not
     */
    private boolean included;

    /*
     * Constructor of the Item, included is initialized to false
     * 
     * @param name name of item
     * 
     * @param weight weight of item in pounds
     * 
     * @param value value of item rounded to nearest dollar
     */
    public Item(String name, double weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    /*
     * Contructor of an Item, initializes fields to be the same as the other item's
     * 
     * @param other the other item that is to be copied
     */
    public Item(Item other) {
        this(other.getName(), other.getWeight(), other.getValue());
    }

    /*
     * getter for the Name field
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /*
     * Getter for the Weight field
     * 
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /*
     * Getter for the Value field
     * 
     * @return value
     */
    public int getValue() {
        return value;
    }

    /*
     * Getter for the Included field
     * 
     * @return included
     */
    public boolean isIncluded() {
        return included;
    }

    /*
     * Setter for the Included field
     * 
     * @param included if the value is taken or not
     */
    public void setIncluded(boolean included) {
        this.included = included;
    }

    /*
     * Displays the item in the form <name> (<weight> lbs, $<value>)
     */
    @Override
    public String toString() {
        return (name + " ( " + weight + " lbs, $" + value) + " )";
    }
}

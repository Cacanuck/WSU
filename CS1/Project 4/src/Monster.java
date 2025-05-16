public class Monster {
    private String name; //store Monster name
    private int health; //store Monster health
    private int row; //store row monster is in
    private int col; //store column monster is in

    public Monster(String name, int health) { //Monster object
        this.name = name; //sets Monster name
        this.health = health; //sets Monster health
    }

    /*
     * @return name
     */
    public String getName() {
        return name; //gets name of Monster and stores it
    }

    /*
     * @return health
     */
    public int getHealth() {
        return health; //gets the Health of Monster and stores it
    }

    /*
     * @return row
     */
    public int getRow() {
        return row; //gets the row value the Monster is in and stores it
    }

    /*
     * @return col
     */
    public int getCol() {
        return col; //gets the column value the Monster is in and stores it
    }

    /*
     * @param int row
     * @param int col
     * @return void
     */
    public void setPosition(int row, int col) {
        this.row = row; //sets Monster position at row value
        this.col = col; //sets Monster position at col value
    }

    /*
     * @param int damage
     * @return void
     */
    public void decreaseHealth(int damage) {
        health -= damage; //decrease Monster health by calculate damage value
    }
}
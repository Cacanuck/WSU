import java.util.Random;

public class Hero {
    private String name; // store Hero name
    private int health; // store Hero health

    public Hero(String name, int health) { // Hero object
        this.name = name; // sets Hero name
        this.health = health; // sets Hero health
    }

    /*
     * @return name
     */
    public String getName() {
        return name; // gets the name of Hero and store it
    }

    /*
     * @return health
     */
    public int getHealth() {
        return health; // gets the health of Hero and store it
    }

    /*
     * @return random int from 1-10
     */
    public int attack() {
        Random rand = new Random();
        return rand.nextInt(10) + 1; // generate random int from 1-10
    }

    /*
     * @param int damage
     * 
     * @return void
     */
    public void takeDamage(int damage) {
        health -= damage; // subract the calculated damage value from Hero health
    }

    /*
     * @return void
     */
    public void displayHealth() {
        System.out.println(name + "'s current health: " + health); // display Heros currnet health to user
    }
}
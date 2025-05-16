import java.util.Random;

public class Player {
    private String name;
    private int health;
    private int maxDamage;
    
    public Player(String name, int maxDamage) { //Player constructor
        this.name = name; //store name from main
        this.health = 100; //store health from main
        this.maxDamage = maxDamage; //store max damage from main
    }
    
    public void setName(String name) { //set name method
        this.name = name;
    }
    
    public String getName() { //get name method
        return name;
    }
    
    public void setHealth(int health) { //set health method
        this.health = health;
    }
    
    public int getHealth() { //get health method
        return health;
    }
    
    public void setMaxDamage(int maxDamage) { //set max damage method
        this.maxDamage = maxDamage;
    }
    
    public int getMaxDamage() { //get max damage method
        return maxDamage;
    }
    
    public void dealDamage(Player other) { //method to deal damage
        Random random = new Random();
        int damage = random.nextInt(other.getMaxDamage() + 1); //random damage based on max damage of other player
        other.health -= damage; //apply damage to other player
        if (other.health < 0) {
            other.health = 0; //make sure health doesn't go below 0
        }
    }
    
    // Override toString method
    @Override
    public String toString() {
        return name + ": HP " + health;
    }
}
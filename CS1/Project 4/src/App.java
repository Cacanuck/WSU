import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in); //create new scanner

        System.out.println("Welcome to Catacomb Crawler!");
        System.out.print("Enter your hero's name: ");
        String heroName = scnr.nextLine(); //read input for Hero name

        int catacombSize;
        do {
            System.out.print("Enter the size of the catacomb (between 5 and 10): ");
            catacombSize = scnr.nextInt(); //read input for catacomb size
        } while (catacombSize < 5 || catacombSize > 10); //Loop maintinas catacomb size

        Hero hero = new Hero(heroName, 100); //new Hero object with health 100

        int totalMonsters = catacombSize * catacombSize / 6; //calculate how many monsters to generate
        List<Monster> monsters = generateMonsters(totalMonsters, catacombSize); //store monsters generated

        int currentRoomRow = 0; //value of row Hero is in
        int currentRoomCol = 0; //value of column Hero is in

        while (hero.getHealth() > 0) { //loop runs while hero is alive
            hero.displayHealth(); //show user the hero health
            int nearbyMonsters = countNearbyMonsters(monsters, currentRoomRow, currentRoomCol); //store value of how many monsters are nearby
            System.out.println(heroName + " senses " + nearbyMonsters + " monster(s) nearby."); //tell user how mnay monsters are nearby
            System.out.println(heroName + " is in room [" + currentRoomRow + ", " + currentRoomCol + "]"); //tell user current Hero location

            List<Monster> monstersInCurrentRoom = getMonstersInRoom(monsters, currentRoomRow, currentRoomCol); //check if MonstersInRoom list has a value of the current room
        if (!monstersInCurrentRoom.isEmpty()) { //if there is a monster is in the current room
            System.out.println("You encounter monsters in this room!");

            for (Monster monster : monstersInCurrentRoom) { //Loop runs for each monster in the current room
                while (monster.getHealth() > 0 && hero.getHealth() > 0) { //runs if both Monster and Hero are alive
                        int heroDamage = hero.attack(); //hero attack damage generated
                        monster.decreaseHealth(heroDamage); //Monster health subtracted by heroDamage
                        System.out.println("You hit " + monster.getName() + " for " + heroDamage + " damage."); //combat log for user

                        if (monster.getHealth() <= 0) { //runs if monster dies
                            monsters.remove(monster); //remove monster object
                            System.out.println(monster.getName() + " has been defeated!");
                            break; //exit combat
                        }

                        int monsterDamage = new Random().nextInt(5) + 1; //generate monster damage
                        hero.takeDamage(monsterDamage); //hero health modified by monster damage
                        System.out.println(monster.getName() + " hits you for " + monsterDamage + " damage."); //combat log for user

                        if (hero.getHealth() <= 0) { //runs if hero dies
                            System.out.println("You were defeated by " + monster.getName() + ". Game over!");
                            return; //ends game
                        }
                    }
                }
            } else { //runs if no monsters are nearby
                System.out.println("No monsters detected nearby. You can safely move.");
                System.out.print("Which way do you want to move? (north/south/east/west): ");
                String direction = scnr.next().toLowerCase(); //user input for movement direction

                switch (direction) {
                    case "north": //user enters north
                        if (currentRoomRow > 0) { //checks if Hero can move north
                            currentRoomRow--; //subtract row by 1
                            hero.takeDamage(2); //damage for moving
                        } else {
                            System.out.println("You cannot move north.");
                        }
                        break;
                    case "south": //user enters south
                        if (currentRoomRow < catacombSize - 1) { //checks if hero can move south
                            currentRoomRow++; //add row by 1
                            hero.takeDamage(2); //damage for moving
                        } else {
                            System.out.println("You cannot move south.");
                        }
                        break;
                    case "east": //user enters east
                        if (currentRoomCol < catacombSize - 1) { //checks if hero can move east
                            currentRoomCol++; //add column by 1
                            hero.takeDamage(2); //damage for moving
                        } else {
                            System.out.println("You cannot move east.");
                        }
                        break;
                    case "west":
                        if (currentRoomCol > 0) { //checks if hero can move west
                            currentRoomCol--; //subtract 1 to column
                            hero.takeDamage(2); //damage for moving
                        } else {
                            System.out.println("You cannot move west.");
                        }
                        break;
                    default:
                        System.out.println("Invalid direction."); //user does not enter valid direction
                }
            }

            if (currentRoomRow == catacombSize - 1 && currentRoomCol == catacombSize - 1) { //checks if Hero is in bottom right corner
                System.out.println("Congratulations! You have reached the exit. You win!");
                return;
            }
        }

        System.out.println("Game over!");
        scnr.close();
    }

    /*
     * @param int totalMonsters
     * @param int catacombSize
     * @return mosters
     */
    private static List<Monster> generateMonsters(int totalMonsters, int catacombSize) {
        List<Monster> monsters = new ArrayList<>(); //new monster array list
        Random random = new Random(); //random number generator

        for (int i = 0; i < totalMonsters; i++) { //generate a row and column value for each monster in list
            int row;
            int col;
            do {
                row = random.nextInt(catacombSize); //random row value
                col = random.nextInt(catacombSize); //random col value
            } while ((row == 0 && col == 0) || (row == 0 && col == 1) || (row == 1 && col == 0)); //monsters cant spawn in (0,0) or next to it

            monsters.add(new Monster("Monster " + (i + 1), 25)); //give monsters number name and health
            monsters.get(i).setPosition(row, col); //store position generated for monster
        }

        return monsters;
    }

    /*
     * @param list of monsters
     * @param int currentRoomRow
     * @param int currentRoomCol
     * @return nearbyMonsters
     */
    private static int countNearbyMonsters(List<Monster> monsters, int currentRoomRow, int currentRoomCol) {
        int nearbyMonsters = 0; //number of nearby monsters

        for (Monster monster : monsters) { //run for each monster in the list
            int monsterRow = monster.getRow(); //get row value of each monster
            int monsterCol = monster.getCol(); //get col value of each monster

            if ((monsterRow == currentRoomRow - 1 && monsterCol == currentRoomCol) ||  //checks if monster is north of hero
                    (monsterRow == currentRoomRow + 1 && monsterCol == currentRoomCol) ||  //checks if monster is south of hero
                    (monsterRow == currentRoomRow && monsterCol == currentRoomCol - 1) ||  //checks if monster is west of hero
                    (monsterRow == currentRoomRow && monsterCol == currentRoomCol + 1)) {  //checks if monster is east of hero
                nearbyMonsters++; //add 1 for each monster 1 unit away from hero
            }
        }

        return nearbyMonsters;
    }

    /*
     * @param list of monsters
     * @param currentRoomRow
     * @param currentRoomCol
     * @return monstersInRoom
     */
    private static List<Monster> getMonstersInRoom(List<Monster> monsters, int currentRoomRow, int currentRoomCol) {
        List<Monster> monstersInRoom = new ArrayList<>(); //new monster list
        for (Monster monster : monsters) { //runs for each monster in list
            if (monster.getRow() == currentRoomRow && monster.getCol() == currentRoomCol) { //checks if monster in list is in the hero current room
                monstersInRoom.add(monster); //places the monster into the room with the hero
            }
        }
        return monstersInRoom;
    }
}
public class App {
    public static void main(String[] args) {
        
        Player player1 = new Player("One Punch Man", 20); //Player 1 Initialize
        Player player2 = new Player("Enemy", 20);//Player 2 Initialize
        
        while (player1.getHealth() > 0 && player2.getHealth() > 0) { //Game loop
            if (player2.getHealth() > 0) { //check if player 2 still has health
            player1.dealDamage(player2); //Player 1 damage Player 2
            System.out.print(player1 + " "); //Print Player 1 Health
            System.out.println(player2); //Print Player 2 health
            }
            if (player1.getHealth() > 0) { //check if player 1 still has health
            player2.dealDamage(player1); //Player 2 damage Player 1
            System.out.print(player1 + " "); //Print player 1 Health
            System.out.println(player2); //Print PLayer 2 Health
        }
        }
        Player survivingPlayer = (player1.getHealth() > 0) ? player1 : player2; //find which player has greater than 0 health when 1 has 0 health
        System.out.println("Victory: " + survivingPlayer.getName() + " - " + survivingPlayer.getHealth() + " HP"); //Print winning player name and health
    }
}
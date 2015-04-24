import java.util.Scanner;
/**
 * Plays the game!
 * 
 * @Michael Chen 
 * @1.0.3
 */
public class GameViewer
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("An adventurer is you!");
        System.out.println("");
        Game game = new Game();
        System.out.println("Hello, and welcome to the Legend of Chicken man!");
        System.out.println("There is a Sword and a Shield for you in the grasp of a mighty foe, if you can find him.");
        System.out.println("Controls:\nType fight to fight the monster before you!\nType any cardinal direction to move in that direction (Given that direction is open)!");
        game.map[3][1].enter(game);
    }
}

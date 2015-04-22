import java.util.Scanner;
public class GameViewer
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("An adventurer is you! What is your name?: ");
        String name = s.next();
        Game game = new Game(name);
        System.out.println("Hello, and welcome to the Legend of Chicken man!");
        System.out.println("There is a Sword and a Shield for you in the grasp of a mighty foe, if you can find him.");
        System.out.println("Controls:\nType fight to fight the monster before you!\nType any cardinal direction to move in that direction (Given that direction is open)!");
        game.map[3][1].enter(game);
    }
}

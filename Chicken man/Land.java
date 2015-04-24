import java.util.Scanner;
/**
 * The base of the game, decides all actions and reactions
 * 
 * @Michael Chen
 * @1.1.2
 */
public class Land
{
    /** description of instance variable x (add comment for each instance variable) */
    Scanner s = new Scanner(System.in);
    private boolean north, south, east, west, isMonster, isSafe, isAchieve, hasSword, hasShield;
    private String[] monsters = {"Orc", "Warlock", "Chicken", "Hog", "Bureaucrat", "Tax collector", "Goblin", "Lawyer", "Witch", "Shaman", "Assassin"};
    private String[] adjectives = {"Evil", "Greedy", "Malicious", "Fat", "Chinese", "Angry", "Nasty", "Large", "Brutal", "Sleazy", "Sneaky", "Radioactive", "Malevolent",
            "Mugwump", "Orc", "Underling", "Overly-Ambitious", "Underachieving", "Awful", "Ugly", "Orange", "Old", "Demonic"};
    private Monster monster;
    private Game game;
    /**
     * Default constructor for objects of class Land
     */
    public Land(boolean nurth, boolean surth, boolean wust, boolean eust, boolean isMunster, boolean isSufe, boolean isUchieve, boolean hasSwurd, boolean hasShuld, Game game1)
    {
        
        north = nurth;
        south = surth;
        east = eust;
        west = wust;
        isMonster = isMunster;
        hasSword = hasSwurd;
        hasShield = hasShuld;
        isAchieve = isUchieve;
        // if the land has a shield or sword, the monster is a boss
        if(hasSword || hasShield)
        {
            monster = new Monster(false, true);
        }
        else if(isAchieve)
        {
            monster = new Monster(true, false);
        }
        else
        {
            monster = new Monster(false, false);
        }
        isSafe = isSufe;

        // if the land has a

        game = game1;
    }

    public void action(Game game)
    {
        String action = s.next();
        /** Combat mechanics */
        if(action.equals("fight"))
        {
            if(this.isMonster == true)
            {
                int monstRoll = (int) (Math.random() * 100);
                int win = game.player.rollDmg(monstRoll);
                if(win > 0)
                {
                    if(game.player.hasSword())
                    {
                        System.out.println("The monster takes increased damage from your sword!");
                        monster.takeDamage();
                    }
                    System.out.println("The monster takes damage!");
                    monster.takeDamage();
                    System.out.println("The monster has " + monster.hp() + " health remaining!");
                    if(monster.hp() < 0)
                    {
                        System.out.println("You have defeated the monster!");
                        this.isMonster = false;
                        if(hasShield == true)
                        {
                            game.player.getShield();
                        }
                        if(hasSword == true)
                        {
                            game.player.getSword();
                        }
                        if(isAchieve == true)
                        {
                            System.out.println("You have beat the boss of this world! You win!");
                            game.player.die(true);
                        }
                        else
                        {
                            this.enter(game);
                            action(game);
                        }
                        action(game);
                    }
                }
                else
                {
                    System.out.println("You take some damage!");
                    System.out.println("You have " + game.player.hp() + " health remaining!");
                    game.player.takeDamage(monster.big());
                    if(game.player.hp() < 0)
                    {
                        System.out.println("You take your last amount of damage and die!");
                        game.player.die(false);
                    }
                    else
                    {
                        action(game);
                    }
                }
            }
            else
            {
                System.out.println("There is no monster here...");
                action(game);
            }
        }
        /** The next four methods move the player and punishes for ignoring boundaries*/
        else if(action.equals("north"))
        {
            if(isMonster == true)
            {
                System.out.println("There is a monster blocking your path!");
                System.out.println("You take damage from the monster while distracted!");
                game.player.takeDamage(monster.big());
                action(game);
            }
            else
            {

                if(north == true)
                {
                    game.player.decreaseRow();
                    game.map[game.player.row()][game.player.column()].enter(game);
                }
                else
                {
                    if(game.player.row() == 0)
                    {
                        System.out.println("You, having foolishly walked off the end of the world, fall off and die.");
                        game.player.die(false);
                    }
                    else
                    {
                        System.out.println("That way is blocked!");
                        action(game);
                    }
                }
            }
        }
        else if(action.equals("south"))
        {
            if(isMonster == true)
            {
                System.out.println("There is a monster blocking your path!");
                System.out.println("You take damage from the monster while distracted!");
                game.player.takeDamage(monster.big());
                action(game);
            }
            else
            {

                if(south == true)
                {
                    game.player.increaseRow();
                    game.map[game.player.row()][game.player.column()].enter(game);
                }
                else
                {
                    if(game.player.row() == 4)
                    {
                        System.out.println("You, having foolishly walked off the end of the world, fall off and die.");
                        game.player.die(false);
                    }
                    else
                    {
                        System.out.println("That way is blocked!");
                        action(game);
                    }
                }
            }
        }
        else if(action.equals("west"))
        {
            if(isMonster == true)
            {
                System.out.println("There is a monster blocking your path!");
                System.out.println("You take damage from the monster while distracted!");
                game.player.takeDamage(monster.big());
                action(game);
            }
            else
            {

                if(west == true)
                {
                    game.player.decreaseCol();
                    game.map[game.player.row()][game.player.column()].enter(game);
                }
                else
                {
                    if(game.player.column() == 0)
                    {
                        System.out.println("You, having foolishly walked off the end of the world, fall off and die.");
                        game.player.die(false);
                    }
                    else
                    {
                        System.out.println("That way is blocked!");
                        action(game);
                    }
                }
            }
        }
        else if(action.equals("east"))
        {
            if(isMonster== true)
            {
                System.out.println("There is a monster blocking your path!");
                System.out.println("You take damage from the monster while distracted!");
                game.player.takeDamage(monster.big());
                action(game);
            }
            else
            {

                if(east == true)
                {
                    game.player.increaseCol();
                    game.map[game.player.row()][game.player.column()].enter(game);
                }
                else
                {
                    if(game.player.column() == 3)
                    {
                        System.out.println("You, having foolishly walked off the end of the world, fall off and die.");
                        game.player.die(false);
                    }
                    else
                    {
                        System.out.println("That way is blocked!");
                        action(game);
                    }
                }
            }
        }
        else
        {
            System.out.println("That is not a valid command. Dingus.");
            action(game);
        }
    }

    public void enter(Game game)
    {
        //These find what monster you're defending from
        int munster = (int) (Math.random() * 10);
        int adj = (int) (Math.random() * 22);
        String monster = monsters[munster];
        String adjective = adjectives[adj];
        String modifier = "";
        //Checks if it starts with a vowel, in which case it adds an "n" to a
        if(monster.substring(0,1) == "A" ||monster.substring(0,1) == "E"||monster.substring(0,1) == "I"||monster.substring(0,1) == "O"||monster.substring(0,1) == "U")
        {
            modifier = "n";
        }
        //Heals the player so that he doesn't die.
        if(isSafe)
        {
            System.out.println("You feel safe, take rest, and are healed.");
            game.player.heal();
            System.out.println("You have "+game.player.hp()+" health");
            this.isSafe = false;
        }
        //Checks if you're encountering a monster
        if(isMonster == true)
        {
            System.out.println("There is a"+modifier+" " + adjective +" "+ monster + " before you! \nWhat do you do?");
            action(game);
        }
        else
        {
            //Tells the player where they can go
            System.out.print("You see an opening to the ");
            if(north == true)
            {
                System.out.print("north, ");
            }
            if(south == true)
            {
                System.out.print("south, "); 
            }
            if(east == true)
            {
                System.out.print("east, ");
            }
            if(west == true)
            {
                System.out.print("west, ");
            }
            if(game.player.row() == 0)
            {
                System.out.println("");
                System.out.println("You see the end of the world to your north.");
                System.out.println("It would be wise not to walk off.");
            }
            if(game.player.row() == 4)
            {
                System.out.println("");
                System.out.println("You see the end of the world to your south.");
                System.out.println("It would be wise not to walk off.");
            }
            if(game.player.column() == 0)
            {
                System.out.println("");
                System.out.println("You see the end of the world to your west.");
                System.out.println("It would be wise not to walk off.");
            }
            if(game.player.column() == 3)
            {
                System.out.println("");
                System.out.println("You see the end of the world to your east.");
                System.out.println("It would be wise not to walk off.");
            }
            System.out.println("");
        }
        action(game);
    }
}

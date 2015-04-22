import java.util.Scanner;
public class Land
{
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
        // if the land has a shield or sword, the monster is a boss
        if(hasSword || hasShield)
        {
            monster = new Monster(false, true);
        }
        isSafe = isSufe;
        isAchieve = isUchieve;
        // if the land has a
        if(isAchieve)
        {
            monster = new Monster(true, false);
        }
        game = game1;
    }

    public void action(Game game)
    {
        String action = s.next();
        if(action == "fight")
        {
            if(this.isMonster)
            {
                if(game.player.rollDmg((int)Math.random() * 100) > 1)
                {
                    if(game.player.hasSword())
                    {
                        System.out.println("The monster takes increased damage from your sword!");
                        monster.takeDamage();
                    }
                    System.out.println("The monster takes damage!");
                    monster.takeDamage();
                    if(monster.hp() < 0)
                    {
                        System.out.println("You have defeated the monster!");
                        this.isMonster = false;
                        if(hasShield)
                        {
                            game.player.getShield();
                        }
                        if(hasSword)
                        {
                            game.player.getSword();
                        }
                        this.enter(game);
                        action(game);
                    }
                    action(game);
                }
                else
                {
                    game.player.takeDamage();
                    action(game);
                }
                
            }
            else
            {
                System.out.println("There is no monster here...");
                action(game);
            }
        }
        if(action == "north")
        {
            if(isMonster)
            {
                System.out.println("There is a monster blocking your path!");
                System.out.println("You take damage from the monster while distracted!");
                game.player.takeDamage();
                action(game);
            }
            else
            {
                
                if(north)
                {
                    game.player.increaseRow();
                    game.map[game.player.row()][game.player.column()].enter(game);
                }
                else
                {
                    if(game.player.row() == 0)
                    {
                        System.out.println("You, having foolishly walked off the end of the world, fall off and die.");
                        game.player.die();
                    }
                    else
                    {
                        System.out.println("That way is blocked!");
                        action(game);
                    }
                }
            }
        }
        if(action == "south")
        {
            if(isMonster)
            {
                System.out.println("There is a monster blocking your path!");
                System.out.println("You take damage from the monster while distracted!");
                game.player.takeDamage();
                action(game);
            }
            else
            {
                
                if(south)
                {
                    game.player.increaseRow();
                }
                else
                {
                    if(game.player.row() == 4)
                    {
                        System.out.println("You, having foolishly walked off the end of the world, fall off and die.");
                        game.player.die();
                    }
                    else
                    {
                        System.out.println("That way is blocked!");
                    }
                }
            }
        }
        if(action == "west")
        {
            if(isMonster)
            {
                System.out.println("There is a monster blocking your path!");
                System.out.println("You take damage from the monster while distracted!");
                game.player.takeDamage();
                action(game);
            }
            else
            {
                
                if(west)
                {
                    game.player.decreaseCol();
                }
                else
                {
                    if(game.player.row() == 3)
                    {
                        System.out.println("You, having foolishly walked off the end of the world, fall off and die.");
                        game.player.die();
                    }
                    else
                    {
                        System.out.println("That way is blocked!");
                    }
                }
            }
        }
        if(action == "east")
        {
            if(isMonster)
            {
                System.out.println("There is a monster blocking your path!");
                System.out.println("You take damage from the monster while distracted!");
                game.player.takeDamage();
                action(game);
            }
            else
            {
                
                if(east)
                {
                    game.player.increaseCol();
                }
                else
                {
                    if(game.player.row() == 3)
                    {
                        System.out.println("You, having foolishly walked off the end of the world, fall off and die.");
                        game.player.die();
                    }
                    else
                    {
                        System.out.println("That way is blocked!");
                    }
                }
            }
        }
    }

    public void enter(Game game)
    {
        //These find what monster you're defending from
        String monster = monsters[(int) Math.random() * monsters.length];
        String adjective = adjectives[(int) Math.random() * adjectives.length];
        String modifier = "";
        //Checks if it starts with a vowel, in which case it adds an "n" to a
        if(monster.substring(0,1) == "A" ||monster.substring(0,1) == "E"||monster.substring(0,1) == "I"||monster.substring(0,1) == "O"||monster.substring(0,1) == "U")
        {
            modifier = "n";
        }
        //Checks if you're encountering a monster
        if(isSafe)
        {
            game.player.heal();
        }
        if(isMonster)
        {
            System.out.println("There is a"+modifier+" " + adjective +" "+ monster + " before you! /nWhat do you do?");
            action(game);
        }
        else
        {
            //Tells the player where they can go
            System.out.println("You see an opening to the");
            if(north)
            {
                System.out.print("north, ");
            }
            if(south)
            {
                System.out.print("south, "); 
            }
            if(east)
            {
                System.out.print("east, ");
            }
            if(west)
            {
                System.out.print("west, ");
            }
            if(game.player.row() == 0)
            {
                System.out.println("You see the end of the world to your north.");
                System.out.println("It would be wise not to walk off.");
            }
            if(game.player.row() == 4)
            {
                System.out.println("You see the end of the world to your south.");
                System.out.println("It would be wise not to walk off.");
            }
            if(game.player.column() == 0)
            {
                System.out.println("You see the end of the world to your west.");
                System.out.println("It would be wise not to walk off.");
            }
            if(game.player.column() == 3)
            {
                System.out.println("You see the end of the world to your east.");
                System.out.println("It would be wise not to walk off.");
            }
        }

    }
}

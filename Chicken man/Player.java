public class Player
{
    /** The user */
    private int hp;
    //Decided not to have a name because noboy cares about individuality in a MUD.
    //private String name;
    private int row;
    private int column;
    private boolean hasAchieved;
    private boolean hasShield;
    private boolean hasSword;
    private boolean isAlive = true;
    public Player()
    { 
        //Sets health and spawn
        hp = 500;
        row = 3;
        column = 1;
        hasAchieved = false;
    }

    public int rollDmg(int monsterRoll)
    {
        //Combat mechanic
        int roll = (int) (Math.random()*100);
        if(roll >= monsterRoll)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public void takeDamage(boolean boss)
    {
        //Combat mechanic
        int mod = 1;
        if(boss == true)
        {
            //Increases damage if the enemy is a boss
            mod = 2;
        }
        if(hasShield)
        {
            hp -= Math.random() * 75 * mod / 2;
        }
        else
        {
            hp -= Math.random() * 75 * mod;
        }   
    }

    public void heal()
    {
        //Mechanic to help player recover from combats
        hp += Math.random() * 125;
    }

    public void getSword()
    {
        //Gives player increased combat damage
        System.out.println( "After ripping out the mighty monster's organs and eating them, you find a Sword!" );
        System.out.println("Item gained: Sword (Increases combat damage) ");
        hasSword = true;
    }

    public void getShield()
    {
        //Reduces combat damage taken by player
        System.out.println( "You tear out the monster's skull, and it seems to be both sturdy and useful." );
        System.out.println("Item gained: Shield (decreases combat damage taken  ) ");
        hasShield = true;
    }
    /** All of these methods are returning the player's status */
    public boolean hasSword()
    {
        return hasSword;
    }

    public boolean hasShield()
    {
        return hasShield;
    }

    public boolean hasAchieved()
    {
        return hasAchieved;
    }

    public void achieve()
    {
        hasAchieved = true;
    }

    public int hp()
    {
        return hp;
    }

    public int row()
    {
        return row;
    }

    public int column()
    {
        return column;
    }
    
    /** All of these change the condition of the player, be it ending or movement */
    
    public void die(boolean condition)
    {
        //Checks if this condition of ending is death or winning
        if(condition = false)
        {
            System.out.println("GAME OVER");
        }
        else
        {
            System.out.println("Nice work!");
        }
        isAlive = false;
    }

    public void increaseRow()
    {
        row++;
    }

    public void increaseCol()
    {
        column++;
    }

    public void decreaseRow()
    {
        row--;
    }

    public void decreaseCol()
    {
        column--;
    }
}

public class Player
{
    private int hp;
    private String name;
    private int row;
    private int column;
    private boolean hasAchieved;
    private boolean hasShield;
    private boolean hasSword;
    private boolean isAlive = true;
    public Player(String name1)
    {
        name = name1; 
        hp = 500;
        row = 3;
        column = 1;
        hasAchieved = false;
    }

    public int rollDmg(int monsterRoll)
    {
        int roll = (int) Math.random()*100;
        return roll.compareTo(monsterRoll);
    }

    public void takeDamage()
    {
        if(hasShield)
        {
            hp -= Math.random() * 75 / 2;
        }
        else
        {
            hp -= Math.random() * 75;
        }
        if(hp < 0)
        {
            System.out.println("You have died from your body taking too much damage!");
            die();
        }
    }
    public void heal()
    {
        hp += Math.random() * 150;
    }
    public void getSword()
    {
        System.out.println( "After ripping out the mighty monster's organs and eating them, you find a Sword!" );
        System.out.println("Item gained: Sword (Increases combat damage) ");
        hasSword = true;
    }
    public void getShield()
        {System.out.println( "You tear out the monster's skull, and it seems to be both sturdy and useful." );
        System.out.println("Item gained: Shield (decreases combat damage taken  ) ");
        hasShield = true;
    }
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
    public void die()
    {
        System.out.println("GAME OVER");
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

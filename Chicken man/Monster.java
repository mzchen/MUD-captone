public class Monster
{
    /** The main opposition of the Player */
    private int hp;
    private boolean boss;
    private boolean subBoss;
    public Monster(boolean bosS, boolean subboss)
    {
        // Makes HP based on status
        hp = 75;
        boss= bosS;
        subBoss = subboss;
        if(boss)
        {
            hp = hp*10;
        }
        if(subBoss)
        {
            hp = hp*3;
        }
    }
    public void takeDamage()
    {
        //Damages the monster
        this.hp -= Math.random()*75;  
    }
    public boolean big()
    {
        //Returns if the monster is of significance
        if(boss||subBoss)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int hp()
    {
        //returns remaining health
        return hp;
    }
}

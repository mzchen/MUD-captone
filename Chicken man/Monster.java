public class Monster
{
    private int hp;
    private boolean boss;
    private boolean subBoss;
    public Monster(boolean bosS, boolean subboss)
    {
        hp = 75;
        boss= bosS;
        subBoss = subboss;
        if(boss)
        {
            hp = hp*4;
        }
        if(subBoss)
        {
            hp = hp*3;
        }
    }
    public void takeDamage()
    {
        this.hp -= Math.random()*75;  
    }
    public int hp()
    {
        return hp;
    }
}

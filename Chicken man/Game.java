import java.util.Scanner;
public class Game
{
    Land[][] map = new Land[5][4];

    Player player;
    public Game(String name)
    {
        player = new Player(name);
        map[0][0] = new Land(false, true, false, true, true, false, false, false, false, this);
        map[0][1] = new Land(false, true, true, false, false, true, false, false, false, this);
        map[0][2] = new Land(false, true, false, true, false, true, false, false, false, this);
        map[0][3] = new Land(false, false, true, false, true, false, false, false, true, this);
        //done
        map[1][0] = new Land(true, true, false, false, true, false, false, true, false, this);
        map[1][1] = new Land(true, true, false, true, true, true, false, false, false, this);
        map[1][2] = new Land(true, true, true, true, false, true, false, false, false, this);
        map[1][3] = new Land(false, true, true, false, true, false, false, false, false, this);
        //done
        map[2][0] = new Land(true, false, false, false, true, false, true, false, false, this); // ACHIEVEMENT ROOM
        map[2][1] = new Land(true, false, false, true, false, true, false, false, false, this);
        map[2][2] = new Land(true, true, true, false, true, true, false, false, false, this);
        map[2][3] = new Land(false, true, false, false, false, true, false, false, false, this);
        //done
        map[3][0] = new Land(false, true, false, true, false, false, false,false, false, this);
        map[3][1] = new Land(true, true, true, true, false, true, false, false, false, this); // SPAWN ROOM
        map[3][2] = new Land(true, true, true, false, true, false, false, false, false, this);
        map[3][3] = new Land(false, true, true, false, true, false, false,   false, false, this);
        //done
        map[4][0] = new Land(true, false, false, false, true, false, false, false, false, this);
        map[4][1] = new Land(true, false, false, false, false, true, false, false, false, this);
        map[4][2] = new Land(true, false, false, true, false, true, false, false, false, this);
        map[4][3] = new Land(true, false, false, false, true, false, false, false, false, this);
        //done
                    //My initial intention was to make a random map for each game, but I realized it was beyond my
                    //skill level to create 20 random lands, make sure each had an opening that lead to another, and
                    //balance how many monsters there were in the game. I also could not be able to decide how to
                    //ensure there would only be one boss. Therefore, I decided to hard code a map.
        //         for(int x = 0;x<map.length; x++)
        //         {
        //             for (int y = 0; y<map[0].length; y++)
        //             {
        //                 map[x][y]=new Land();
        //             }
        //         }

    } 
    //public update()
    //{

    //}

}

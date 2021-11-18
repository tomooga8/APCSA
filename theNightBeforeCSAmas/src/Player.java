import java.util.*;

public class Player
{
    //these are just examples of instance variables
    //you can change these if you want to
    String name;
    int health;
    double gold;
    int points;

    public Player()
    {
        name = null; //gets set later when asked in textAdventure
        health = 10;
        points = 0;
    }



    public void changeName(String newName)
    {
        name = newName;
    }
    public String getName() {return name;}

    public int getHealth()
    {
        return health;
    }

    public double getGold()
    {
        return gold;
    }


    public void takeDamage() {
        health -= 2;
        if (health <= 0) {
            //game end function to be made in TextAdventure
        }
    }

    public void gainExamPoint(double newAmount) {points++;}

}
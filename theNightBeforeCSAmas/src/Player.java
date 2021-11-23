import java.util.*;
import java.util.concurrent.TimeUnit;

public class Player
{
    //these are just examples of instance variables
    //you can change these if you want to
    String name;
    int health;
    double gold;

    public Player()
    {
        name = null; //gets set later when asked in textAdventure
        health = 10;
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


    public void takeDamage(int num) throws InterruptedException {
        health -= num;

        if (health <= 0) {
            System.out.println("You have run out of health. Game Over. Would you like to retry? (Y/N)");
            String input = new Scanner(System.in).nextLine();
            if (input.equals("Y")) Main.adventure.play();
            else {
                System.out.println("Okay! See you later! ");
                TimeUnit.SECONDS.sleep(1);
                Main.adventure.console.gameWindow.dispose();
            }
        } else System.out.println("You're new health is: " + health);
    }

}
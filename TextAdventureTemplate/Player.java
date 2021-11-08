import java.util.*;

public class Player
{
  //these are just examples of instance variables
  //you can change these if you want to
  String name;
  int health;
  double gold;
  int points;

  public Player(String playerName)
  {
    name = playerName;
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
      TextAdventure.gameEnd();
    }
  }

  public void gainExamPoint(double newAmount) {points++;}

}
import java.util.*;

public class TextAdventure {
  //Instance variables of a class can also be objects
  FancyConsole console;
  Scanner inScanner;
  public Player ourHero;

  public TextAdventure(){
    //This creates the UI console that the user
    //can type in
    console = new FancyConsole("Great Text Adventure!", 600, 600);
    inScanner = new Scanner(System.in);

    //feel free to change the player's starting values
    //depending on your story
    ourHero = new Player(null);
  }

  public void play() {
    String input;
    //Start of adventure. You can change this if you like
    //You can also import your own images!
    console.setImage("classroom.jpg");

    // ask the user for their name.
    System.out.println("What is your name?\n");
    input = inScanner.nextLine();

    // Change ourHero's name
    // ADD CODE HERE
    ourHero.changeName(input);
    // describe the starting situation. Feel free to change this as well
    System.out.println("In this APCSA text adventure you will need to defeat bosses to collect 5 points to win. Lets Start! Good luck :] \n");
    console.setImage("classroom.jpg");
    System.out.println("You wake up in an empty classroom, its dark and it cold, you can see the door to the hallway. \n" +
            "As you walk into the hallway, you can either go straight, left or right, which way do you want to go?");
    System.out.println("A. Straight\nB. Left\nC.Right");
    input = inScanner.nextLine();
    if (input.toUpperCase() == "A") enterZone1();
    else if (input.toUpperCase() == "B") enterZone2();
    else enterZone3();

    // get user input and go to the appropriate zone based on their input
    // ADD CODE HERE

  }

  private void enterZone1(){
    // change image

    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE

  }

  private void enterZone2(){
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone3(){
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone4(){
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone5(){
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  //You can also add other methods here if it 
  //serves your story to do so - it's up to you
  //how creative you want to get

  public static void gameEnd()
  {
    // ADD CODE HERE

  }
}
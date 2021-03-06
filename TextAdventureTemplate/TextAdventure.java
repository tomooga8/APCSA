import java.util.*;
import java.util.concurrent.TimeUnit;


public class TextAdventure {
  //Instance variables of a class can also be objects
  FancyConsole console;
  Scanner inScanner;
  public Player ourHero = new Player(null);

  public TextAdventure(){
    //This creates the UI console that the user
    //can type in
    console = new FancyConsole();
    inScanner = new Scanner(System.in);

    //feel free to change the player's starting values
    //depending on your story

  }

  public void play() throws InterruptedException {
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
    System.out.println("Hi " + ourHero.getName());
    console.setImage("classroom.jpg");
    System.out.println("You wake up in an empty classroom, \nits dark and it cold, you can see the door to the hallway. \n" +
            "As you walk into the hallway, you can either go \nstraight, left or right, which way do you want to go?");

    console.setImage("hallway.jpg");
    System.out.println("A. Straight\nB. Left\nC. Right");
    System.out.println("Enter Choice: ");
    input = inScanner.nextLine();
    if (input.equals("A")) enterZone1();
    else if (input.equals("B")) enterZone2();
    else if (input.equals("C")) enterZone3();

    // get user input and go to the appropriate zone based on their input
    // ADD CODE HERE

  }

  private void enterZone1() throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(500);
    // change image
    console.setImage("priya.jpeg");
    // ADD CODE HERE
    System.out.println("A wild Priya appears!! She uses her Private Primitive Pistol to try and attack you!");
    System.out.println("What do you counter with?");
    System.out.println("A. Access Modifier Defense");
    System.out.println("B. ");
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("this is Zone 1");
    // Take action or go to another zone based on their choice
    // ADD CODE HERE

  }

  private void enterZone2(){
    // change image
    // ADD CODE HERE
    System.out.println("This is zone 2"); //boolean blaster for Simran
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone3(){
    // change image
    // ADD CODE HERE
    System.out.println("This is zone 3");
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
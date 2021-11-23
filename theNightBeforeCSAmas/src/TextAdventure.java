import java.util.*;
import java.util.concurrent.TimeUnit;


public class TextAdventure {
    //Instance variables of a class can also be objects
    FancyConsole console;
    Scanner inScanner;
    Player ourHero = new Player();
    String input;

    public TextAdventure(){
        //This creates the UI console that the user
        //can type in
        console = new FancyConsole();
        inScanner = new Scanner(System.in);


        //feel free to change the player's starting values
        //depending on your story

    }

    public void play() throws InterruptedException {

        //Start of adventure. You can change this if you like
        //You can also import your own images!
        console.setImage("code.jpeg");

        // ask the user for their name.
        System.out.println("What is your name?\n");
        input = inScanner.nextLine();

        // Change ourHero's name
        // ADD CODE HERE
        ourHero.changeName(input);
        // describe the starting situation. Feel free to change this as well
        System.out.println("Hi " + ourHero.getName());
        TimeUnit.SECONDS.sleep(1);
        console.setImage("spookyclassroom.jpeg");
        System.out.println("You wake up in an empty classroom, \nits dark and it cold, you can see the door to the hallway. \n"); //describes the first "area"
        TimeUnit.SECONDS.sleep(1); //used to "timeout" so that everything does not print at once and there are pauses
        System.out.println("As you walk into the hallway, you can either go \nstraight, left or right, which way do you want to go?");
        System.out.println("A. Straight\nB. Left\nC. Right");
        System.out.println("Enter Choice: ");
        input = inScanner.nextLine();
        if (input.equals("A")) enterZone1();
        else if (input.equals("B")) enterZone1();
        else if (input.equals("C")) enterZone1();

        //all options lead to the same place... ehehe

    }

    private void enterZone1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        // change image
        console.setImage("priya.jpeg"); //sets the console to an image of priya
        // ADD CODE HERE
        System.out.println("A wild Priya appears!! She uses her Private Primitive Pistol to try and attack you!");
        System.out.println("What do you counter with?");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("A. Access Modifier Defense");
        System.out.println("B. A Null Nunchuck");
        System.out.println("C. A true boolean trap");
        System.out.println("D. A super static sickle\n");

        do {
            System.out.println("What do you choose? \n");
            TimeUnit.SECONDS.sleep(1);
            input = inScanner.nextLine();
            if (input.equals("B") || input.equals("C") || input.equals("D")) { //would be easier to use a not statement but used or statements to satisfy rubric requirement
                System.out.println("Oh no! You're counter move did not work!\n");
                ourHero.takeDamage(1); //takes away health from the ourHero object
            }
        } while (!input.equals("A")); //while the answer is not a, the loop repeats to ask for another answer

        System.out.println("You're countermove was effective! Priya is now incapacitated.\n");
        console.setImage("priyaIncapacitated.jpg"); //sets the console to an image of priya incapacitated

        TimeUnit.SECONDS.sleep(1);

        System.out.println("\n\n\n\n\n\n\n\n\n\nYou walk down the hallway...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Its getting colder...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Something is not right... ");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("You see something moving in the corner ANNNDDDDD\n\n\n\n\n\n\n");
        enterZone2(); //enters the next zone



    }

    private void enterZone2() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        console.setImage("abbey.jpeg"); //cannot get portrait images to scale correctly and therefore they rotate
        System.out.println("Abbey appears... She uses her bit blast to attack you!");
        System.out.println("What do you counter and attack with?");

        System.out.println("A. Access Modifier Defense");
        System.out.println("B. A Null Nunchuck");
        System.out.println("C. A true boolean trap");
        System.out.println("D. A super static sickle\n");

        do {
            System.out.println("What do you choose? \n");
            TimeUnit.SECONDS.sleep(1);
            input = inScanner.nextLine();
            if (!input.equals("B")) {
                System.out.println("Oh no! You're counter move did not work!\n");
                ourHero.takeDamage(2); //takes 2 damage each time as it is a "harder" level
            }
        } while (!input.equals("B")); //same as with the last method but here the right answer is B

        System.out.println("You're countermove was effective! Abbey is now incapacitated.\n");
        console.setImage("abbeyincapacitated.jpg"); //sets console image to abbey incapacitated
        TimeUnit.SECONDS.sleep(1);
        System.out.println("You go back down the hallway");
        console.setImage("spookyhallway1.jpeg"); //sets the console to a spooky hallway
        TimeUnit.SECONDS.sleep(1);
        enterZone3(); //enters the next zone

    }

    private void enterZone3() throws InterruptedException{
        System.out.println("Shanzay appears! She uses her static sythe and tries to attack you");
        console.setImage("shanzay.jpeg"); //sets the console to an image of shanzay
        TimeUnit.SECONDS.sleep(1);
        System.out.println("What do you counter and attack with?");

        System.out.println("A. Access Modifier Defense");
        System.out.println("B. A Null Nunchuck");
        System.out.println("C. A true boolean trap");
        System.out.println("D. A nonstatic sickle\n");

        do {
            System.out.println("What do you choose? \n");
            TimeUnit.SECONDS.sleep(1);
            input = inScanner.nextLine();
            if (!input.equals("D")) {
                System.out.println("Oh no! You're counter move did not work!\n");
                ourHero.takeDamage(3); //takes 3 damage each time as it is a "harder" level
            }
        } while (!input.equals("D")); //loops while the answer is not D

        System.out.println("You're countermove was effective! Sanzay is now incapacitated");
        console.setImage("shanzayincapacitated.jpg"); //sets the image to shanay incapacitated
        TimeUnit.SECONDS.sleep(1);
        console.setImage("spookyhallway1.jpeg"); //sets the console to a spooky hallway

        System.out.println("You go back down the hall and on ur way to the exit, ");
        enterZone4();

    }

    private void enterZone4() throws InterruptedException{
        TimeUnit.SECONDS.sleep(1);
        System.out.println("A spooky simran appears! She tries to use her boolean bazooka and tries to attack you");
        console.setImage("simran.jpeg"); //sets the console to simran

        TimeUnit.SECONDS.sleep(1);
        System.out.println("What do you counter and attack with?");

        System.out.println("A. Access Modifier Defense");
        System.out.println("B. A Null Nunchuck");
        System.out.println("C. A true boolean trap");
        System.out.println("D. A nonstatic sickle\n");

        do {
            System.out.println("What do you choose? \n");
            TimeUnit.SECONDS.sleep(1);
            input = inScanner.nextLine();
            if (!input.equals("C")) {
                System.out.println("Oh no! You're counter move did not work!\n");
                ourHero.takeDamage(4); //takes 4 damage each time as it is a "harder" level
            }
        } while (!input.equals("C")); //loops while c is not inputted

        TimeUnit.SECONDS.sleep(1);
        System.out.println("You're move was effective! Simran is now incapacitated!");
        console.setImage("simranincapacitated.jpg");//shows console image of simran incapacitaterd
        TimeUnit.SECONDS.sleep(1);
        console.setImage("door.jpeg");
        System.out.println("You think you have escaped. The door is so close by! All of a sudden.... \n\n");

        enterZone5(); //enters next zone with ms fournier

    }

    private void enterZone5() throws InterruptedException{
        TimeUnit.SECONDS.sleep(1);
        console.setImage("msfournier.jpeg"); //shows an image of ms fournier to the console
        System.out.println("Ms. Fournier Appears! She uses her AP Axe and tries to attack you.");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("What do you counter and attack with?");
        System.out.println("A. Boolean Boomerang");
        System.out.println("B. Static Sword");
        System.out.println("C. Super Static Method Machete");
        System.out.println("D. AP Axe Defense\n"); //trick answer BAHA

        do {
            System.out.println("What do you choose? \n");
            TimeUnit.SECONDS.sleep(1);
            input = inScanner.nextLine();
            if (!input.equals("C")) {
                System.out.println("Oh no! You're counter move did not work!\n");
                int numDamage = (int)(Math.random()*4) + 1; //range of 1-4 inclusive
                ourHero.takeDamage(numDamage); //takes a random ammount of damage from 1 through 4
            }
        } while (!input.equals("C")); //loops while C is not inputted

        System.out.println("You have defeated Ms. Fournier!!!");
        System.out.println("You have defeated all 5 bosses, earning you a five on the ap exam.");
        System.out.println("Would you like to play again? (Y/N)");
        input = inScanner.nextLine();

        if (input.equals("Y")) play(); //goes through the text adventure again if Y is pressed
        else Main.adventure.console.dispose(); //closes out the program if not Y




    }
}
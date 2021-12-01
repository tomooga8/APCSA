import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        // Choose a random number from 0-100
        int randNum = (int) (Math.random()*99) + 1;
        System.out.println("Computer randNum: " + randNum);

        // Ask the user to guess a number from 0 to 100
        System.out.println("Guess a number from 0 to 100: ");

        // Get the first guess using scan.nextInt();
        int input = scan.nextInt();

        // Loop while the guess does not equal the random number,
        while (randNum != input){
            if (input < randNum) System.out.println("Too low!");
            else if (input > randNum) System.out.println("Too high!");
            else {
                System.out.println("You got it!");
                break;
            }
            System.out.println("Guess again: ");
            randNum = scan.nextInt();
        }
        // If the guess is less than the random number, print out "Too low!"

        // If the guess is greater than the random number, print out "Too high!"

        // Get a new guess (save it into the same variable)


        // Print out something like "You got it!"


    }
}

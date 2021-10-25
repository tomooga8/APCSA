/**
 * Create a new project and class and call them both Coins. Use the following template (or something similar) to write a program that gives exact change with the least number of coins for a given number of cents. Use variables to help your calculation (Hint: This is similar to program we created in C last year!).
 *
 * public static void main(String[] args){
 *    int totalCents = 137;  //137 can be any number
 *    …..
 *    // your code here.
 *
 * }
 *
 * Output of 137 cents: 5 quarters, 1 dimes, 0 nickels, 2 pennies.
 */

public class main {
    public static void main(String[] args){
        int totalCents = 137;
        int quarters = 137/25;
        int tempRemainder = 137 % 25;
        int dimes = tempRemainder / 10;
        tempRemainder = tempRemainder % 10;
        int nickels = tempRemainder / 5;
        tempRemainder = tempRemainder % 5;
        int pennies = tempRemainder;

        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickels: " + nickels);
        System.out.println("Pennies: " + pennies);

    }
}

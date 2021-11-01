import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Rock! Paper! Scissors! Shoot: ");
        String userMove = myScanner.nextLine();
        String randomMove = randomMove();
        System.out.println("Your move: " + userMove);
        System.out.println("Computer Move: " + randomMove);
        whoWon(userMove, randomMove);
    }
    public static String randomMove(){
        int randNum = (int) (Math.random()*3 + 1);
        if (randNum == 1) return "rock";
        else if (randNum == 2) return "paper";
        else return "scissors";
    }

    public static void whoWon(String userMove, String computerMove){
        if (userMove.equals(computerMove)){
            System.out.println("Tie!");
        } else if (userMove.equals("rock") && computerMove.equals("paper")){
            System.out.println("You Lost");
        } else if (userMove.equals("rock") && computerMove.equals("scissors")){
            System.out.println("You Won!");
        } else if (userMove.equals("paper") && computerMove.equals("scissors")){
            System.out.println("You Lost");
        } else if (userMove.equals("paper") && computerMove.equals("rock")){
            System.out.println("You Won!");
        } else if (userMove.equals("scissors") && computerMove.equals("rock")){
            System.out.println("You Lost");
        } else if (userMove.equals("scissors") && computerMove.equals("paper")){
            System.out.println("You won!");
        }
    }
}

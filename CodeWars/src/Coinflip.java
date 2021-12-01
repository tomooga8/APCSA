import java.util.Scanner;
public class Coinflip{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Guess how many times the coin will produce heads: ");
        int input = myScanner.nextInt();
        int count = flips();
        System.out.println("The coin has flipped a thousand times. You gussed that the number of heads would be: " + input);
        System.out.println("The real number of heads was: " + count);
        if (input == count){
            System.out.println("You're guess was correct!");
        } else{
            System.out.println("You're guess was not correct");
        }
    }
    public static int flips(){
        int count = 0;
        for (int i = 0; i < 1000; i++){
            int flip = (int)(Math.round(Math.random()));
            if (flip == 0) count ++;
            if (i == 100) System.out.println("At flip 100: " + count);
            if (i == 500) System.out.println("At flip 500: " + count);
            if (i == 900) System.out.println("At flip 900: " + count);
        }
        return count;
    }
}

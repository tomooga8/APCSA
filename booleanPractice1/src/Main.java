import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        int x = 4;
        int y = 3;
        int z = 2;
        System.out.println(max(x,y,z));
        System.out.println(Math.max(x, Math.max(y,z)));
        System.out.println(isPerfectSquare(4));

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Ask a question: ");
        myScanner.nextLine();
        magic8Ball();


    }
    public static int max(int x, int y, int z){
        if (x > y && y > z){
            return x;
        }
        else if (y > z && z > z){
            return y;
        }
        else {
            return z;
        }
    }
    public static boolean isPerfectSquare(int n){
        if (Math.pow(Math.round(Math.sqrt(n)), 2) == n){
            return true;
        } else {
            return false;
        }
    }
    public static void magic8Ball(){
        int randNum = (int) (Math.random()*9 + 1);

        if (randNum == 1){
            System.out.println("BAHAHA \n \n \n \n...\n\n\n\n no");
        }
        if (randNum == 2){
            System.out.println("Concentrate and ask again");
        }
        if (randNum == 3){
            System.out.println("Cannot predict now");
        }
        if (randNum == 4){
            System.out.println("It is indeed a bones day");
        }
        if (randNum == 5){
            System.out.println("Signs point to yes");
        }
        if (randNum == 6){
            System.out.println("It is indeed not a bones day");
        }
        if (randNum == 7){
            System.out.println("Better not tell you now");
        }
        if (randNum == 8){
            System.out.println("no lol <3");
        }

    }
}

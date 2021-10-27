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
}

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("What number: ");
        int num = input.nextInt();

        System.out.println("Number of Factors: " + countFactors(num));
        System.out.println("Is it prime: " + isPrime(num));
        System.out.println("Number of primes: " + countPrimes(num));
    }
    //Write a static method countFactors that accepts an integer parameter, and returns the number of factors of the integer.
    public static int countFactors(int integer){
        int count = 0;
        for (int i = 1; i <= integer; i++) if (integer % i == 0) count++;
        return count;
    }
    //Write a static method isPrime which returns whether or not an integer is prime. This method must call countFactors.
    public static boolean isPrime(int integer){
        if (countFactors(integer) == 2) return true;
        else return false;
    }

    // Write a static method countPrimes that accepts an integer parameter n and returns the number of primes from 2 to n.
    public static int countPrimes(int n){
        int count = 0;
        for (int i = 2; i <= n; i++) if (isPrime(i)) count++;
        return count;
    }
}

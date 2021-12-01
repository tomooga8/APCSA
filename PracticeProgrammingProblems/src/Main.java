import java.util.Scanner;
public class Main {
    public static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println(addOdds(1000));
        population();
        fourHeads();
        int numMonths = Sebastian();
        System.out.println((numMonths/12) + " Months and " + (numMonths % 12) + " days." );
    }

    public static int addOdds(int n){
        int count = 0;
        for (int i = 0; i <= n; i++) if (i % 2 != 0) count++;
        return count;
    }


    public static void population(){
        int startingYear = 2014;
        double startingPopulation = 123.8;

        System.out.println("Enter a number for target population (in millions): ");
        double targetPopulation = myScanner.nextDouble();

        int numYears = 0;
        while (startingPopulation < targetPopulation) {
            startingPopulation *= 1.05;
            numYears++;
        }
        System.out.println("You will reach that population in year " + (2014 + numYears));
    }


    public static void fourHeads(){
        int headCount = 0;
        boolean fourHeads = false;
        while (!fourHeads){
            int randFlip = (int) Math.round(Math.random());
            if (randFlip == 0){
                System.out.print("H ");
                headCount++;
                if (headCount==4) break;
            } else {
                System.out.print("T ");
                headCount = 0;
            }
        }
        System.out.println("\nFour Heads in a Row!");
    }

    public static int Sebastian(){
        int countMonths = 0;
        int knowledgeToLearn = 100;
        while (knowledgeToLearn > 5) {
            knowledgeToLearn -= knowledgeToLearn * 0.1;
            countMonths++;
        }
        return countMonths;
    }
}

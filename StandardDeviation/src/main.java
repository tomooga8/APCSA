/**
 * Create a new BlueJ project and class named Statistics and follow the comments below to write a program that computes some statistics.
 *
 * Declare 3 int variables for grades and initialize them to 3 values
 * Declare an int variable for the sum of the grades
 * Declare a double variable for the average of the grades
 * Write a formula to calculate the sum of the 3 grades
 * Write a formula to calculate the average of the 3 grades from the sum using division and type casting
 * Print out the average
 * Declare a double variable and calculate the variance (you might find it helpful to first create 3 separate variables holding the value of the differences of each score from the mean)
 * Declare a double variable to compute the standard deviation
 * Can you print both the variance and standard deviation to the screen so that they only carry out 2 decimal places? (Hint: printf can be used in Java also...do some research)
 */

public class main {
    public static void main(String[] args){
        int gradeOne = 98;
        int gradeTwo = 89;
        int gradeThree = 98;
        int gradeSum = gradeOne + gradeTwo + gradeThree;
        double gradeAverage = (double) gradeSum / 3;
        System.out.println("Average: " + gradeAverage);

        double differenceOne = Math.abs(gradeOne - gradeAverage);
        double differenceTwo = Math.abs(gradeTwo - gradeAverage);
        double differenceThree = Math.abs(gradeThree - gradeAverage);
        double differenceSum = differenceOne + differenceTwo + differenceThree;
        double squaredDifference = Math.pow(differenceSum, 2);
        double standardDeviation = Math.sqrt(squaredDifference / 3);

        System.out.printf("%.2f", standardDeviation);



    }
}

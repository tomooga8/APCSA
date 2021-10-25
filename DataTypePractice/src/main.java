/**
 * Instructions for Project:
 * For you to do:
 * Create a new BlueJ project called “DatatypePractice” and create the appropriate class file as well
 * Create a String variable called “name” and set it equal to your own name
 * Create an integer variable called “age” and set it equal to your own age
 * Create an integer variable called “firstTestScore” and set it equal to a test score of your choice
 * Create an integer variable called “secondTestScore” and set it equal to a test score of your choice
 * Create an integer variable called “thirdTestScore” and set it equal to a test score of your choice
 *
 * Create an double variable called “average” and set it equal to the average of your three test scores
 * (remember your C for your arithmetic operators, as well as order of operations)
 * Use your variables to print “My name is ________ and I am ________ years old.”
 * On a new line, use your average variable to print “The average of my test scores for this class is: _______”
 */

public class main {
    public static void main(String[] args){
        String name = "Tomo";
        int age = 14;
        int firstTestScore = 90;
        int secondTestScore = 92;
        int thirdTestScore = 87;
        double average = (firstTestScore + secondTestScore + thirdTestScore) / 3;

        System.out.println("My name is " + name + " and I am " + age + " years old.");
        System.out.println("The average of my test scores for this class is: " + average);
    }
}

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Lets Calculate your BMI!");
        System.out.println("Height: ");
        double height = myScanner.nextDouble();
        System.out.println("Weight: ");
        double weight = myScanner.nextDouble();
        System.out.println("\nHeight (in inches): " + height);
        System.out.println("Weight (in pounds): " + weight);
        double bmi = calculateBMI(height, weight);
        String weightClass = weightClass(bmi);
        System.out.printf("BMI: %.2f", bmi);
        System.out.println("\n" + weightClass);

    }
    public static double calculateBMI(double height, double weight){
        return (weight/Math.pow(height, 2)) * 703;
    }
    public static String weightClass(double bmi){
        if (bmi < 18.5) return "underweight";
        else if (bmi >= 18.5 && bmi <=25) return "normal";
        else if (bmi >= 25 && bmi <= 30) return "overweight";
        else return "obese";
    }

}

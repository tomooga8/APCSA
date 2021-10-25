import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner name = new Scanner(System.in);

	    System.out.println("What is your name?");

        String firstname = name.nextLine();

        System.out.println("Hello, " + firstname + "!");
    }
}

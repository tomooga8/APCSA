import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner nameObj = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = nameObj.nextLine();

        personExample tomo = new personExample(name, "toga@hillers.org", "5084397701");
        personExample.printPersonCounter();

    }
}

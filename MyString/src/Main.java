import java.util.*;
public class Main {
    public static void main(String[] args){
        welcome();
        int myArray[] = {15,20,30,40};
        Scanner scanString = new Scanner(System.in);
        System.out.println("Please enter a new string:");
        String theWord = scanString.nextLine();

        int wordLength = theWord.length();
        System.out.println(wordLength);
        System.out.println(theWord.substring(wordLength - 1));
        System.out.println(theWord.indexOf("a"));
        System.out.println(theWord.toUpperCase());
        scanString.close();
        Integer max = Integer.MAX_VALUE;
        Integer numtwo = 10;
        System.out.println(numtwo);

    }
    public static void welcome(){
        System.out.println("Hello!");
    }
}

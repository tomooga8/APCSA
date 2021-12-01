import java.util.*;
public class Main {
    //Given a string, write a method that returns whether the string is a palindrome
    //(reads the same forward as backwards, like the word “racecar”). Test your method in a main method.
    public static void main(String[] args){
        Scanner myInput = new Scanner(System.in);
        System.out.println("String: ");
        String input = myInput.nextLine();
        System.out.println(isPalindrome(input));

    }
    public static boolean isPalindrome(String input){
        for (int i = 0; i <= (input.length()-1); i++) if(input.charAt(i) != input.charAt(input.length() -1 - i)) return false;
        return true;
    }
}

import java.util.*;

public class PotatoHead {
    private String hat; //declaring the instance variables of the PotatoHead class
    private String eyes;
    private int age;

    //declaration of variables for the overloaded constructor:
    private int height;
    private String hair;

    //default constructor
    public PotatoHead(){
       

    }
    //Constructor for objects of class PotatoHead
    public PotatoHead(String hisHat, String hisEyes, int hisAge){
        //initialize instance variables
        hat = hisHat;
        eyes = hisEyes;
        age = hisAge;
    }
    //overloaded constructor
    public PotatoHead(String hisHair, int hisHeight){
        height = hisHeight;
        hair = hisHair;
    }

    public static void objectFriends(){
        System.out.println("My Objects are all friends!");
    }

    //getter methods
    public String getHat() {
        return hat;
    }
    public int getAge() {
        return age;
    }
    public String getEyes() {
        return eyes;
    }
    public int getHeight() {
        return height;
    }

    //setter methods
    public void setAge(int newAge) {
        age = newAge;
    }
    public void setEyes(String newEyes){
        eyes = newEyes;
    }


    public static double averageTheirAges(int age1, int age2, int age3){
        double totalAge = (double)(age1 + age2 + age3)/3;
        return totalAge;
    }
}

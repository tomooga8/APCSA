import java.util.Arrays;

public class Main {

    public static void print(String input){
        System.out.println(input);
    }
    public static void print(int input){
        System.out.println(input);
    }
    public static void print(double input){
        System.out.println(input);
    }
    public static void main(String[] args) throws Exception{
        myRectangle rectangle1 = new myRectangle(15, 20);
        myRectangle rectangle2 = new myRectangle(15, 20);

        int myRectangle1Length = rectangle1.getLength();
        int myRectangle2Length = rectangle2.getLength();

        //what prints is different because this method is called on different objects,
        //takes no parameters, but returns a different result depending on the object it
        //is called on
        System.out.println(myRectangle1Length);
        System.out.println(myRectangle2Length);


        int myRectangle1Area = rectangle1.computeAreaRectangle();
        int myRectangle2Area = rectangle2.computeAreaRectangle();

        if (myRectangle1Area > myRectangle2Area) {
            System.out.println("Area1 is bigger than Area2!");
        } else if (myRectangle2Area == myRectangle1Area){
            System.out.println("Area1 and Area2 are the same!");
        } else {
            System.out.println("Area2 is greater than Area1!");
        }

        System.out.println(myRectangle1Area);
        System.out.println(myRectangle2Area);
        //again, to reiterate, the method returns different results as it is called on
        //different objects

        myRectangle.whichAreaLarger(myRectangle1Area, myRectangle2Area);

        int myRectangle1Volume = rectangle1.volumeIfRectangle3D(15);
        int myRectangle2Volume = rectangle2.volumeIfRectangle3D(15);

        System.out.println(myRectangle1Volume);
        System.out.println(myRectangle2Volume);
        //the method knows this because its nonstatic --> this means that the
        //the method has access to the instance variables of the object that its called
        //on. the volumeIfRectangle3D nonstatic method has access to length and width
        //already, meaning that the user calling this method does not need to call it

        int myRectangle1Perimeter = rectangle1.getPerimeter();
        int myRectangle2Perimeter = rectangle2.getPerimeter();

        //getter methods are used when you need to manipulate an attribute of an object
        //in some way --> this would be useful if you needed to do this once

        myRectangle myBiggerRectangle = myRectangle.theBiggerRectangle(rectangle1, rectangle2);
        System.out.println("The area of my bigger rectangle is: " + myBiggerRectangle.computeAreaRectangle());
    }

}

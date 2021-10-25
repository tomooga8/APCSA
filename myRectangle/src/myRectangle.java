public class myRectangle {

    //instance variables:
    private int length;
    private int width;
    //constructor:
    public myRectangle(int itsLength, int itsWidth){
        length = itsLength;
        width = itsWidth;
    }

    //getter methods
    public int getLength(){
        return length;
    }
    public int getWidth(){
        return width;
    }
    //the reason why these methods are truly nonstatic is because it returns
    //different results depending on the object its called on.

    //nonstatic method to compute area of a rectangle object:
    public int computeAreaRectangle(){
        return length*width;
    }

    public static void whichAreaLarger(int area1, int area2){
        if (area1 > area2) {
            System.out.println("Area1 is bigger than Area2!");
        } else if (area1 == area2){
            System.out.println("Area1 and Area2 are the same!");
        } else {
            System.out.println("Area2 is greater than Area1!");
        }
    }
    //a parameter that is fed into a nonstatic method is typically manipulated
    //with the instance variables of the object that it has access to
    public int volumeIfRectangle3D(int height){
        return length*width*height;
    }

    public int getPerimeter(){
        return (length + width) * 2;
    }

    public static myRectangle theBiggerRectangle(myRectangle rectangle1, myRectangle rectangle2) throws Exception {
        int areaOfRectangle1 = rectangle1.computeAreaRectangle();
        int areaOfRectangle2 = rectangle2.computeAreaRectangle();
        if (areaOfRectangle1 > areaOfRectangle2){
            return rectangle1;
        } else if (areaOfRectangle2 > areaOfRectangle1){
            return rectangle2;
        } else {
            throw new Exception("TheAreasAreTheSameException");
        }
    }

}

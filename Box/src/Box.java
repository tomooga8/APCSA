public class Box {
    //constructor
    private String color;

    //instance variable
    public Box(String boxColor){
        color = boxColor;
    }

    public String getColor(){
        return color;
    }

    //I used a nonstatic method because we are changing the instance variable of an object
    public void changeToRed(){
        color = "Red";
    }

    public static boolean isSameColor(String color1, String color2){
        if (color1 == color2){
            return true;
        } else {
            return false;
        }
    }


}

public class Main {
    public static void main(String[] args){
        Box userBox = new Box("Purple");
        Box userBox2 = new Box("Red");

        userBox.changeToRed();

        boolean colorsTheSame = Box.isSameColor(userBox.getColor(), userBox2.getColor());


    }


}


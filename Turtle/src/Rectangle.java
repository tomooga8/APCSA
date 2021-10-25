public class Rectangle {
    private int sideA;
    private int sideB;

    public Rectangle(int Aside, int Bside){
        sideA = Aside;
        sideB = Bside;
    }

    public int getSideA(){
        return sideA;
    }
    public int getSideB(){
        return sideB;
    }
    public int computeAreaRectangle(){
        int area = sideA * sideB;
        return area;
    }

}

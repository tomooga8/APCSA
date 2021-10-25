public class Circle {
    private double r;

    public Circle(double radius){
        r = radius;
    }

    public static double getArea(double r){
        double area = 3.1415 * r * r;
        return area;
    }

    //getter methods

    public double getRadius(){
        return r;
    }
}

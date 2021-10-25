public class Main {
    public static void main(String[] args){
        Circle cutie = new Circle(6);
        double cutieRadius = cutie.getRadius();
        double area = Circle.getArea(cutieRadius);
        System.out.printf("Area: %.2f", area);
    }
}
